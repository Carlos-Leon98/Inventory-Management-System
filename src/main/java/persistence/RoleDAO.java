package persistence;

import entity.Role;
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
 * Data Access Object class for handling Role entities.
 * @author cleonrivas
 */
public class RoleDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a Role by its ID.
     *
     * @param id The ID of the Role to retrieve.
     * @return The Role with the specified ID, or null if not found.
     */
    public Role getById(int id) {
        try {
            logger.info("Role ID: " + id);

            Session session = sessionFactory.openSession();
            Role Role = session.get(Role.class, id);
            session.close();

            logger.info("Role found.");

            return Role;

        } catch (Exception e) {
            logger.error(
                    "Error finding Role: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a Role.
     *
     * @param role The Role to be updated or inserted.
     */
    public void update(Role role) {
        try {
            logger.info(
                    "Updating Role: {}",
                    role
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(role);
            transaction.commit();
            session.close();

            logger.info("Role Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Role: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Role.
     *
     * @param role The Role to be inserted.
     * @return The ID of the newly inserted Role.
     */
    public int insert(Role role) {
        try {
            logger.info(
                    "Role to insert: {}",
                    role
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
            id = role.getRoleId();
            session.close();

            logger.info("Role Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Role: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a Role.
     *
     * @param role The Role to be deleted.
     */
    public void delete(Role role) {
        try {
            logger.info(
                    "Role to delete: {}",
                    role
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
            session.close();

            logger.info("Role Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Role: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Roles.
     *
     * @return A list of all Roles.
     */
    public List<Role> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Role> query = builder.createQuery(Role.class);
            Root<Role> root = query.from(Role.class);
            List<Role> roles = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All roles displayed successfully.");

            return roles;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
