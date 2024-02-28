package persistence;

import entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Location entities.
 * @author cleonrivas
 */
public class LocationDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a LocationDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public LocationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Location by its ID.
     *
     * @param id The ID of the Location to retrieve.
     * @return The Location with the specified ID, or null if not found.
     */
    public Location getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Location.class, id);
        }
    }

    /**
     * Updates or inserts a Location.
     *
     * @param location The Location to be updated or inserted.
     */
    public void update(Location location) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(location);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Location.
     *
     * @param location The Location to be inserted.
     * @return The ID of the newly inserted Location.
     */
    public int insert(Location location) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(location);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Location.
     *
     * @param location The Location to be deleted.
     */
    public void delete(Location location) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(location);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Locations.
     *
     * @return A list of all Locations.
     */
    public List<Location> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Location> query = session.createQuery("FROM Location", Location.class);
            return query.getResultList();
        }
    }
}