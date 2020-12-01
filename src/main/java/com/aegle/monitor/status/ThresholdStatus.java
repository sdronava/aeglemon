package com.aegle.monitor.status;

public class ThresholdStatus implements MetricStatus {
	
	public ThresholdStatus(int [] thresholds) throws ThresholdLimitException {
		
		if (thresholds == null  || thresholds.length <= 0 || thresholds.length > 3) {
			throw new ThresholdLimitException("Invalid number of thresholds. Limits 1 to 3");
		}
		
	}

	@Override
	public StatusColor getColorStatus() {
		return StatusColor.Green;
	}

}
