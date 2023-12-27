package com.logineko.TelemetryDataHub.model.dto.telemetry;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TractorDto {
    private String machineType;
    private Date timestamp;
    private String serialNumber;
    private double longitude;
    private double latitude;
    private double totalWorkingHours;
    private double engineSpeed;
    private double engineLoad;
    private double fuelConsumption;
    private double groundSpeedGearbox;
    private double groundSpeedRadar;
    private double coolantTemperature;
    private int speedFrontPTO;
    private int speedRearPTO;
    private String currentGearShift;
    private double ambientTemperature;
    private String parkingBrakeStatus;
    private String transverseDifferentialLockStatus;
    private String allWheelDriveStatus;
    private String actualStatusOfCreeper;
}
