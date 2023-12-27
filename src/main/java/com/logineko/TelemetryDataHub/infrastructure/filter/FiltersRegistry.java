package com.logineko.TelemetryDataHub.infrastructure.filter;

import com.logineko.TelemetryDataHub.model.domain.Combine;
import com.logineko.TelemetryDataHub.model.domain.Machine;
import com.logineko.TelemetryDataHub.model.domain.Tractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Configuration
public class FiltersRegistry {

    @Bean
    public List<Filter> getPossibleFilters() {
        List<Filter> filters = new ArrayList<>();
        List<Field> fields = new ArrayList<>();

        fields.addAll(Arrays.asList(Machine.class.getDeclaredFields()));
        fields.addAll(Arrays.asList(Tractor.class.getDeclaredFields()));
        fields.addAll(Arrays.asList(Combine.class.getDeclaredFields()));

        for (Field field : fields) {
            String fieldName = field.getName();
            String friendlyName = fieldName.replaceAll("([a-z])([A-Z])", "$1 $2")
                    .replaceAll("([A-Z])([A-Z][a-z])", "$1 $2");

            filters.add(new Filter(friendlyName, fieldName, OperationsRegistry.getOperationsForType(field.getType())));
        }

        return filters;
    }
}


