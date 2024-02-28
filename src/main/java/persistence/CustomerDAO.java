package persistence;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Customer entities.
 * @author cleonrivas
 */
public class CustomerDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a CustomerDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Customer by its ID.
     *
     * @param id The ID of the Customer to retrieve.
     * @return The Customer with the specified ID, or null if not found.
     */
    public Customer getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    /**
     * Updates or inserts a Customer.
     *
     * @param customer The Customer to be updated or inserted.
     */
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Customer.
     *
     * @param customer The Customer to be inserted.
     * @return The ID of the newly inserted Customer.
     */
    public int insert(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(customer);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Customer.
     *
     * @param customer The Customer to be deleted.
     */
    public void delete(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Customers.
     *
     * @return A list of all Customers.
     */
    public List<Customer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            return query.getResultList();
        }
    }
}
