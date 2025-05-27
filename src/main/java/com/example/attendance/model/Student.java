package com.example.attendance.model;

import java.sql.Date;

public class Student {
    private int studentId;
    private int userId;
    private String studentCode;
    private Date enrollmentDate;
    private String major;
    private User user; // To hold the associated User object

    public Student() {
    }

    public Student(int studentId, int userId, String studentCode, Date enrollmentDate, String major) {
        this.studentId = studentId;
        this.userId = userId;
        this.studentCode = studentCode;
        this.enrollmentDate = enrollmentDate;
        this.major = major;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}