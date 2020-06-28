package com.hwadee.hello.entity;

public class Student {
	
	private Integer stuId;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuPro;
	private String stuGrade;
	private int stuIntegrity;
	
	
	public Student() {
	}
	public Student(String stuName, String stuSex, int stuAge, String stuPro) {
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuPro = stuPro;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuPro() {
		return stuPro;
	}
	public void setStuPro(String stuPro) {
		this.stuPro = stuPro;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	public int getStuIntegrity() {
		return stuIntegrity;
	}
	public void setStuIntegrity(int stuIntegrity) {
		this.stuIntegrity = stuIntegrity;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuAge=" + stuAge
				+ ", stuPro=" + stuPro + ", stuGrade=" + stuGrade + ", stuIntegrity=" + stuIntegrity + "]";
	}

}
