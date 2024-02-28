package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents an order in the Inventory Management System.
 * @author cleonrivas
 */
public class Order {
    private int orderId;
    private int customerId;
    private Timestamp orderDate;
    private BigDecimal totalAmount;
    private String status;
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
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID associated with the order.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
