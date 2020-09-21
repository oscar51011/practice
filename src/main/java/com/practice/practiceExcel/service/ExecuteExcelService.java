package com.practice.practiceExcel.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.practiceExcel.dto.StudentDTO;
import com.practice.practiceExcel.dto.StudentExcelContent;

/**
 * Excel 基本讀檔寫檔 ( 使用 POI Library )
 * 參考: https://www.baeldung.com/java-microsoft-excel
 * @author 林聖凱
 *
 */
@Service
public class ExecuteExcelService {

	@SuppressWarnings("resource")
	public StudentExcelContent readExcel(MultipartFile file) throws IOException {
		
		//FileInputStream file = new FileInputStream(new File(filePath));		
		InputStream inputStream = file.getInputStream();  
		Workbook workbook = new XSSFWorkbook(inputStream);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		System.out.println("Sheet名稱: " + sheet.getSheetName());
		
		StudentExcelContent studentExcelContnet = new StudentExcelContent();
		List<String> titles = new ArrayList<String>();
	
		// 處理內容
		List<StudentDTO> students = new ArrayList<StudentDTO>();
		 
		int rowCount = 0;
		
		for (Row row : sheet) {
			// 處理 title
			if(rowCount==0) {
				for(Cell cell : row) {
					titles.add(cell.getStringCellValue());
				}
			} else {
			// 處理 contnet
				int cellIndex = 0;			
				StudentDTO student = new StudentDTO();
			    for (Cell cell : row) {		    		    	
			        switch (cell.getCellType()) {
			            case STRING : { 
			            	if(cellIndex == 1) {
			            		student.setName(cell.getStringCellValue());
			            	}
			            	break;
			            }
			            case NUMERIC: {
			            	if(cellIndex == 0) {
			            		student.setId((int) cell.getNumericCellValue());
			            	}
			            	if(cellIndex == 2) {
			            		student.setAge((int) cell.getNumericCellValue());
			            	}
			            	break;
			            }
					default:
						throw new IllegalArgumentException("error excel cell data fromat");
			        }
			        cellIndex++;		        		      
			    }
			    students.add(student);
			}
		    rowCount++;
		}
			
		studentExcelContnet.setTitles(titles);
		studentExcelContnet.setStudents(students);
		
		return studentExcelContnet;
	}
	
	public void writeExcel(String filePath, String fileName) throws IOException {
		// create workBook xlsx
		Workbook workbook = new XSSFWorkbook();
		// create sheet
		Sheet sheet = workbook.createSheet("工作表1");
		
		// create row
		Row header = sheet.createRow(0);
		// add header value 
		Cell headerCell;
		headerCell = header.createCell(0);
		headerCell.setCellValue("Name");
		
		headerCell = header.createCell(1);
		headerCell.setCellValue("Age");
				
		// add content value
		Cell contentCell;
		Row content;
		
		content = sheet.createRow(1);
		contentCell = content.createCell(0); // add Name
		contentCell.setCellValue("Billy");
		contentCell = content.createCell(1); // add Age
		contentCell.setCellValue(28);
		
		content = sheet.createRow(2);
		contentCell = content.createCell(0); // add Name
		contentCell.setCellValue("Amy");
		contentCell = content.createCell(1); // add Age
		contentCell.setCellValue(44);
		
		// write to file
		String fileLocation = filePath + "\\" + fileName + ".xlsx";
		File file = new File(fileLocation);
		
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
	}
	
}
