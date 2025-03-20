package dev.xamacardoso.thermed_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"dev.xamacardoso.thermed_api"})
@EnableJpaRepositories(basePackages = {"dev.xamacardoso.thermed_api"})
public class ThermedApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermedApiApplication.class, args);
	}

}
