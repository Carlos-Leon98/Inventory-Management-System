package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;

/**
 * Represents a user in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "User")
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "created_at")
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
     * Get the first name of the customer.
     *
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer.
     *
     * @param firstName The first name of the customer to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the customer.
     *
     * @return The last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer.
     *
     * @param lastName The last name of the customer to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the role associated with the user.
     *
     * @return The role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the role associated with the user.
     *
     * @param role The role to set.
     */
    public void setRole(Role role) {
        this.role = role;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}
