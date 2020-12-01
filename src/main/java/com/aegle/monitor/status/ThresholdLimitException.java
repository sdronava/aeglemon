package com.aegle.monitor.status;

@SuppressWarnings("serial")
public class ThresholdLimitException extends Exception {
	
	public ThresholdLimitException() {
		super();
	}

	public ThresholdLimitException(String message) {
		super(message);
	}
}
