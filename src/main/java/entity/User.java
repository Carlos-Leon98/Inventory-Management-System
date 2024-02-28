package entity;

import java.sql.Timestamp;

/**
 * Represents a user in the Inventory Management System.
 * @author cleonrivas
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private int roleId;
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public User() {
    }

    /**
     * Get the user ID.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user ID.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the user.
     *
     * @param username The username of the user to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The password of the user to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the role ID associated with the user.
     *
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Set the role ID associated with the user.
     *
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Get the creation timestamp of the user.
     *
     * @return The creation timestamp of the user.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the user.
     *
     * @param createdAt The creation timestamp of the user to set.
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Set a string with the information of this class
     * @return a string with the information of the class
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", createdAt=" + createdAt +
                '}';
    }
}
