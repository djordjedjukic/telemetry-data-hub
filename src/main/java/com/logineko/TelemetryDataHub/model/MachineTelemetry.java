package model;

import java.time.LocalDateTime;

public class MachineTelemetry {
    private String id;
    private String machineType;
    private LocalDateTime timestamp;
    private String serialNumber;
    private double longitude;
    private double latitude;
    private double totalWorkingHours;
    private double groundSpeed;
    private double engineSpeed;
    private double engineLoad;
    private double drumSpeed;
    private double fanSpeed;
    private double rotorStrawWalkerSpeed;
    private double separationLosses;
    private double sieveLosses;
    private String chopper;
    private double dieselTankLevel;
    private int numberOfPartialWidths;
    private String frontAttachmentOnOff;
    private int maxNumberOfPartialWidths;
    private double feedRakeSpeed;
    private String workingPosition;
    private String grainTankUnloading;
    private String mainDriveStatus;
    private double concavePosition;
    private double upperSievePosition;
    private double lowerSievePosition;
    private String grainTank70;
    private String grainTank100;
    private double grainMoistureContent;
    private double throughput;
    private double radialSpreaderSpeed;
    private double grainInReturns;
    private double channelPosition;
    private String yieldMeasurement;
    private double returnsAugerMeasurement;
    private String moistureMeasurement;
    private String typeOfCrop;
    private double specificCropWeight;
    private String autoPilotStatus;
    private String cruisePilotStatus;
    private double rateOfWork;
    private double yield;
    private String quantimeterCalibrationFactor;
    private double separationSensitivity;
    private double sieveSensitivity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(double totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }

    public double getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(double groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public double getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(double engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public double getEngineLoad() {
        return engineLoad;
    }

    public void setEngineLoad(double engineLoad) {
        this.engineLoad = engineLoad;
    }

    public double getDrumSpeed() {
        return drumSpeed;
    }

    public void setDrumSpeed(double drumSpeed) {
        this.drumSpeed = drumSpeed;
    }

    public double getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(double fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public double getRotorStrawWalkerSpeed() {
        return rotorStrawWalkerSpeed;
    }

    public void setRotorStrawWalkerSpeed(double rotorStrawWalkerSpeed) {
        this.rotorStrawWalkerSpeed = rotorStrawWalkerSpeed;
    }

    public double getSeparationLosses() {
        return separationLosses;
    }

    public void setSeparationLosses(double separationLosses) {
        this.separationLosses = separationLosses;
    }

    public double getSieveLosses() {
        return sieveLosses;
    }

    public void setSieveLosses(double sieveLosses) {
        this.sieveLosses = sieveLosses;
    }

    public String getChopper() {
        return chopper;
    }

    public void setChopper(String chopper) {
        this.chopper = chopper;
    }

    public double getDieselTankLevel() {
        return dieselTankLevel;
    }

    public void setDieselTankLevel(double dieselTankLevel) {
        this.dieselTankLevel = dieselTankLevel;
    }

    public int getNumberOfPartialWidths() {
        return numberOfPartialWidths;
    }

    public void setNumberOfPartialWidths(int numberOfPartialWidths) {
        this.numberOfPartialWidths = numberOfPartialWidths;
    }

    public String getFrontAttachmentOnOff() {
        return frontAttachmentOnOff;
    }

    public void setFrontAttachmentOnOff(String frontAttachmentOnOff) {
        this.frontAttachmentOnOff = frontAttachmentOnOff;
    }

    public int getMaxNumberOfPartialWidths() {
        return maxNumberOfPartialWidths;
    }

    public void setMaxNumberOfPartialWidths(int maxNumberOfPartialWidths) {
        this.maxNumberOfPartialWidths = maxNumberOfPartialWidths;
    }

    public double getFeedRakeSpeed() {
        return feedRakeSpeed;
    }

    public void setFeedRakeSpeed(double feedRakeSpeed) {
        this.feedRakeSpeed = feedRakeSpeed;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }

    public String getGrainTankUnloading() {
        return grainTankUnloading;
    }

    public void setGrainTankUnloading(String grainTankUnloading) {
        this.grainTankUnloading = grainTankUnloading;
    }

    public String getMainDriveStatus() {
        return mainDriveStatus;
    }

    public void setMainDriveStatus(String mainDriveStatus) {
        this.mainDriveStatus = mainDriveStatus;
    }

    public double getConcavePosition() {
        return concavePosition;
    }

    public void setConcavePosition(double concavePosition) {
        this.concavePosition = concavePosition;
    }

    public double getUpperSievePosition() {
        return upperSievePosition;
    }

    public void setUpperSievePosition(double upperSievePosition) {
        this.upperSievePosition = upperSievePosition;
    }

    public double getLowerSievePosition() {
        return lowerSievePosition;
    }

    public void setLowerSievePosition(double lowerSievePosition) {
        this.lowerSievePosition = lowerSievePosition;
    }

    public String getGrainTank70() {
        return grainTank70;
    }

    public void setGrainTank70(String grainTank70) {
        this.grainTank70 = grainTank70;
    }

    public String getGrainTank100() {
        return grainTank100;
    }

    public void setGrainTank100(String grainTank100) {
        this.grainTank100 = grainTank100;
    }

    public double getGrainMoistureContent() {
        return grainMoistureContent;
    }

    public void setGrainMoistureContent(double grainMoistureContent) {
        this.grainMoistureContent = grainMoistureContent;
    }

    public double getThroughput() {
        return throughput;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public double getRadialSpreaderSpeed() {
        return radialSpreaderSpeed;
    }

    public void setRadialSpreaderSpeed(double radialSpreaderSpeed) {
        this.radialSpreaderSpeed = radialSpreaderSpeed;
    }

    public double getGrainInReturns() {
        return grainInReturns;
    }

    public void setGrainInReturns(double grainInReturns) {
        this.grainInReturns = grainInReturns;
    }

    public double getChannelPosition() {
        return channelPosition;
    }

    public void setChannelPosition(double channelPosition) {
        this.channelPosition = channelPosition;
    }

    public String getYieldMeasurement() {
        return yieldMeasurement;
    }

    public void setYieldMeasurement(String yieldMeasurement) {
        this.yieldMeasurement = yieldMeasurement;
    }

    public double getReturnsAugerMeasurement() {
        return returnsAugerMeasurement;
    }

    public void setReturnsAugerMeasurement(double returnsAugerMeasurement) {
        this.returnsAugerMeasurement = returnsAugerMeasurement;
    }

    public String getMoistureMeasurement() {
        return moistureMeasurement;
    }

    public void setMoistureMeasurement(String moistureMeasurement) {
        this.moistureMeasurement = moistureMeasurement;
    }

    public String getTypeOfCrop() {
        return typeOfCrop;
    }

    public void setTypeOfCrop(String typeOfCrop) {
        this.typeOfCrop = typeOfCrop;
    }

    public double getSpecificCropWeight() {
        return specificCropWeight;
    }

    public void setSpecificCropWeight(double specificCropWeight) {
        this.specificCropWeight = specificCropWeight;
    }

    public String getAutoPilotStatus() {
        return autoPilotStatus;
    }

    public void setAutoPilotStatus(String autoPilotStatus) {
        this.autoPilotStatus = autoPilotStatus;
    }

    public String getCruisePilotStatus() {
        return cruisePilotStatus;
    }

    public void setCruisePilotStatus(String cruisePilotStatus) {
        this.cruisePilotStatus = cruisePilotStatus;
    }

    public double getRateOfWork() {
        return rateOfWork;
    }

    public void setRateOfWork(double rateOfWork) {
        this.rateOfWork = rateOfWork;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public String getQuantimeterCalibrationFactor() {
        return quantimeterCalibrationFactor;
    }

    public void setQuantimeterCalibrationFactor(String quantimeterCalibrationFactor) {
        this.quantimeterCalibrationFactor = quantimeterCalibrationFactor;
    }

    public double getSeparationSensitivity() {
        return separationSensitivity;
    }

    public void setSeparationSensitivity(double separationSensitivity) {
        this.separationSensitivity = separationSensitivity;
    }

    public double getSieveSensitivity() {
        return sieveSensitivity;
    }

    public void setSieveSensitivity(double sieveSensitivity) {
        this.sieveSensitivity = sieveSensitivity;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }
}
