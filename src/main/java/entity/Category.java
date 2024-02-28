package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a category in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Category")
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "name")
    private String categoryName;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "Products", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    /**
     * No-arg constructor
     */
    public Category() {
    }

    /**
     * Get the category ID.
     *
     * @return The category ID.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set the category ID.
     *
     * @param categoryId The category ID to set.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Get the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return categoryName;
    }

    /**
     * Set the name of the category.
     *
     * @param name The name of the category to set.
     */
    public void setName(String name) {
        this.categoryName = name;
    }

    /**
     * Get the creation timestamp of the category.
     *
     * @return The creation timestamp of the category.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the category.
     *
     * @param createdAt The creation timestamp of the category to set.
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
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createdAt=" + createdAt +
                ", products=" + products +
                '}';
    }
}
