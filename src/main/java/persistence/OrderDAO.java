package persistence;

import entity.Order;
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
 * Data Access Object class for handling Order entities.
 * @author cleonrivas
 */
public class OrderDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves an Order by its ID.
     *
     * @param id The ID of the Order to retrieve.
     * @return The Order with the specified ID, or null if not found.
     */
    public Order getById(int id) {
        try {
            logger.info("Order ID: " + id);

            Session session = sessionFactory.openSession();
            Order Order = session.get(Order.class, id);
            session.close();

            logger.info("Order found.");

            return Order;

        } catch (Exception e) {
            logger.error(
                    "Error finding Order: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts an Order.
     *
     * @param order The Order to be updated or inserted.
     */
    public void update(Order order) {
        try {
            logger.info(
                    "Updating Order: {}",
                    order
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
            session.close();

            logger.info("Order Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Order: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Order.
     *
     * @param order The Order to be inserted.
     * @return The ID of the newly inserted Order.
     */
    public int insert(Order order) {
        try {
            logger.info(
                    "Order to insert: {}",
                    order
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
            id = order.getOrderId();
            session.close();

            logger.info("Order Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Order: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes an Order.
     *
     * @param order The Order to be deleted.
     */
    public void delete(Order order) {
        try {
            logger.info(
                    "Order to delete: {}",
                    order
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
            session.close();

            logger.info("Order Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Order: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Orders.
     *
     * @return A list of all Orders.
     */
    public List<Order> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            List<Order> orders = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All orders displayed successfully.");

            return orders;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
