package com.practice.parseExcel.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.practice.practiceExcel.service.ExecuteExcelService;

class ParseExcelServiceTest {
	
	private ExecuteExcelService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new ExecuteExcelService();
	}

//	@Test
//	void testReadExcelXlsxFormat() throws IOException {
//		String excelPathXlsxFormat = "C:\\Users\\林聖凱\\Desktop\\testExcel\\student.xlsx";
//		service.readExcel(excelPathXlsxFormat);
//	}
//	
//	// TODO
//	@Test
//	void testReadExcelXlsFormat() throws IOException {
//		String excelPathXlsFormat = "C:\\Users\\林聖凱\\Desktop\\testExcel\\test2.xls";
//		service.readExcel(excelPathXlsFormat);
//	}
	
	
	@Test
	void testWriteExcel() throws IOException {
		String execelOutputFolder = "C:\\Users\\林聖凱\\Desktop\\testExcel\\output";
		String fileName = "temp";
		service.writeExcel(execelOutputFolder, fileName);
	}

}
