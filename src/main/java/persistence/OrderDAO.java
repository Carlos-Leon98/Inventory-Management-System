package persistence;

import entity.Order;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Order entities.
 * @author cleonrivas
 */
public class OrderDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves an Order by its ID.
     *
     * @param id The ID of the Order to retrieve.
     * @return The Order with the specified ID, or null if not found.
     */
    public Order getById(int id) {
        Session session = sessionFactory.openSession();
        Order Order = session.get( Order.class, id );
        session.close();
        return Order;
    }

    /**
     * Updates or inserts an Order.
     *
     * @param order The Order to be updated or inserted.
     */
    public void update(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(order);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Order.
     *
     * @param order The Order to be inserted.
     * @return The ID of the newly inserted Order.
     */
    public int insert(Order order) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(order);
        transaction.commit();
        id = order.getOrderId();
        session.close();
        return id;
    }

    /**
     * Deletes an Order.
     *
     * @param order The Order to be deleted.
     */
    public void delete(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(order);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Orders.
     *
     * @return A list of all Orders.
     */
    public List<Order> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);
        List<Order> orders = session.createSelectionQuery( query ).getResultList();

        session.close();

        return orders;
    }
}
