package com.lld.logger.loggerLLD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LldForLoggerApplicationTests {

	@Test
	void testLogger() {

		Logger logger = Logger.getLogger();
		logger.error("THIS is a debug message");
	}

}
