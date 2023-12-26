package com.logineko.TelemetryDataHub.services;

import java.io.InputStream;

public interface ITelemetryService {
    void importData(InputStream file, String fileName) throws Exception;
}
