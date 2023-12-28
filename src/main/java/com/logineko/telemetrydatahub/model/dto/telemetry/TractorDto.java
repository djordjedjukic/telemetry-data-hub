package com.logineko.telemetrydatahub.model.dto.telemetry;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TractorDto {
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
    private int currentGearShift;
    private double ambientTemperature;
    private int parkingBrakeStatus;
    private int transverseDifferentialLockStatus;
    private boolean allWheelDriveStatusActive;
    private boolean actualStatusOfCreeperActive;
}
