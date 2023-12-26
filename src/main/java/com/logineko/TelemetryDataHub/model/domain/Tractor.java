package com.logineko.TelemetryDataHub.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tractor extends Machine {
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
