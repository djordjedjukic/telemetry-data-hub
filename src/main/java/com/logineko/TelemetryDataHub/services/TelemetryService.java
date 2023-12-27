package com.logineko.TelemetryDataHub.services;

import com.logineko.TelemetryDataHub.infrastructure.filter.Filter;
import com.logineko.TelemetryDataHub.model.dto.FilterCondition;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TelemetryResponse;

import java.io.InputStream;
import java.util.List;

public interface TelemetryService {
    void importData(InputStream file, String fileName) throws Exception;
    TelemetryResponse getTelemetryData(List<FilterCondition> filterConditions);
    List<String> validateFilters(List<FilterCondition> filters);

    List<Filter> getPossibleFilters();
}
