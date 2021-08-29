package org.miniats.jobopeningservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class JobOpeningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobOpeningServiceApplication.class, args);
	}

}
