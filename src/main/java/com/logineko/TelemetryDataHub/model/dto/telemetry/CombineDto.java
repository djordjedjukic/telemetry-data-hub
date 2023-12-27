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
    private String chopper;
    private int dieselTankLevel;
    private int numberOfPartialWidths;
    private String frontAttachmentOnOff;
    private int maxNumberOfPartialWidths;
    private int feedRakeSpeed;
    private String workingPosition;
    private String grainTankUnloading;
    private String mainDriveStatus;
    private int concavePosition;
    private int upperSievePosition;
    private int lowerSievePosition;
    private String grainTank70;
    private String grainTank100;
    private int grainMoistureContent;
    private double throughput;
    private int radialSpreaderSpeed;
    private int grainInReturns;
    private int channelPosition;
    private String yieldMeasurement;
    private int returnsAugerMeasurement;
    private String moistureMeasurement;
    private String typeOfCrop;
    private double specificCropWeight;
    private String autoPilotStatus;
    private String cruisePilotStatus;
    private double rateOfWork;
    private double yield;
    private String quantimeterCalibrationFactor;
    private int separationSensitivity;
    private int sieveSensitivity;
}
