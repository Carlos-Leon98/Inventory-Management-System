package persistence;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EntitiesDAO<T> {
    private final SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger logger = LogManager.getLogger(EntitiesDAO.class);
    private final Class<T> entityClass;

    public EntitiesDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Retrieves an Entity by its ID.
     *
     * @param id The ID of the Entity to retrieve.
     * @return The Entity with the specified ID, or null if not found.
     */
    public T getById(int id) {
        try {
            logger.info("Product ID: " + id);

            Session session = sessionFactory.openSession();
            T entity = session.get(entityClass, id);
            session.close();

            logger.info("Entity found.");

            return entity;

        } catch (Exception e) {
            logger.error(
                    "Error finding Product: " +
                            e.getMessage());
            throw e;
        }
    }

    /**
     * Updates or inserts an Entity.
     *
     * @param entity The Entity to be updated.
     */
    public void update(T entity) {
        try {
            logger.info("Updating: {}", entity);

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            session.close();

            logger.info("Entity Updated.");
        } catch (Exception e) {
            logger.error("Error updating: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Inserts a new Entity.
     *
     * @param entity The Entity to be inserted.
     * @return The ID of the newly inserted Entity.
     */
    public int insert(T entity) {
        try {
            logger.info("Entity to insert: {}", entity);

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            id = (int) session.getIdentifier(entity);
            session.close();

            logger.info("Entity Inserted.");

            return id;
        } catch (Exception e) {
            logger.error("Error Inserting: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes a Product.
     *
     * @param entity The Entity to be deleted.
     */
    public void delete(T entity) {
        try {
            logger.info("Entity to delete: {}", entity);

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            session.close();

            logger.info("Entity Deleted.");
        } catch (Exception e) {
            logger.error("Error deleting: {}", e.getMessage());
            throw e;
        }
    }

    public List<T> getAll() {
        try {
            Session session = sessionFactory.openSession();

            CriteriaQuery<T> query = session
                    .getCriteriaBuilder()
                    .createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            List<T> entities = session.createQuery(query)
                    .getResultList();

            session.close();

            logger.info("All displayed successfully.");

            return entities;
        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
            throw e;
        }
    }
}
