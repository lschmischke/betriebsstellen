package de.schmischke.betriebsstellen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BetriebsstellenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetriebsstellenApplication.class, args);
	}

}
