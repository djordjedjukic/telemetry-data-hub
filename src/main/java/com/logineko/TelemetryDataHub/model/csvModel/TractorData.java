package com.logineko.TelemetryDataHub.model.csvModel;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

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
}
