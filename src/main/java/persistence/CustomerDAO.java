package persistence;

import entity.Customer;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Data Access Object class for handling Customer entities.
 * @author cleonrivas
 */
public class CustomerDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a Customer by its ID.
     *
     * @param id The ID of the Customer to retrieve.
     * @return The Customer with the specified ID, or null if not found.
     */
    public Customer getById(int id) {
        try {
            logger.info("Customer ID: " + id);

            Session session = sessionFactory.openSession();
            Customer Customer = session.get(Customer.class, id);
            session.close();

            logger.info("Customer found.");

            return Customer;

        } catch (Exception e) {
            logger.error(
                    "Error finding Customer: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a Customer.
     *
     * @param customer The Customer to be updated or inserted.
     */
    public void update(Customer customer) {
        try {
            logger.info(
                    "Updating Customer: {}",
                    customer
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            session.close();

            logger.info("Customer Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Customer: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Customer.
     *
     * @param customer The Customer to be inserted.
     * @return The ID of the newly inserted Customer.
     */
    public int insert(Customer customer) {
        try {
            logger.info(
                    "Customer to insert: {}",
                    customer
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            id = customer.getCustomerId();
            session.close();

            logger.info("Customer Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Customer: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a Customer.
     *
     * @param customer The Customer to be deleted.
     */
    public void delete(Customer customer) {
        try {
            logger.info(
                    "Customer to delete: {}",
                    customer
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
            session.close();

            logger.info("Customer Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Customer: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Customers.
     *
     * @return A list of all Customers.
     */
    public List<Customer> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);
            List<Customer> customers = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All customers displayed successfully.");

            return customers;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
