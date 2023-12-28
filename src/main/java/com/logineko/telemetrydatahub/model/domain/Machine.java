package com.logineko.telemetrydatahub.model.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.Date;

@Data
// I needed to add this annotation to distinguish between Tractor and Combine when deserializing from db, this works by default in C#
// maybe it can work in java in similar way, but I didn't find it quickly
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "machineType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Tractor.class, name = "Tractor"),
        @JsonSubTypes.Type(value = Combine.class, name = "Combine")
})
public abstract class Machine {
    private String id;
    private String machineType;
    private Date timestamp;
    private String serialNumber;
    private double longitude;
    private double latitude;
    private double totalWorkingHours;
    private double engineSpeed;
    private double engineLoad;
}
