package com.logineko.telemetrydatahub.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tractor extends Machine {
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

    public Tractor() {

    }
}
