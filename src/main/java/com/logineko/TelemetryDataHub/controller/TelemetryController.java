package com.logineko.TelemetryDataHub.controller;

import com.logineko.TelemetryDataHub.model.dto.FilterCondition;
import com.logineko.TelemetryDataHub.model.dto.telemetry.TelemetryResponse;
import com.logineko.TelemetryDataHub.services.TelemetryService;
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

    private final TelemetryService telemetryService;

    @PostMapping("/import")
    public ResponseEntity<?> importTelemetryData(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("No file selected", HttpStatus.BAD_REQUEST);
        }

        if (!file.getOriginalFilename().endsWith(".csv")) {
            return new ResponseEntity<>("Invalid file type. Only CSV files are allowed.", HttpStatus.BAD_REQUEST);
        }

        try {
            String fileName = file.getOriginalFilename();
            telemetryService.importData(file.getInputStream(), fileName);
            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong. Please try again.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(telemetryService.getPossibleFilters());
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
            return ResponseEntity.ok(response);
        }
    }
}
