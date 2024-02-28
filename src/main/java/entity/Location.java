package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a location in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Location")
@Table(name = "Locations")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "name")
    private String name;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "Locations", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Section> sections;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

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
     * Gets the collection of sections that belongs to the same
     * location.
     *
     * @return The set of sections that belongs to the same location.
     */
    public Set<Section> getSections() {
        return sections;
    }

    /**
     * Sets the collection of sections that belongs to the
     * same location.
     *
     * @param sections The set of sections that belongs to the same location.
     */
    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets products.
     *
     * @param product the product
     */
    public void setAuthor(Product product) {
        this.product = product;
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
                ", sections=" + sections +
                ", product=" + product +
                '}';
    }
}
