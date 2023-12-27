package com.logineko.TelemetryDataHub.infrastructure.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Filter {
    private String FriendlyName;
    private String FieldName;
    private List<String> PossibleOperations;

    public Filter(String friendlyName, String fieldName, List<String> possibleOperations) {
        this.FriendlyName = friendlyName;
        this.FieldName = fieldName;
        this.PossibleOperations = possibleOperations;
    }
}
