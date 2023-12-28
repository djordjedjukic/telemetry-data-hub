package com.logineko.telemetrydatahub.infrastructure.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Filter {
    private String FriendlyName;
    private String FieldName;
    private List<String> ApplicableOperations;

    public Filter(String friendlyName, String fieldName, List<String> possibleOperations) {
        this.FriendlyName = friendlyName;
        this.FieldName = fieldName;
        this.ApplicableOperations = possibleOperations;
    }
}
