package com.logineko.TelemetryDataHub.model.dto.telemetry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TelemetryResponse {
    private List<TractorDto> tractors;
    private List<CombineDto> combines;

    public TelemetryResponse() {
        this.tractors = new ArrayList<>();
        this.combines = new ArrayList<>();
    }
}
