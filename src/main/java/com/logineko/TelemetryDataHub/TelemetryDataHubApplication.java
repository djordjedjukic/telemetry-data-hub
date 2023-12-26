package com.logineko.TelemetryDataHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EntityScan(basePackages = "com.logineko.TelemetryDataHub")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = "com.logineko.TelemetryDataHub")
public class TelemetryDataHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryDataHubApplication.class, args);
	}

}
