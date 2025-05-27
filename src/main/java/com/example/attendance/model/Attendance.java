package com.example.attendance.model;

import java.sql.Date;

public class Attendance {
    enum Status {
        present,
        absent,
        late,
        excused
    }

    private Integer attendanceId;
    private Integer studentId;
    private Integer courseId;
    private Date attendanceDate;
    private Status status;
    private Integer recordedBy;
    private String notes;
    private Student student;
    private Course course;
    private Faculty faculty;

    public Integer getattendanceId() {
        return attendanceId;
    }

    public void setattendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getstudentId() {
        return studentId;
    }

    public void setstudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getcourseId() {
        return courseId;
    }

    public void setcourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getattendanceDate() {
        return attendanceDate;
    }

    public void setattendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getrecordedBy() {
        return recordedBy;
    }

    public void setrecordedBy(Integer recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
