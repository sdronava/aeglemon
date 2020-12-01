package com.aegle.monitor.status;

import lombok.Getter;
import lombok.Setter;

public class BooleanStatus implements MetricStatus {
	
	private @Getter @Setter boolean status;

	@Override
	public StatusColor getColorStatus() {
		return (isStatus()) ? StatusColor.Green: StatusColor.Red;
	}
	
	public BooleanStatus(boolean status) {
		setStatus(status);
	}
	

}
