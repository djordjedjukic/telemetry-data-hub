package com.logineko.TelemetryDataHub.model.dto.telemetry;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CombineDto {
    private String machineType;
    private Date timestamp;
    private String serialNumber;
    private double longitude;
    private double latitude;
    private double totalWorkingHours;
    private double engineSpeed;
    private double engineLoad;
    private double groundSpeed;
    private int drumSpeed;
    private int fanSpeed;
    private int rotorStrawWalkerSpeed;
    private int separationLosses;
    private int sieveLosses;
    private boolean chopper;
    private int dieselTankLevel;
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
    private int grainMoistureContent;
    private double throughput;
    private int radialSpreaderSpeed;
    private int grainInReturns;
    private int channelPosition;
    private boolean yieldMeasurement;
    private int returnsAugerMeasurement;
    private boolean moistureMeasurement;
    private String typeOfCrop;
    private double specificCropWeight;
    private boolean autoPilotStatus;
    private doublem cruisePilotStatus;
    private double rateOfWork;
    private double yield;
    private double quantimeterCalibrationFactor;
    private int separationSensitivity;
    private int sieveSensitivity;
}
