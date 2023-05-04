package com.ps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(exclude = SpringDataWebAutoConfiguration.class)
public class DonationSiteFApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationSiteFApplication.class, args);
	}

}
