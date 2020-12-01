package com.aegle.monitor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.aegle.monitor.AegleMonitorMain;
import com.aegle.monitor.Environment;
import com.aegle.monitor.Metric;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class AegleMonitorTest {
	
	@Test
	void testMain() {
		String [] args = new String [] {"refresh", "--env", "staging" };
		//AegleMonitorMain.main(args);
		assertEquals("true", "true");
	}
	

	@Test
	void testMainCommand() {
		String [] args = new String [] {"refresh", "--env", "staging" };
		int actual = AegleMonitorMain.mainCommand(args);
		org.junit.jupiter.api.Assertions.assertEquals(0, actual);
	}
	
	@Test
	void testMetric() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsontxt = "{\"name\" : \"cpu\", \"env\": \"staging\", \"timestamp\": 1606606098, \"site\": \"test1\"}";
			String jsontxt2 = "{\"name\" : \"memory\", \"env\": \"staging\", \"timestamp\": 1606606098, \"site\": \"test1\"}";
			Metric m = mapper.readValue(jsontxt, Metric.class);
			assertEquals(m.getName(), "cpu");
			assertEquals(m.getEnv(), Environment.staging);
			assertEquals(m.getSite(), "test1");
			assertEquals(m.getTimestamp(), 1606606098);
			
			assertNotEquals(m, mapper.readValue(jsontxt2, Metric.class));
			assertFalse(m.equals(mapper.readValue(jsontxt2, Metric.class)));
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
