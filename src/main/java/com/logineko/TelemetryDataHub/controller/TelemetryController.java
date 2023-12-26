package com.logineko.TelemetryDataHub.controller;

import com.logineko.TelemetryDataHub.services.ITelemetryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return ResponseEntity.ok("Hello World");
    }
}
