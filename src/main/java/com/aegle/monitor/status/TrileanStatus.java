package com.aegle.monitor.status;

import lombok.Getter;
import lombok.Setter;

public class TrileanStatus implements MetricStatus {
	
	private  @Getter @Setter StatusTrileon status;
	
	public TrileanStatus (StatusTrileon status) { 
		setStatus(status);
	}

	@Override
	public StatusColor getColorStatus() {
		return getStatus() == StatusTrileon.Green ? StatusColor.Green : 
				getStatus() == StatusTrileon.Red ? StatusColor.Red: StatusColor.Empty;
		
	}

}
