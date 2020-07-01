package com.xjtuse.entity;

import javax.swing.*;

public class Student {
    private String stuentID;
    private String studentName;
    private String studentAge;
    private String studentGender;
    private String studentEmail;
    private String studentClass;
    private String studnetUsername;
    private String studnetPassword;
    private String insertDate;

    @Override
    public String toString() {
        return "Student{" +
                "stuentID='" + stuentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studnetUsername='" + studnetUsername + '\'' +
                ", studnetPassword='" + studnetPassword + '\'' +
                ", insertDate='" + insertDate + '\'' +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student(String stuentID, String studentName, String studentAge, String studentGender, String studentEmail, String studentClass, String studnetUsername, String studnetPassword, String insertDate) {
        this.stuentID = stuentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentEmail = studentEmail;
        this.studentClass = studentClass;
        this.studnetUsername = studnetUsername;
        this.studnetPassword = studnetPassword;
        this.insertDate = insertDate;
    }

    public String getStuentID() {
        return stuentID;
    }

    public void setStuentID(String stuentID) {
        stuentID = stuentID;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudnetUsername() {
        return studnetUsername;
    }

    public void setStudnetUsername(String studnetUsername) {
        this.studnetUsername = studnetUsername;
    }

    public String getStudnetPassword() {
        return studnetPassword;
    }

    public void setStudnetPassword(String studnetPassword) {
        this.studnetPassword = studnetPassword;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

}
