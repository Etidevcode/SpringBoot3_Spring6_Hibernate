package com.etienne.springcoredemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

	public BaseBallCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}
}
