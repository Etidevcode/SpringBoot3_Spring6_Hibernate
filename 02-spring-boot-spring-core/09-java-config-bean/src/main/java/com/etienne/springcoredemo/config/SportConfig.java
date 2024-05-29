package com.etienne.springcoredemo.config;

import com.etienne.springcoredemo.common.Coach;
import com.etienne.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

	@Bean
	public Coach swimCoachConfig() {  // Renommé en swimCoachConfig
		return new SwimCoach();
	}
}