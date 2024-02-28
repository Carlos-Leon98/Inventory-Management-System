package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents the details of a product included
 * in an order in the Inventory Management System.
 * @author cleonrivas
 */
public class OrderDetail {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private int quantity;
    private BigDecimal unitPrice;
    private Timestamp createdAt;

    /**
     * No-arg constructor.
     */
    public OrderDetail() {
    }

    /**
     * Get the order detail ID.
     *
     * @return The order detail ID.
     */
    public int getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * Set the order detail ID.
     *
     * @param orderDetailId The order detail ID to set.
     */
    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * Get the order ID associated with the order detail.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the order ID associated with the order detail.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the product ID associated with the order detail.
     *
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set the product ID associated with the order detail.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Get the quantity of the product in the order detail.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product in the order detail.
     *
     * @param quantity The quantity of the product to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the unit price of the product in the order detail.
     *
     * @return The unit price of the product.
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set the unit price of the product in the order detail.
     *
     * @param unitPrice The unit price of the product to set.
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Get the creation timestamp of the order detail.
     *
     * @return The creation timestamp of the order detail.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the order detail.
     *
     * @param createdAt The creation timestamp of the order detail to set.
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
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}
