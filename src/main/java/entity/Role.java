package entity;

import java.sql.Timestamp;

/**
 * Represents a user role in the Inventory Management System.
 * @author cleonrivas
 */
public class Role {
    private int roleId;
    private String name;
    private String description;
    private Timestamp createdAt;

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
                '}';
    }
}
