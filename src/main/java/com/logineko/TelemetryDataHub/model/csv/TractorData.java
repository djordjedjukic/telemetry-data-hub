package com.logineko.TelemetryDataHub.model.csv;

import com.logineko.TelemetryDataHub.infrastructure.Constants;
import com.logineko.TelemetryDataHub.model.domain.Tractor;
import com.opencsv.bean.CsvBindByPosition;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.logineko.TelemetryDataHub.infrastructure.Utils.parseDoubleOrZero;
import static com.logineko.TelemetryDataHub.infrastructure.Utils.parseIntOrZero;

@Getter
@Setter
public class TractorData {
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
    private String engineSpeed;

    @CsvBindByPosition(position = 6)
    private String engineLoad;

    @CsvBindByPosition(position = 7)
    private String fuelConsumption;

    @CsvBindByPosition(position = 8)
    private String groundSpeedGearbox;

    @CsvBindByPosition(position = 9)
    private String groundSpeedRadar;

    @CsvBindByPosition(position = 10)
    private String coolantTemperature;

    @CsvBindByPosition(position = 11)
    private String speedFrontPTO;

    @CsvBindByPosition(position = 12)
    private String speedRearPTO;

    @CsvBindByPosition(position = 13)
    private String currentGearShift;

    @CsvBindByPosition(position = 14)
    private String ambientTemperature;

    @CsvBindByPosition(position = 15)
    private String parkingBrakeStatus;

    @CsvBindByPosition(position = 16)
    private String transverseDifferentialLockStatus;

    @CsvBindByPosition(position = 17)
    private String allWheelDriveStatus;

    @CsvBindByPosition(position = 18)
    private String actualStatusOfCreeper;

    public Tractor toDomain() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");
        Tractor model = new Tractor();
        model.setMachineType(Constants.TRACTOR);
        model.setTimestamp(format.parse(dateTime));
        model.setSerialNumber(serialNumber);
        model.setLatitude(parseDoubleOrZero(gpsLatitude));
        model.setLongitude(parseDoubleOrZero(gpsLongitude));
        model.setTotalWorkingHours(parseDoubleOrZero(totalWorkingHoursCounter));
        model.setEngineLoad(parseDoubleOrZero(engineLoad));
        model.setEngineSpeed(parseDoubleOrZero(engineSpeed));
        model.setFuelConsumption(parseDoubleOrZero(fuelConsumption));
        model.setGroundSpeedGearbox(parseDoubleOrZero(groundSpeedGearbox));
        model.setGroundSpeedRadar(parseDoubleOrZero(groundSpeedRadar));
        model.setCoolantTemperature(parseDoubleOrZero(coolantTemperature));
        model.setSpeedFrontPTO(parseIntOrZero(speedFrontPTO));
        model.setSpeedRearPTO(parseIntOrZero(speedRearPTO));
        model.setCurrentGearShift(parseIntOrZero(currentGearShift));
        model.setAmbientTemperature(parseDoubleOrZero(ambientTemperature));
        model.setParkingBrakeStatus(parseIntOrZero(parkingBrakeStatus));
        model.setTransverseDifferentialLockStatus(parseIntOrZero(transverseDifferentialLockStatus));
        model.setAllWheelDriveStatusActive(isActiveStatus(allWheelDriveStatus));
        model.setActualStatusOfCreeperActive(isActiveStatus(actualStatusOfCreeper));
        return model;
    }



    private boolean isActiveStatus(String status){
        return "Active".equals(status);
    }
}
