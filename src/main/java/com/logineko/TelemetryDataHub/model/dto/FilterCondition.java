package com.logineko.TelemetryDataHub.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FilterCondition {
    private String Key;
    public String Operator;
    public Object Value;
}
