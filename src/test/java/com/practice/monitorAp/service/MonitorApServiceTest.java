package com.practice.monitorAp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.practice.PracticeApplication;
import com.practice.monitorAp.dao.MonitorApDao;

@SpringBootTest(classes = {PracticeApplication.class})
class MonitorApServiceTest {
	
	@Mock
	MonitorApDao dao;
	
	@InjectMocks
	MonitorApService service;
	
	@BeforeEach
	public void init() {
		// 將參數預設成  env 環境
		ReflectionTestUtils.setField(service, "apEnviroment", "env");
		MockitoAnnotations.initMocks(this);
	}

	// TODO: 後續補齊
	@Test
	void testGetConnectionInfo_ConnectionSuccess() {
		
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("enviroment", "env");
		expected.put("dbConnection", "SUCCESS");
		
		when(dao.getDbConnection()).thenReturn(1);
		
		Map<String, String> actual = service.getConnectionInfo();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetConnectionInfo_ConnectionReturnNotSuccess() {
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("enviroment", "env");
		expected.put("dbConnection", "FAILED");
		
		when(dao.getDbConnection()).thenReturn(2);
		
		Map<String, String> actual = service.getConnectionInfo();
		
		assertEquals(expected, actual);
	}
	
	//@Test
	// TODO: 如何預期讓 mockito 模擬錯誤 ?
	// 還是其實不應該拋 Exception 有待商榷
	void testGetConnectionInfo_ConnectionThrowException() {
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("enviroment", "env");
		expected.put("dbConnection", "FAILED");
				
		Map<String, String> actual = service.getConnectionInfo();
		
		assertEquals(expected, actual);
	}

}
