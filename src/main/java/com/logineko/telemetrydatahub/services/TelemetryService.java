package com.logineko.telemetrydatahub.services;

import com.logineko.telemetrydatahub.infrastructure.filter.Filter;
import com.logineko.telemetrydatahub.model.dto.FilterCondition;
import com.logineko.telemetrydatahub.model.dto.telemetry.TelemetryResponse;

import java.io.InputStream;
import java.util.List;

public interface TelemetryService {
    void importData(InputStream file, String fileName) throws Exception;
    TelemetryResponse fetchTelemetry(List<FilterCondition> filters);
    List<String> validateFilters(List<FilterCondition> filters);

    List<Filter> getPossibleFilters();
}
