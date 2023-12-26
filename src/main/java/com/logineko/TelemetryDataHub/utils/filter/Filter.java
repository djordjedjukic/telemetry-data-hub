package com.logineko.TelemetryDataHub.utils.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Filter {
    private String FriendlyName;
    private String PropertyName;
    private List<String> PossibleOperations;

    public Filter(String friendlyName, String propertyName, List<String> possibleOperations) {
        this.FriendlyName = friendlyName;
        this.PropertyName = propertyName;
        this.PossibleOperations = possibleOperations;
    }
}
