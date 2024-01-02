package com.logineko.telemetrydatahub.infrastructure.filter;

import com.logineko.telemetrydatahub.infrastructure.Operator;

import java.time.LocalDateTime;
import java.util.*;

public class OperationsRegistry {
    private static final Map<Class<?>, List<String>> operationsMap = new HashMap<>();

    static {
        operationsMap.put(int.class, Arrays.asList(Operator.EQUALS.toString(), Operator.LESSTHAN.toString(), Operator.GREATERTHAN.toString()));
        operationsMap.put(double.class, Arrays.asList(Operator.EQUALS.toString(), Operator.LESSTHAN.toString(), Operator.GREATERTHAN.toString()));
        operationsMap.put(String.class, Arrays.asList(Operator.EQUALS.toString(), Operator.CONTAINS.toString()));
        operationsMap.put(LocalDateTime.class, Arrays.asList(Operator.EQUALS.toString(), Operator.LESSTHAN.toString(), Operator.GREATERTHAN.toString()));
        operationsMap.put(boolean.class, Collections.singletonList(Operator.EQUALS.toString()));
    }

    public static List<String> getOperationsForType(Class<?> type) {
        return operationsMap.getOrDefault(type, List.of("No operations defined"));
    }
}
