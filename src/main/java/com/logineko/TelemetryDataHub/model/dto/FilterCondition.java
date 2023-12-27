package com.logineko.TelemetryDataHub.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FilterCondition {
    private String fieldName;
    private String operator;
    private Object value;
}
