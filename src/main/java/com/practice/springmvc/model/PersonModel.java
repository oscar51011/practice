package com.practice.springmvc.model;

/**
 * 練習 springmvc 的 DTO
 * @author 林聖凱
 *
 */
public class PersonModel {
	private int id;			//流水碼
	private String name;	//姓名
	private String sex;		//性別
	private int age;		//年紀
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
