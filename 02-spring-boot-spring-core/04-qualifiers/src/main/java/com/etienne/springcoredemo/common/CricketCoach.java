package com.etienne.springcoredemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CricketCoach")
public class CricketCoach implements Coach {


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes -:).";
	}
}
