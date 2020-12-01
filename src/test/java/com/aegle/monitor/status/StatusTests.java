package com.aegle.monitor.status;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatusTests {

	@Test
	void testBooleanGreen() {
		BooleanStatus status = new BooleanStatus(true);
		assertEquals(status.getColorStatus(), StatusColor.Green);
	}

	@Test
	void testBooleanRed() {
		BooleanStatus status = new BooleanStatus(false);
		assertEquals(status.getColorStatus(), StatusColor.Red);
	}
	
	@Test
	void testTrileanGreen() {
		TrileanStatus status = new TrileanStatus(StatusTrileon.Green);
		assertEquals(status.getColorStatus(), StatusColor.Green);
	}

	@Test
	void testTrileanRed() {
		TrileanStatus status = new TrileanStatus(StatusTrileon.Red);
		assertEquals(status.getColorStatus(), StatusColor.Red);
	}
	
	@Test
	void testTrileanUnset() {
		TrileanStatus status = new TrileanStatus(StatusTrileon.Unset);
		assertEquals(status.getColorStatus(), StatusColor.Empty);
	}
}
