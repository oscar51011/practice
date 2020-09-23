package com.practice.practiceExcel.dto;

import java.util.List;

public class StudentExcelContent {
	private List<String> titles;
	private List<StudentDTO> students;
	
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public List<StudentDTO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
}
