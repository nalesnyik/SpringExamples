package eu.wecanconsulting.spring.demo.testing;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {

	@Bean
	public Random getRandom() {
		return new Random();
	}
}
