package persistence;

import entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Order entities.
 * @author cleonrivas
 */
public class OrderDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs an OrderDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public OrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves an Order by its ID.
     *
     * @param id The ID of the Order to retrieve.
     * @return The Order with the specified ID, or null if not found.
     */
    public Order getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }

    /**
     * Updates or inserts an Order.
     *
     * @param order The Order to be updated or inserted.
     */
    public void update(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(order);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Order.
     *
     * @param order The Order to be inserted.
     * @return The ID of the newly inserted Order.
     */
    public int insert(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(order);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes an Order.
     *
     * @param order The Order to be deleted.
     */
    public void delete(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Orders.
     *
     * @return A list of all Orders.
     */
    public List<Order> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order", Order.class);
            return query.getResultList();
        }
    }
}
