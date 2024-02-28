package persistence;

import entity.OrderDetail;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling OrderDetail entities.
 * @author cleonrivas
 */
public class OrderDetailDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves an OrderDetail by its ID.
     *
     * @param id The ID of the OrderDetail to retrieve.
     * @return The OrderDetail with the specified ID, or null if not found.
     */
    public OrderDetail getById(int id) {
        Session session = sessionFactory.openSession();
        OrderDetail OrderDetail = session.get( OrderDetail.class, id );
        session.close();
        return OrderDetail;
    }

    /**
     * Updates or inserts an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be updated or inserted.
     */
    public void update(OrderDetail orderDetail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(orderDetail);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new OrderDetail.
     *
     * @param orderDetail The OrderDetail to be inserted.
     * @return The ID of the newly inserted OrderDetail.
     */
    public int insert(OrderDetail orderDetail) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(orderDetail);
        transaction.commit();
        id = orderDetail.getOrderDetailId();
        session.close();
        return id;
    }

    /**
     * Deletes an OrderDetail.
     *
     * @param orderDetail The OrderDetail to be deleted.
     */
    public void delete(OrderDetail orderDetail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orderDetail);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all OrderDetails.
     *
     * @return A list of all OrderDetails.
     */
    public List<OrderDetail> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderDetail> query = builder.createQuery(OrderDetail.class);
        Root<OrderDetail> root = query.from(OrderDetail.class);
        List<OrderDetail> orderDetails = session.createSelectionQuery( query ).getResultList();

        session.close();

        return orderDetails;
    }
}
