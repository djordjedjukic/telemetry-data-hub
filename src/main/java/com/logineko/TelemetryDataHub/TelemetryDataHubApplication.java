package com.logineko.TelemetryDataHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TelemetryDataHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryDataHubApplication.class, args);
	}

}