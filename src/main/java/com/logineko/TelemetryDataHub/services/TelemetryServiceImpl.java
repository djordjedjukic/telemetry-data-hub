package com.logineko.TelemetryDataHub.services;

import com.logineko.TelemetryDataHub.infrastructure.Constants;
import com.logineko.TelemetryDataHub.infrastructure.filter.Filter;
import com.logineko.TelemetryDataHub.infrastructure.filter.FiltersRegistry;
import com.logineko.TelemetryDataHub.model.csv.CombineData;
import com.logineko.TelemetryDataHub.model.csv.TractorData;
import com.logineko.TelemetryDataHub.model.domain.Combine;
import com.logineko.TelemetryDataHub.model.domain.Machine;
import com.logineko.TelemetryDataHub.model.domain.Tractor;
import com.logineko.TelemetryDataHub.model.dto.FilterCondition;
import com.logineko.TelemetryDataHub.model.dto.telemetry.CombineDto;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TelemetryResponse;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TractorDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentQuery;
import net.ravendb.client.documents.session.IDocumentSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelemetryServiceImpl implements TelemetryService {

    private final FiltersRegistry filtersRegistry;
    private final IDocumentStore store;

    public TelemetryServiceImpl(FiltersRegistry filtersRegistry, IDocumentStore store) {
        this.filtersRegistry = filtersRegistry;
        this.store = store;
    }


    @Override
    public void importData(InputStream file, String fileName) throws Exception {
        List<?> machineList = readCsv(file, fileName);
        try (IDocumentSession docSession = store.openSession()) {
            processMachineList(docSession, machineList, fileName);
            docSession.saveChanges();
        }
    }

    private void processMachineList(IDocumentSession session, List<?> machineList, String fileName) throws ParseException {
        for (Object obj : machineList) {
            if (fileName.startsWith(Constants.TRACTOR_DATA_FILE_NAME)) {
                session.store(((TractorData) obj).toDomain());
            } else if (fileName.startsWith(Constants.COMBINE_DATA_FILE_NAME)) {
                session.store(((CombineData) obj).toDomain());
            }
        }
    }

    public List<Filter> getPossibleFilters() {
        return filtersRegistry.getPossibleFilters();
    }

    public List<String> validateFilters(List<FilterCondition> filters) {
        var notValidFilters = new ArrayList<String>();

        for (FilterCondition filter : filters) {
            if (filtersRegistry.getPossibleFilters().stream().anyMatch(f -> f.getFieldName().equals(filter.getFieldName()) && f.getApplicableOperations().contains(filter.getOperator()))) {
                continue;
            } else {
                notValidFilters.add(filter.getFieldName());
            }
        }

        return notValidFilters;
    }

    public TelemetryResponse fetchTelemetry(List<FilterCondition> filters) {
        TelemetryResponse response = new TelemetryResponse();
        try (IDocumentSession session = store.openSession()) {
            IDocumentQuery<Machine> query = session.query(Machine.class);
            query = applyFilters(query, filters);
            List<Machine> machines = query.toList();
            processMachines(response, machines);
        }
        return response;
    }

    private IDocumentQuery<Machine> applyFilters(IDocumentQuery<Machine> query, List<FilterCondition> filters) {
        for (FilterCondition cond : filters) {
            query = switch (cond.getOperator()) {
                case "Equals" -> query.whereEquals(cond.getFieldName(), cond.getValue());
                case "GreaterThan" -> query.whereGreaterThan(cond.getFieldName(), cond.getValue());
                case "LessThan" -> query.whereLessThan(cond.getFieldName(), cond.getValue());
                case "Contains" -> query.search(cond.getFieldName(), "*" + cond.getValue() + "*"); // this is expensive, but it works for now, way to go would be to write and index
                default -> query;
            };
        }
        return query;
    }

    private void processMachines(TelemetryResponse resp, List<Machine> machines) {
        ModelMapper mapper = new ModelMapper();
        for (Machine m : machines) {
            if (m instanceof Tractor tractor) {
                resp.getTractors().add(mapper.map(tractor, TractorDto.class));
            } else if (m instanceof Combine combine) {
                resp.getCombines().add(mapper.map(combine, CombineDto.class));
            }
        }
    }

    private List<?> readCsv(InputStream fileStream, String fileName) throws Exception {
        InputStreamReader reader = new InputStreamReader(fileStream);

        // Determine the class type based on the file name
        if (fileName.startsWith(Constants.TRACTOR_DATA_FILE_NAME)) {
            CsvToBean<TractorData> csvToBean = new CsvToBeanBuilder<TractorData>(reader).withType(TractorData.class).withSkipLines(1).withSeparator(';').build();
            return csvToBean.parse();
        } else if (fileName.startsWith(Constants.COMBINE_DATA_FILE_NAME)) {
            CsvToBean<CombineData> csvToBean = new CsvToBeanBuilder<CombineData>(reader).withType(CombineData.class).withSkipLines(1).withSeparator(';').build();
            return csvToBean.parse();
        } else {
            throw new IllegalArgumentException("Unsupported file type");
        }
    }
}
