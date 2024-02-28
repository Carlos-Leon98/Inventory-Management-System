package persistence;

import entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling OrderDetail entities.
 * @author cleonrivas
 */
public class OrderDetailDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs an OrderDetailDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public OrderDetailDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves an OrderDetail by its ID.
     *
     * @param id The ID of the OrderDetail to retrieve.
     * @return The OrderDetail with the specified ID, or null if not found.
     */
    public OrderDetail getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(OrderDetail.class, id);
        }
    }

    /**
     * Updates or inserts an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be updated or inserted.
     */
    public void update(OrderDetail orderDetail) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(orderDetail);
            transaction.commit();
        }
    }

    /**
     * Inserts a new OrderDetail.
     *
     * @param orderDetail The OrderDetail to be inserted.
     * @return The ID of the newly inserted OrderDetail.
     */
    public int insert(OrderDetail orderDetail) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(orderDetail);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be deleted.
     */
    public void delete(OrderDetail orderDetail) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(orderDetail);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all OrderDetails.
     *
     * @return A list of all OrderDetails.
     */
    public List<OrderDetail> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<OrderDetail> query = session.createQuery("FROM OrderDetail", OrderDetail.class);
            return query.getResultList();
        }
    }
}
