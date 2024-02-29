package persistence;

import entity.User;
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
 * Data Access Object class for handling User entities.
 * @author cleonrivas
 */
public class UserDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a User by its ID.
     *
     * @param id The ID of the User to retrieve.
     * @return The User with the specified ID, or null if not found.
     */
    public User getById(int id) {
        try {
            logger.info("User ID: " + id);

            Session session = sessionFactory.openSession();
            User User = session.get(User.class, id);
            session.close();

            logger.info("User found.");

            return User;

        } catch (Exception e) {
            logger.error(
                    "Error finding User: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a User.
     *
     * @param user The User to be updated or inserted.
     */
    public void update(User user) {
        try {
            logger.info(
                    "Updating User: {}",
                    user
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
            session.close();

            logger.info("User Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating User: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new User.
     *
     * @param user The User to be inserted.
     * @return The ID of the newly inserted User.
     */
    public int insert(User user) {
        try {
            logger.info(
                    "User to insert: {}",
                    user
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            id = user.getUserId();
            session.close();

            logger.info("User Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting User: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a User.
     *
     * @param user The User to be deleted.
     */
    public void delete(User user) {
        try {
            logger.info(
                    "User to delete: {}",
                    user
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();

            logger.info("User Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting User: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Users.
     *
     * @return A list of all Users.
     */
    public List<User> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            List<User> users = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All users displayed successfully.");

            return users;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}