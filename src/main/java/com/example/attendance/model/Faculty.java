package com.example.attendance.model;

public class Faculty {
    private int facultyId;
    private int userId;
    private String employeeId;
    private String department;
    private User user; // To hold the associated User object

    public Faculty() {
    }

    public Faculty(int facultyId, int userId, String employeeId, String department) {
        this.facultyId = facultyId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters and Setters
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}