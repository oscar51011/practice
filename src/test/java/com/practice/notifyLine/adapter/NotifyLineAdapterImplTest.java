package com.practice.notifyLine.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.PracticeApplication;
import com.practice.notifyLine.dto.NotifyResult;
import com.practice.notifyLine.dto.NotifyTokenCheckResult;
import com.practice.notifyLine.service.adapter.NotifyLineAdapter;

@SpringBootTest(classes = {PracticeApplication.class})
class NotifyLineAdapterImplTest {
	
	@Qualifier("notifyLineAdapterImpl")
	@Autowired
	private NotifyLineAdapter adapter;

	@Test
	void testSendLineNotify_ConnectionStatusIsOK() {
		
		int expected = 200;
		
		NotifyResult notifyResult = adapter.sendLineNotifyMessage("test");
		int actual = notifyResult.getStatus();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckLineNotifyTokenVaild_StatusIsOK() {
		
		int expected = 200;
		
		NotifyTokenCheckResult notifyTokenCheckResult = adapter.checkLineNotifyTokenVaild();
		int actual = notifyTokenCheckResult.getStatus();
		
		assertEquals(expected, actual);
	}
	
}
