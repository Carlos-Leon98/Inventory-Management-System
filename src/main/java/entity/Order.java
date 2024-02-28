package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


/**
 * Represents an order in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Order")
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "order_id")
    private int orderId;
    @ManyToOne
    private Customer customerId;
    @ManyToMany
    @JoinTable(
            name = "OrderDetails",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public Order() {
    }

    /**
     * Get the order ID.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the order ID.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the customer ID associated with the order.
     *
     * @return The customer ID.
     */
    public Customer getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID associated with the order.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
     * Get the order date.
     *
     * @return The order date.
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * Set the order date.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Get the total amount of the order.
     *
     * @return The total amount of the order.
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the total amount of the order.
     *
     * @param totalAmount The total amount of the order to set.
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order.
     *
     * @param status The status of the order to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the creation timestamp of the order.
     *
     * @return The creation timestamp of the order.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the order.
     *
     * @param createdAt The creation timestamp of the order to set.
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
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
