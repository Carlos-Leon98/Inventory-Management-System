package persistence;

import entity.Product;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Product entities.
 * @author cleonrivas
 */
public class ProductDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a Product by its ID.
     *
     * @param id The ID of the Product to retrieve.
     * @return The Product with the specified ID, or null if not found.
     */
    public Product getById(int id) {
        Session session = sessionFactory.openSession();
        Product Product = session.get( Product.class, id );
        session.close();
        return Product;
    }

    /**
     * Updates or inserts a Product.
     *
     * @param product The Product to be updated or inserted.
     */
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(product);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Product.
     *
     * @param product The Product to be inserted.
     * @return The ID of the newly inserted Product.
     */
    public int insert(Product product) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        id = product.getProductId();
        session.close();
        return id;
    }

    /**
     * Deletes a Product.
     *
     * @param product The Product to be deleted.
     */
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Products.
     *
     * @return A list of all Products.
     */
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Product> products = session.createSelectionQuery( query ).getResultList();

        session.close();

        return products;
    }
}
