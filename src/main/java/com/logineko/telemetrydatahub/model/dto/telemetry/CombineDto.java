package com.logineko.telemetrydatahub.model.dto.telemetry;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CombineDto {
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
    private int separationSensitivity;
    private int sieveSensitivity;
}
