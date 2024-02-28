package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a user role in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Role")
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int roleId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    /**
     * No-arg constructor.
     */
    public Role() {
    }

    /**
     * Get the role ID.
     *
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Set the role ID.
     *
     * @param roleId The role ID to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Get the name of the role.
     *
     * @return The name of the role.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the role.
     *
     * @param name The name of the role to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the role.
     *
     * @return The description of the role.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the role.
     *
     * @param description The description of the role to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the creation timestamp of the role.
     *
     * @return The creation timestamp of the role.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the role.
     *
     * @param createdAt The creation timestamp of the role to set.
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the collection of users with a specific role.
     *
     * @return The set of users with a specific role.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets the collection of users with a specific role.
     *
     * @param users The set of users with a specific role.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Set a string with the information of this class
     * @return a string with the information of the class
     */
    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", users=" + users +
                '}';
    }
}
