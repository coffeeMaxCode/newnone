package com.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);

	public List<Map<String, Object>> testLogic() {
		logger.info("TestLogic.testLogic");
		return null;
	}
	
	public List<Map<String, Object>> membLogic() {
		logger.info("MemberLogic.membLogic");
		return null;
	}
}
