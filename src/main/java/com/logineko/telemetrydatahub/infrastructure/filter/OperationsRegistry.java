package com.logineko.telemetrydatahub.infrastructure.filter;

import com.logineko.telemetrydatahub.infrastructure.Constants;
import com.logineko.telemetrydatahub.infrastructure.Operator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsRegistry {
    private static final Map<Class<?>, List<String>> operationsMap = new HashMap<>();

    static {
        operationsMap.put(int.class, Arrays.asList(Operator.Equals.toString(), Operator.LessThan.toString(), Operator.GreaterThan.toString()));
        operationsMap.put(double.class, Arrays.asList(Operator.Equals.toString(), Operator.LessThan.toString(), Operator.GreaterThan.toString()));
        operationsMap.put(String.class, Arrays.asList(Operator.Equals.toString(), Operator.Contains.toString()));
        operationsMap.put(LocalDateTime.class, Arrays.asList(Operator.Equals.toString(), Operator.LessThan.toString(), Operator.GreaterThan.toString()));
        operationsMap.put(boolean.class, Arrays.asList(Operator.Equals.toString()));
    }

    public static List<String> getOperationsForType(Class<?> type) {
        return operationsMap.getOrDefault(type, Arrays.asList("No operations defined"));
    }
}
