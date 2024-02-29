package persistence;

import entity.OrderDetail;
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
 * Data Access Object class for handling OrderDetail entities.
 * @author cleonrivas
 */
public class OrderDetailDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves an OrderDetail by its ID.
     *
     * @param id The ID of the OrderDetail to retrieve.
     * @return The OrderDetail with the specified ID, or null if not found.
     */
    public OrderDetail getById(int id) {
        try {
            logger.info("Order Detail ID: " + id);

            Session session = sessionFactory.openSession();
            OrderDetail OrderDetail = session.get(OrderDetail.class, id);
            session.close();

            logger.info("Order Detail found.");

            return OrderDetail;

        } catch (Exception e) {
            logger.error(
                    "Error finding Order Detail: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be updated or inserted.
     */
    public void update(OrderDetail orderDetail) {
        try {
            logger.info(
                    "Updating Order Detail: {}",
                    orderDetail
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(orderDetail);
            transaction.commit();
            session.close();

            logger.info("Order Detail Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Order Detail: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new OrderDetail.
     *
     * @param orderDetail The OrderDetail to be inserted.
     * @return The ID of the newly inserted OrderDetail.
     */
    public int insert(OrderDetail orderDetail) {
        try {
            logger.info(
                    "Order Detail to insert: {}",
                    orderDetail
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(orderDetail);
            transaction.commit();
            id = orderDetail.getOrderDetailId();
            session.close();

            logger.info("Order Detail Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Order Detail: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be deleted.
     */
    public void delete(OrderDetail orderDetail) {
        try {
            logger.info(
                    "Order Detail to delete: {}",
                    orderDetail
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(orderDetail);
            transaction.commit();
            session.close();

            logger.info("Order Detail Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Order Detail: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all OrderDetails.
     *
     * @return A list of all OrderDetails.
     */
    public List<OrderDetail> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<OrderDetail> query = builder.createQuery(OrderDetail.class);
            Root<OrderDetail> root = query.from(OrderDetail.class);
            List<OrderDetail> orderDetails = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All order details displayed successfully.");

            return orderDetails;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
