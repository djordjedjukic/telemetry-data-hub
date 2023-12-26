package com.logineko.TelemetryDataHub.services;

import com.logineko.TelemetryDataHub.model.csvModel.CombineData;
import com.logineko.TelemetryDataHub.model.csvModel.TractorData;
import com.logineko.TelemetryDataHub.utils.Constants;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class TelemetryService implements ITelemetryService{

    @Override
    public void importData(InputStream file, String fileName) throws Exception {

        List<?> data = readCsv(file, fileName);
    }

    private List<?> readCsv(InputStream fileStream, String fileName) throws Exception {
        InputStreamReader reader = new InputStreamReader(fileStream);

        // Determine the class type based on the file name
        if (fileName.startsWith(Constants.TRACTOR_DATA_FILE_NAME)) {
            CsvToBean<TractorData> csvToBean = new CsvToBeanBuilder<TractorData>(reader)
                    .withType(TractorData.class)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .build();
            return csvToBean.parse();
        } else if (fileName.startsWith(Constants.COMBINE_DATA_FILE_NAME)) {
            CsvToBean<CombineData> csvToBean = new CsvToBeanBuilder<CombineData>(reader)
                    .withType(CombineData.class)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .build();
            return csvToBean.parse();
        } else {
            throw new IllegalArgumentException("Unsupported file type");
        }
    }
}
