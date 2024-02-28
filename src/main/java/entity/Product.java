package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a product in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Product")
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "sales_price")
    private BigDecimal salesPrice;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

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
     * Get the category associated with the product.
     *
     * @return The category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the category associated with the product.
     *
     * @param category The category to set.
     */
    public void setCategoryId(Category category) {
        this.category = category;
    }

    /**
     * Get the location associated with the product.
     *
     * @return The location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location associated with the product.
     *
     * @param location The location to set.
     */
    public void setLocationId(Location location) {
        this.location = location;
    }

    /**
     * Get the section associated with the product.
     *
     * @return The section.
     */
    public Section getSection() {
        return section;
    }

    /**
     * Set the section associated with the product.
     *
     * @param section The section to set.
     */
    public void setSectionId(Section section) {
        this.section = section;
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
     * Gets the collection of order details.
     *
     * @return The set of order details.
     */
    public Set<OrderDetail> getProducts() {
        return orderDetails;
    }

    /**
     * Sets the collection of order details.
     *
     * @param orderDetails The set of order details.
     */
    public void setProducts(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
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
                ", category=" + category +
                ", location=" + location +
                ", section=" + section +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", isbn='" + isbn + '\'' +
                ", createdAt=" + createdAt +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
