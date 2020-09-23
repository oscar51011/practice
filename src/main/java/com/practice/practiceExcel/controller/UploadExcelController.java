package com.practice.practiceExcel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.practice.practiceExcel.dto.StudentExcelContent;
import com.practice.practiceExcel.service.ExecuteExcelService;

@Controller
@RequestMapping("/uploadExcel")
public class UploadExcelController {
	
	@Autowired
	private ExecuteExcelService executeExcelService;
	
	@GetMapping("/getExcelUploadView")
	public String getSpringmvcView2(){
		return "excelUpload/excelUploadView.html";
	}
	
	@PostMapping(value = "/uploadExcelAction", consumes = {"multipart/form-data"})
	@ResponseBody
	public StudentExcelContent uploadExcelFile(@RequestParam("uploadfile") MultipartFile multipart) {
		
		System.out.println("上傳檔案名稱:" + multipart.getOriginalFilename());
		
		
		StudentExcelContent studentContent = null;
		try {
			studentContent = executeExcelService.readExcel(multipart);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("標題欄位數量:" + studentContent.getTitles().size());
		System.out.println("學生數量:" + studentContent.getStudents().size());
		
		return studentContent;
	}
	
}
