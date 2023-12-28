package com.logineko.telemetrydatahub.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterCondition {
    private String fieldName;
    private String operator = "Equals";
    private Object value;
}
