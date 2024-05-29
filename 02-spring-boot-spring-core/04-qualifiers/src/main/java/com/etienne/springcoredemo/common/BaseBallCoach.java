package com.etienne.springcoredemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("BaseBallCoach")
public class BaseBallCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}
}
