package persistence;

import entity.Product;f
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
 * Data Access Object class for handling Product entities.
 * @author cleonrivas
 */
public class ProductDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a Product by its ID.
     *
     * @param id The ID of the Product to retrieve.
     * @return The Product with the specified ID, or null if not found.
     */
    public Product getById(int id) {
        try {
            logger.info("Product ID: " + id);

            Session session = sessionFactory.openSession();
            Product Product = session.get(Product.class, id);
            session.close();

            logger.info("Product found.");

            return Product;

        } catch (Exception e) {
            logger.error(
                    "Error finding Product: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a Product.
     *
     * @param product The Product to be updated or inserted.
     */
    public void update(Product product) {
        try {
            logger.info(
                    "Updating Product: {}",
                    product
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            session.close();

            logger.info("Product Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Product: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Product.
     *
     * @param product The Product to be inserted.
     * @return The ID of the newly inserted Product.
     */
    public int insert(Product product) {
        try {
            logger.info(
                    "Product to insert: {}",
                    product
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            id = product.getProductId();
            session.close();

            logger.info("Product Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Product: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a Product.
     *
     * @param product The Product to be deleted.
     */
    public void delete(Product product) {
        try {
            logger.info(
                    "Product to delete: {}",
                    product
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            session.close();

            logger.info("Product Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Product: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Products.
     *
     * @return A list of all Products.
     */
    public List<Product> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            List<Product> products = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All products displayed successfully.");

            return products;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
