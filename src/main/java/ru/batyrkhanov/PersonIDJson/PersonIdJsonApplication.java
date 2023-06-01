package ru.batyrkhanov.PersonIDJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PersonIdJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonIdJsonApplication.class, args);
	}

}
