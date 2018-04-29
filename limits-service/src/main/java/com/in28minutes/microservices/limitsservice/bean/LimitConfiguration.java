package com.in28minutes.microservices.limitsservice.bean;

public class LimitConfiguration {
	private int maximum;
	private int miminum;


	protected LimitConfiguration() {
	}

	public LimitConfiguration(int maximum, int miminum) {
		this.maximum = maximum;
		this.miminum = miminum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMiminum() {
		return miminum;
	}
}
