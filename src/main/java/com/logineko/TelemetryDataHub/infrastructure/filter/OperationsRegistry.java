package com.logineko.TelemetryDataHub.infrastructure.filter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsRegistry {
    private static final Map<Class<?>, List<String>> operationsMap = new HashMap<>();

    static {
        operationsMap.put(int.class, Arrays.asList("Equals", "LessThan", "GreaterThan"));
        operationsMap.put(double.class, Arrays.asList("Equals", "LessThan", "GreaterThan"));
        operationsMap.put(String.class, Arrays.asList("Equals", "Contains"));
        operationsMap.put(LocalDateTime.class, Arrays.asList("Equals", "LessThan", "GreaterThan"));
    }

    public static List<String> getOperationsForType(Class<?> type) {
        return operationsMap.getOrDefault(type, Arrays.asList("No operations defined"));
    }
}
