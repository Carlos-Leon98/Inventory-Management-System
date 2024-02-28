package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Represents a customer in the Inventory Management System.
 * @author cleonrivas
 */
@Entity(name = "Customer")
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "billing_address")
    private String billingAddress;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    /**
     * No-arg constructor
     */
    public Customer() {
    }

    /**
     * Get the customer ID.
     *
     * @return The customer ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the first name of the customer.
     *
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer.
     *
     * @param firstName The first name of the customer to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the customer.
     *
     * @return The last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer.
     *
     * @param lastName The last name of the customer to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the email of the customer.
     *
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the customer.
     *
     * @param email The email of the customer to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the customer.
     *
     * @param phoneNumber The phone number of the customer to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the billing address of the customer.
     *
     * @return The billing address of the customer.
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * Set the billing address of the customer.
     *
     * @param billingAddress The billing address of the customer to set.
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Get the shipping address of the customer.
     *
     * @return The shipping address of the customer.
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Set the shipping address of the customer.
     *
     * @param shippingAddress The shipping address of the customer to set.
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Get the creation timestamp of the customer.
     *
     * @return The creation timestamp of the customer.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the creation timestamp of the customer.
     *
     * @param createdAt The creation timestamp of the customer to set.
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the collection of orders that belongs to customer.
     *
     * @return The set of orders that belongs to customer.
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * Sets the collection of orders that belongs to customer.
     *
     * @param orders The set of orders that belongs to customer.
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    /**
     * Set a string with the information of this class
     * @return a string with the information of the class
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", createdAt=" + createdAt +
                ", orders=" + orders +
                '}';
    }
}
