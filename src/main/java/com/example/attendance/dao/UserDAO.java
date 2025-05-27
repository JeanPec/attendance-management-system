package com.example.attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.attendance.model.User;
import com.example.attendance.model.User.Role;
import com.example.attendance.util.DBConnection;

public class UserDAO {
    /**
     * Inserts a new user into the database.
     * 
     * @param user The User object to insert.
     * @return The user_id of the newly created user, or -1 if insertion fails.
     */
    public int addUser(User newUser) {
        String SQL = "INSERT INTO Users (username, password, role, first_name, last_name, email) VALUES (?, ?, ?, ?, ?, ?)";
        int generatedId = -1;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getRole().toString());
            pstmt.setString(4, newUser.getFirst_name());
            pstmt.setString(5, newUser.getLast_name());
            pstmt.setString(6, newUser.getEmail());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error adding user: " + ex.getMessage());
            ex.printStackTrace();
        }

        return generatedId;
    }

    /**
     * Gets a user by id from the database.
     * 
     * @param userId The UserId from the user we want.
     * @return The User we seeked, or -1 if seek fails.
     */
    public User getUserById(int userId) {
        String SQL = "SELECT user_id, username, password, role, first_name, last_name, email, created_at, updated_at FROM Users WHERE id = ?";
        User user = null;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setPassword(rs.getString("password"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException ex) {
            System.err.println("Error getting user by ID: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * Gets a user by UserName from the database.
     * 
     * @param userId The UserName from the user we want.
     * @return The User we seeked, or -1 if seek fails.
     */
    public User getUserByUserName(String userName) {
        String SQL = "SELECT user_id, username, password, role, first_name, last_name, email, created_at, updated_at FROM Users WHERE username = ?";
        User user = null;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setPassword(rs.getString("password"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException ex) {
            System.err.println("Error getting user by name: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * Gets all users from the database.
     * 
     * @return All the users, or -1 if seek fails.
     */
    public User getAllUsers() {
        String SQL = "SELECT user_id, username, password, role, first_name, last_name, email, created_at, updated_at FROM Users";
        User user = null;

        try (Connection conn = DBConnection.getConnection()) {
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(SQL);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setPassword(rs.getString("password"));
                user.setCreated_at(rs.getTimestamp("created_at"));
                user.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException ex) {
            System.err.println("Error getting all users: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * Updates an existing user in the database.
     * 
     * @param user The User object with updated information.
     * @return true if the update was successful, false otherwise.
     */
    public boolean updateUser(User user) {
        String SQL = "UPDATE Users SET username = ?, password = ?, role = ?, first_name = ?, last_name = ?, email = ? WHERE user_id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole().toString());
            pstmt.setString(4, user.getFirst_name());
            pstmt.setString(5, user.getLast_name());
            pstmt.setString(6, user.getEmail());
            pstmt.setInt(7, user.getUserId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            System.err.println("Error updating user: " + ex.getMessage());
            ex.printStackTrace();
        }
        return updated;
    }

    /**
     * Delete an existing user in the database.
     * 
     * @param user The User object to delete.
     * @return true if the update was successful, false otherwise.
     */
    public boolean deleteUser(User user) {
        String SQL = "DELETE FROM Users WHERE user_id = ?";
        boolean deleted = false;

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            System.err.println("Error deleting user: " + ex.getMessage());
            ex.printStackTrace();
        }
        return deleted;
    }
}
