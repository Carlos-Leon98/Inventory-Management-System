package entity;

import java.sql.Timestamp;

/**
 * Represents a category in the Inventory Management System.
 * @author cleonrivas
 */
public class Category {
    private int categoryId;
    private String categoryName;
    private Timestamp createdAt;

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
     * Set a string with the information of this class
     * @return a string with the information of the class
     */
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
