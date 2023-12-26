package com.logineko.TelemetryDataHub.services;

import com.logineko.TelemetryDataHub.model.Combine;
import com.logineko.TelemetryDataHub.model.Machine;
import com.logineko.TelemetryDataHub.model.Tractor;
import com.logineko.TelemetryDataHub.model.csvModel.CombineData;
import com.logineko.TelemetryDataHub.model.csvModel.TractorData;
import com.logineko.TelemetryDataHub.utils.Constants;
import com.logineko.TelemetryDataHub.utils.DocumentStoreHolder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class TelemetryService implements ITelemetryService {

    @Override
    public void importData(InputStream file, String fileName) throws Exception {

        List<?> data = readCsv(file, fileName);

        Machine machine = null;

        if (fileName.startsWith(Constants.TRACTOR_DATA_FILE_NAME)) {
            machine = new Tractor();
        } else if (fileName.startsWith(Constants.COMBINE_DATA_FILE_NAME)) {
            machine = new Combine();
        }

        //save to db
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            session.store(machine);
            session.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
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
