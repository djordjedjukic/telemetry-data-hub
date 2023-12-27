package com.logineko.TelemetryDataHub.infrastructure;

import org.apache.commons.lang3.math.NumberUtils;

public class Utils {
    public static double parseDoubleOrZero(String value) {
        return NumberUtils.isParsable(value) ? Double.parseDouble(value) : 0;
    }

    public static int parseIntOrZero(String value) {
        return NumberUtils.isParsable(value) ? Integer.parseInt(value) : 0;
    }
}
