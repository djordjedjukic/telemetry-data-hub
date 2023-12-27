package com.logineko.TelemetryDataHub.services;

import com.logineko.TelemetryDataHub.infrastructure.filter.Filter;
import com.logineko.TelemetryDataHub.model.csvModel.CombineData;
import com.logineko.TelemetryDataHub.model.csvModel.TractorData;
import com.logineko.TelemetryDataHub.model.domain.Combine;
import com.logineko.TelemetryDataHub.model.domain.Machine;
import com.logineko.TelemetryDataHub.model.domain.Tractor;
import com.logineko.TelemetryDataHub.model.dto.FilterCondition;
import com.logineko.TelemetryDataHub.model.dto.telemetry.CombineDto;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TelemetryResponse;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TractorDto;
import com.logineko.TelemetryDataHub.infrastructure.Constants;
import com.logineko.TelemetryDataHub.infrastructure.filter.FiltersRegistry;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentQuery;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        List<?> machines = readCsv(file, fileName);

        machines = machines.subList(0, 2);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");


        Machine machine = null;
        try (IDocumentSession session = store.openSession()) {
            if (fileName.startsWith(Constants.TRACTOR_DATA_FILE_NAME)) {
                for (Object obj : machines) {
                    TractorData data = (TractorData) obj;
                    machine = new Tractor();
                    machine.setMachineType("Tractor");
                    machine.setEngineLoad(!Objects.equals(data.getEngineLoad(), "na") ? Double.parseDouble(data.getEngineLoad()) : null);
                    machine.setEngineSpeed(Double.parseDouble(data.getEngineSpeed()));
                    machine.setLatitude(Double.parseDouble(data.getGpsLatitude()));
                    machine.setLongitude(Double.parseDouble(data.getGpsLongitude()));
                    machine.setSerialNumber(data.getSerialNumber());
                    machine.setTotalWorkingHours(Double.parseDouble(data.getTotalWorkingHoursCounter()));
                    machine.setTimestamp(formatter.parse(data.getDateTime()));



                    session.store(machine);

                }
            } else if (fileName.startsWith(Constants.COMBINE_DATA_FILE_NAME)) {
                for (Object obj : machines) {
                    CombineData data = (CombineData) obj;
                    machine = new Combine();
                    machine.setMachineType("Combine");
                    machine.setEngineLoad(Double.parseDouble(data.getEngineLoad()));
                    machine.setEngineSpeed(Double.parseDouble(data.getEngineSpeed()));
                    machine.setLatitude(Double.parseDouble(data.getGpsLatitude()));
                    machine.setLongitude(Double.parseDouble(data.getGpsLongitude()));
                    machine.setSerialNumber(data.getSerialNumber());
                    machine.setTotalWorkingHours(Double.parseDouble(data.getTotalWorkingHoursCounter()));
                    machine.setTimestamp(formatter.parse(data.getDateTime()));

                    session.store(machine);
                }
            }
            session.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Filter> getPossibleFilters() {
        return filtersRegistry.getPossibleFilters();
    }

    public List<String> validateFilters(List<FilterCondition> filters) {
        var notValidFilters = new ArrayList<String>();

        for (FilterCondition filter : filters) {
            if (filtersRegistry.getPossibleFilters()
                    .stream()
                    .anyMatch(f -> f.getFieldName().equals(filter.getFieldName()) &&
                            f.getPossibleOperations().contains(filter.getOperator()))) {
                continue;
            } else {
                notValidFilters.add(filter.getFieldName());
            }
        }

        return notValidFilters;
    }

    public TelemetryResponse getTelemetryData(List<FilterCondition> filterConditions) {
        TelemetryResponse response = new TelemetryResponse();
        try (IDocumentSession session = store.openSession()) {

            IDocumentQuery<Machine> query = session.query(Machine.class);

            for (FilterCondition condition : filterConditions) {
                query = switch (condition.getOperator()) {
                    case "Equals" -> query.whereEquals(condition.getFieldName(), condition.getValue());
                    case "GreaterThan" -> query.whereGreaterThan(condition.getFieldName(), condition.getValue());
                    case "LessThan" -> query.whereLessThan(condition.getFieldName(), condition.getValue());
                    case "Contains" -> query.search(condition.getFieldName(), "*" + condition.getValue() + "*");
                    default -> query;
                };
            }

            List<Machine> results = query.toList();

            for (Machine machine : results) {
                if (machine instanceof Tractor tractor) {
                    var tractorDto = new TractorDto();
                    tractorDto.setMachineType("Tractor");
                    tractorDto.setSerialNumber(tractor.getSerialNumber());
                    response.getTractors().add(tractorDto);
                } else if (machine instanceof Combine combine) {
                    var combineDto = new CombineDto();
                    combineDto.setMachineType("Combine");
                    combineDto.setSerialNumber(combine.getSerialNumber());
                    response.getCombines().add(combineDto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
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
