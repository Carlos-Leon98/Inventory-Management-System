package entity;

import java.sql.Timestamp;

/**
 * Represents a location in the Inventory Management System.
 * @author cleonrivas
 */
public class Location {
    private int locationId;
    private String name;
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public Location() {
    }

    /**
     * Get the location ID.
     *
     * @return The location ID.
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Set the location ID.
     *
     * @param locationId The location ID to set.
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Get the name of the location.
     *
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the location.
     *
     * @param name The name of the location to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the creation timestamp of the location.
     *
     * @return The creation timestamp of the location.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the location.
     *
     * @param createdAt The creation timestamp of the location to set.
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
        return "Location{" +
                "locationId=" + locationId +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
