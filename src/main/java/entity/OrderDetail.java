package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Represents the details of a product included
 * in an order in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "OrderDetail")
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int orderDetailId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "created_at")
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
     * Get the order associated with the order detail.
     *
     * @return The order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Set the order associated with the order detail.
     *
     * @param order The order to set.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Get the product associated with the order detail.
     *
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the product associated with the order detail.
     *
     * @param product The product to set.
     */
    public void setProductId(Product product) {
        this.product = product;
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
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}
