package com.logineko.TelemetryDataHub.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Machine {
    private String id;
    private String machineType;
    private LocalDateTime timestamp;
    private String serialNumber;
    private double longitude;
    private double latitude;
    private double totalWorkingHours;
    private double engineSpeed;
    private double engineLoad;
}
