package com.logineko.TelemetryDataHub.controller;

import com.logineko.TelemetryDataHub.model.dto.FilterCondition;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TelemetryResponse;
import com.logineko.TelemetryDataHub.services.ITelemetryService;
import com.logineko.TelemetryDataHub.infrastructure.filter.FiltersRegistry;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/telemetry")
public class TelemetryController {

    private final ITelemetryService telemetryService;

    @PostMapping("/import")
    public String importTelemetryData(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "No file selected";
        }

        if (!file.getOriginalFilename().endsWith(".csv")) {
            return "Invalid file type. Only CSV files are allowed.";
        }

        try {
            String fileName = file.getOriginalFilename();
            telemetryService.importData(file.getInputStream(), fileName);
            return "File uploaded successfully: " + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong. Please try again.";
        }
    }


    @GetMapping("/test")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(FiltersRegistry.getPossibleFilters());
    }

    @PostMapping("/filter")
    public ResponseEntity<?> applyFilters(@RequestBody List<FilterCondition> filterConditions) {
        var notValidFilters = telemetryService.validateFilters(filterConditions);

        if (filterConditions.isEmpty()) {
            return new ResponseEntity<>("No filters applied", HttpStatus.BAD_REQUEST);
        } else if (!notValidFilters.isEmpty()) {
            return new ResponseEntity<>("Invalid filters: " + String.join(", ", notValidFilters), HttpStatus.BAD_REQUEST);
        } else {
            TelemetryResponse response = telemetryService.getTelemetryData(filterConditions);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
