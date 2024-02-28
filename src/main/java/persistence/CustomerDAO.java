package persistence;

import entity.Category;
import entity.Customer;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Customer entities.
 * @author cleonrivas
 */
public class CustomerDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Retrieves a Customer by its ID.
     *
     * @param id The ID of the Customer to retrieve.
     * @return The Customer with the specified ID, or null if not found.
     */
    public Customer getById(int id) {
        Session session = sessionFactory.openSession();
        Customer Customer = session.get( Customer.class, id );
        session.close();
        return Customer;
    }

    /**
     * Updates or inserts a Customer.
     *
     * @param customer The Customer to be updated or inserted.
     */
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customer);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Customer.
     *
     * @param customer The Customer to be inserted.
     * @return The ID of the newly inserted Customer.
     */
    public int insert(Customer customer) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        id = customer.getCustomerId();
        session.close();
        return id;
    }

    /**
     * Deletes a Customer.
     *
     * @param customer The Customer to be deleted.
     */
    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Customers.
     *
     * @return A list of all Customers.
     */
    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        List<Customer> customers = session.createSelectionQuery( query ).getResultList();

        session.close();

        return customers;
    }
}
