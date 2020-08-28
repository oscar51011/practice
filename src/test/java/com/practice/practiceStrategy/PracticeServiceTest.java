package com.practice.practiceStrategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.PracticeApplication;

@SpringBootTest(classes = {PracticeApplication.class})
class PracticeServiceTest {
	
	@Autowired
	private PracticeService service;

	@Test
	void testPracticeStrategy() {
		service.practiceStrategy();
	}

}
