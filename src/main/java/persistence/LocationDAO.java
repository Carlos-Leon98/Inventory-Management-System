package persistence;

import entity.Location;
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
 * Data Access Object class for handling Location entities.
 * @author cleonrivas
 */
public class LocationDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a Location by its ID.
     *
     * @param id The ID of the Location to retrieve.
     * @return The Location with the specified ID, or null if not found.
     */
    public Location getById(int id) {
        try {
            logger.info("Location ID: " + id);

            Session session = sessionFactory.openSession();
            Location Location = session.get(Location.class, id);
            session.close();

            logger.info("Location found.");

            return Location;

        } catch (Exception e) {
            logger.error(
                    "Error finding Location: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a Location.
     *
     * @param location The Location to be updated or inserted.
     */
    public void update(Location location) {
        try {
            logger.info(
                    "Updating Location: {}",
                    location
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(location);
            transaction.commit();
            session.close();

            logger.info("Location Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Location: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Location.
     *
     * @param location The Location to be inserted.
     * @return The ID of the newly inserted Location.
     */
    public int insert(Location location) {
        try {
            logger.info(
                    "Category to insert: {}",
                    location
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(location);
            transaction.commit();
            id = location.getLocationId();
            session.close();

            logger.info("Category Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Category: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a Location.
     *
     * @param location The Location to be deleted.
     */
    public void delete(Location location) {
        try {
            logger.info(
                    "Location to delete: {}",
                    location
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(location);
            transaction.commit();
            session.close();

            logger.info("Location Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Location: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Locations.
     *
     * @return A list of all Locations.
     */
    public List<Location> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Location> query = builder.createQuery(Location.class);
            Root<Location> root = query.from(Location.class);
            List<Location> locations = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All locations displayed successfully.");

            return locations;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}