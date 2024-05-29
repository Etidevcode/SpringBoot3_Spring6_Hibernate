package com.etienne.springcoredemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("TrackCoach")
public class TrackCoach implements  Coach{

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
}
