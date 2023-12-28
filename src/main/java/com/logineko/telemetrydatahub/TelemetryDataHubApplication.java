package com.logineko.telemetrydatahub;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.logging.Logger;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TelemetryDataHubApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelemetryDataHubApplication.class, args);
	}

}