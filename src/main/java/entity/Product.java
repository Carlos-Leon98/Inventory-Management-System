package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents a product in the Inventory Management System.
 * @author cleonrivas
 */
public class Product {
    private int productId;
    private String name;
    private String description;
    private int quantity;
    private int categoryId;
    private int locationId;
    private int sectionId;
    private BigDecimal price;
    private BigDecimal salesPrice;
    private String isbn;
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public Product() {
    }

    /**
     * Get the product ID.
     *
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set the product ID.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Get the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The name of the product to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the product.
     *
     * @param description The description of the product to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product.
     *
     * @param quantity The quantity of the product to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the category ID associated with the product.
     *
     * @return The category ID.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set the category ID associated with the product.
     *
     * @param categoryId The category ID to set.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Get the location ID associated with the product.
     *
     * @return The location ID.
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Set the location ID associated with the product.
     *
     * @param locationId The location ID to set.
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Get the section ID associated with the product.
     *
     * @return The section ID.
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     * Set the section ID associated with the product.
     *
     * @param sectionId The section ID to set.
     */
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The price of the product to set.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Get the sales price of the product.
     *
     * @return The sales price of the product.
     */
    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    /**
     * Set the sales price of the product.
     *
     * @param salesPrice The sales price of the product to set.
     */
    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * Get the ISBN of the product.
     *
     * @return The ISBN of the product.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set the ISBN of the product.
     *
     * @param isbn The ISBN of the product to set.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the creation timestamp of the product.
     *
     * @return The creation timestamp of the product.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the product.
     *
     * @param createdAt The creation timestamp of the product to set.
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
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", categoryId=" + categoryId +
                ", locationId=" + locationId +
                ", sectionId=" + sectionId +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", isbn='" + isbn + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
