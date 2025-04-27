package com.hw3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class Hw3ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void mainMethodRunsWithoutExceptions() {
		System.setProperty("server.port", "0");
		assertDoesNotThrow(() -> Hw3Application.main(new String[]{}));
	}

}
