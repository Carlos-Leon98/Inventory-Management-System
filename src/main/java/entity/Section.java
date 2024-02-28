package entity;

import java.sql.Timestamp;

/**
 * Represents a section in the Inventory Management System.
 * @author cleonrivas
 */
public class Section {
    private int sectionId;
    private String name;
    private int locationId;
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public Section() {
    }

    /**
     * Get the section ID.
     *
     * @return The section ID.
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     * Set the section ID.
     *
     * @param sectionId The section ID to set.
     */
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Get the name of the section.
     *
     * @return The name of the section.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the section.
     *
     * @param name The name of the section to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the location ID associated with the section.
     *
     * @return The location ID.
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Set the location ID associated with the section.
     *
     * @param locationId The location ID to set.
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Get the creation timestamp of the section.
     *
     * @return The creation timestamp of the section.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the section.
     *
     * @param createdAt The creation timestamp of the section to set.
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
        return "Section{" +
                "sectionId=" + sectionId +
                ", name='" + name + '\'' +
                ", locationId=" + locationId +
                ", createdAt=" + createdAt +
                '}';
    }
}
