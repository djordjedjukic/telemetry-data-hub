package com.logineko.telemetrydatahub.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Combine extends Machine {
    private double groundSpeed;
    private int drumSpeed;
    private int fanSpeed;
    private int rotorStrawWalkerSpeed;
    private double separationLosses;
    private double sieveLosses;
    private boolean chopper;
    private double dieselTankLevel;
    private int numberOfPartialWidths;
    private boolean frontAttachmentOnOff;
    private int maxNumberOfPartialWidths;
    private int feedRakeSpeed;
    private boolean workingPosition;
    private boolean grainTankUnloading;
    private boolean mainDriveStatus;
    private int concavePosition;
    private int upperSievePosition;
    private int lowerSievePosition;
    private boolean grainTank70;
    private boolean grainTank100;
    private double grainMoistureContent;
    private double throughput;
    private int radialSpreaderSpeed;
    private int grainInReturns;
    private double channelPosition;
    private boolean yieldMeasurement;
    private double returnsAugerMeasurement;
    private boolean moistureMeasurement;
    private String typeOfCrop;
    private double specificCropWeight;
    private boolean autoPilotStatus;
    private double cruisePilotStatus;
    private double rateOfWork;
    private double yield;
    private double quantimeterCalibrationFactor;
    private double separationSensitivity;
    private double sieveSensitivity;
}
