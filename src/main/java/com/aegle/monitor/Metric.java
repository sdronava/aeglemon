package com.aegle.monitor;

import lombok.Getter;
import lombok.Setter;

public  class Metric {
	
	private @Getter @Setter  String name;
	private @Getter @Setter  Environment env;
	private @Getter @Setter  Long timestamp;
	private @Getter @Setter  String site;
	
	public Metric() {}
	
}
