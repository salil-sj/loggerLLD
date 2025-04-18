package com.lld.logger.loggerLLD;

import com.lld.logger.loggerLLD.constants.LogLevel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LldForLoggerApplicationTests {

	@Test
	void testLogger() {

		Logger logger = Logger.getLogger();
		logger.error("This is a error msg");
		logger.info("This is an info msg");
	}

}
