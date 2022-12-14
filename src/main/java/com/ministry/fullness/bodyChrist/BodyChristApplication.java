package com.ministry.fullness.bodyChrist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BodyChristApplication {
	public static void main(String[] args) {
		SpringApplication.run(BodyChristApplication.class, args);
	}
}
