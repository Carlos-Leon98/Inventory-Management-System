package persistence;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Product entities.
 * @author cleonrivas
 */
public class ProductDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a ProductDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Product by its ID.
     *
     * @param id The ID of the Product to retrieve.
     * @return The Product with the specified ID, or null if not found.
     */
    public Product getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    /**
     * Updates or inserts a Product.
     *
     * @param product The Product to be updated or inserted.
     */
    public void update(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Product.
     *
     * @param product The Product to be inserted.
     * @return The ID of the newly inserted Product.
     */
    public int insert(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(product);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Product.
     *
     * @param product The Product to be deleted.
     */
    public void delete(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Products.
     *
     * @return A list of all Products.
     */
    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            return query.getResultList();
        }
    }
}
