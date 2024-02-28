package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a section in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Section")
@Table(name = "Sections")
public class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int sectionId;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "section")
    private Set<Product> products;

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
     * Get the location associated with the section.
     *
     * @return The location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location associated with the section.
     *
     * @param location The location to set.
     */
    public void setLocation(Location location) {
        this.location = location;
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
     * Gets the collection of products that have the same
     * category.
     *
     * @return The set of products that have the same category.
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Sets the collection of products that have the same
     * category.
     *
     * @param products The set of products that have the same category.
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
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
                ", location=" + location +
                ", createdAt=" + createdAt +
                ", products=" + products +
                '}';
    }
}
