-- CREATE DATABASE attendance_system;
USE attendance_system;

DROP DATABASE attendance_system;

CREATE DATABASE attendance_system;
USE attendance_system;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'student', 'faculty') NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE NOT NULL,
    student_code VARCHAR(20) UNIQUE NOT NULL,
    enrollment_date DATE,
    major VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Faculty (
    faculty_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE NOT NULL,
    employee_id VARCHAR(20) UNIQUE NOT NULL,
    department VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    course_name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    credits INT
);

CREATE TABLE AttendanceTable (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    attendance_date DATE NOT NULL,
    recorded_by INT NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    status ENUM('present', 'absent', 'late', 'excused') NOT NULL,
    notes VARCHAR(255),
    UNIQUE KEY unique_attendance (student_id, course_id, attendance_date),
    FOREIGN KEY (recorded_by) REFERENCES Faculty(faculty_id),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);