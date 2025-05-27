package com.example.attendance.model;

import java.sql.Timestamp;

public class User {
    public enum Role {
        admin,
        student,
        faculty
    }

    private int userId;
    private String username;
    private String password;
    private Role role;
    private String first_name;
    private String last_name;
    private String email;
    private Timestamp created_at;
    private Timestamp updated_at;

    public User() {

    }

    public User(int userId, String username, String password, Role role, String first_name, String last_name,
            String email, Timestamp created_at, Timestamp updated_at) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
