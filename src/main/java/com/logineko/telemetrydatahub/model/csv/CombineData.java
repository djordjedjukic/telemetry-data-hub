package com.logineko.telemetrydatahub.model.csv;

import com.logineko.telemetrydatahub.infrastructure.Constants;
import com.logineko.telemetrydatahub.model.domain.Combine;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.logineko.telemetrydatahub.infrastructure.Utils.parseDoubleOrZero;
import static com.logineko.telemetrydatahub.infrastructure.Utils.parseIntOrZero;

@Getter
@Setter
public class CombineData {
    @CsvBindByPosition(position = 0)
    private String dateTime;

    @CsvBindByPosition(position = 1)
    private String serialNumber;

    @CsvBindByPosition(position = 2)
    private String gpsLongitude;

    @CsvBindByPosition(position = 3)
    private String gpsLatitude;

    @CsvBindByPosition(position = 4)
    private String totalWorkingHoursCounter;

    @CsvBindByPosition(position = 5)
    private String groundSpeed;

    @CsvBindByPosition(position = 6)
    private String engineSpeed;

    @CsvBindByPosition(position = 7)
    private String engineLoad;

    @CsvBindByPosition(position = 8)
    private String drumSpeed;

    @CsvBindByPosition(position = 9)
    private String fanSpeed;

    @CsvBindByPosition(position = 10)
    private String rotorStrawWalkerSpeed;

    @CsvBindByPosition(position = 11)
    private String separationLosses;

    @CsvBindByPosition(position = 12)
    private String sieveLosses;

    @CsvBindByPosition(position = 13)
    private String chopper;

    @CsvBindByPosition(position = 14)
    private String dieselTankLevel;

    @CsvBindByPosition(position = 15)
    private String numberOfPartialWidths;

    @CsvBindByPosition(position = 16)
    private String frontAttachmentOnOff;

    @CsvBindByPosition(position = 17)
    private String maxNumberOfPartialWidths;

    @CsvBindByPosition(position = 18)
    private String feedRakeSpeed;

    @CsvBindByPosition(position = 19)
    private String workingPosition;

    @CsvBindByPosition(position = 20)
    private String grainTankUnloading;

    @CsvBindByPosition(position = 21)
    private String mainDriveStatus;

    @CsvBindByPosition(position = 22)
    private String concavePosition;

    @CsvBindByPosition(position = 23)
    private String upperSievePosition;

    @CsvBindByPosition(position = 24)
    private String lowerSievePosition;

    @CsvBindByPosition(position = 25)
    private String grainTank70;

    @CsvBindByPosition(position = 26)
    private String grainTank100;

    @CsvBindByPosition(position = 27)
    private String grainMoistureContent;

    @CsvBindByPosition(position = 28)
    private String throughput;

    @CsvBindByPosition(position = 29)
    private String radialSpreaderSpeed;

    @CsvBindByPosition(position = 30)
    private String grainInReturns;

    @CsvBindByPosition(position = 31)
    private String channelPosition;

    @CsvBindByPosition(position = 32)
    private String yieldMeasurement;

    @CsvBindByPosition(position = 33)
    private String returnsAugerMeasurement;

    @CsvBindByPosition(position = 34)
    private String moistureMeasurement;

    @CsvBindByPosition(position = 35)
    private String typeOfCrop;

    @CsvBindByPosition(position = 36)
    private String specificCropWeight;

    @CsvBindByPosition(position = 37)
    private String autoPilotStatus;

    @CsvBindByPosition(position = 38)
    private String cruisePilotStatus;

    @CsvBindByPosition(position = 39)
    private String rateOfWork;

    @CsvBindByPosition(position = 40)
    private String yield;

    @CsvBindByPosition(position = 41)
    private String quantimeterCalibrationFactor;

    @CsvBindByPosition(position = 42)
    private String separationSensitivity;

    @CsvBindByPosition(position = 43)
    private String sieveSensitivity;

    public Combine toDomain() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");
        Combine model = new Combine();
        model.setMachineType(Constants.COMBINE);
        model.setTimestamp(format.parse(dateTime));
        model.setSerialNumber(serialNumber);
        model.setLongitude(parseDoubleOrZero(gpsLongitude));
        model.setLatitude(parseDoubleOrZero(gpsLatitude));
        model.setTotalWorkingHours(parseDoubleOrZero(totalWorkingHoursCounter));
        model.setGroundSpeed(parseDoubleOrZero(groundSpeed));
        model.setEngineSpeed(parseDoubleOrZero(engineSpeed));
        model.setEngineLoad(parseDoubleOrZero(engineLoad));
        model.setDrumSpeed(parseIntOrZero(drumSpeed));
        model.setFanSpeed(parseIntOrZero(fanSpeed));
        model.setRotorStrawWalkerSpeed(parseIntOrZero(rotorStrawWalkerSpeed));
        model.setSeparationLosses(parseDoubleOrZero(separationLosses));
        model.setSieveLosses(parseDoubleOrZero(sieveLosses));
        model.setChopper(isOn(chopper));
        model.setDieselTankLevel(parseDoubleOrZero(dieselTankLevel));
        model.setNumberOfPartialWidths(parseIntOrZero(numberOfPartialWidths));
        model.setFrontAttachmentOnOff(isOn(frontAttachmentOnOff));
        model.setMaxNumberOfPartialWidths(parseIntOrZero(maxNumberOfPartialWidths));
        model.setFeedRakeSpeed(parseIntOrZero(feedRakeSpeed));
        model.setWorkingPosition(isOn(workingPosition));
        model.setGrainTankUnloading(isOn(grainTankUnloading));
        model.setMainDriveStatus(isOn(mainDriveStatus));
        model.setConcavePosition(parseIntOrZero(concavePosition));
        model.setUpperSievePosition(parseIntOrZero(upperSievePosition));
        model.setLowerSievePosition(parseIntOrZero(lowerSievePosition));
        model.setGrainTank70(isOn(grainTank70));
        model.setGrainTank100(isOn(grainTank100));
        model.setGrainMoistureContent(parseDoubleOrZero(grainMoistureContent));
        model.setThroughput(parseDoubleOrZero(throughput));
        model.setRadialSpreaderSpeed(parseIntOrZero(radialSpreaderSpeed));
        model.setGrainInReturns(parseIntOrZero(grainInReturns));
        model.setChannelPosition(parseDoubleOrZero(channelPosition));
        model.setYieldMeasurement(isOn(yieldMeasurement));
        model.setReturnsAugerMeasurement(parseDoubleOrZero(returnsAugerMeasurement));
        model.setMoistureMeasurement(isOn(moistureMeasurement));
        model.setTypeOfCrop(typeOfCrop);
        model.setSpecificCropWeight(parseDoubleOrZero(specificCropWeight));
        model.setAutoPilotStatus(isOn(autoPilotStatus));
        model.setCruisePilotStatus(parseDoubleOrZero(cruisePilotStatus));
        model.setRateOfWork(parseDoubleOrZero(rateOfWork));
        model.setYield(parseDoubleOrZero(yield));
        model.setQuantimeterCalibrationFactor(parseDoubleOrZero(quantimeterCalibrationFactor));
        model.setSeparationSensitivity(parseIntOrZero(separationSensitivity));
        model.setSieveSensitivity(parseIntOrZero(sieveSensitivity));

        return model;
    }

    private boolean isOn(String status) {
        return "on".equals(status);
    }
}
