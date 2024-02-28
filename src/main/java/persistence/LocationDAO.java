package persistence;

import entity.Location;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Location entities.
 * @author cleonrivas
 */
public class LocationDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a Location by its ID.
     *
     * @param id The ID of the Location to retrieve.
     * @return The Location with the specified ID, or null if not found.
     */
    public Location getById(int id) {
        Session session = sessionFactory.openSession();
        Location Location = session.get( Location.class, id );
        session.close();
        return Location;
    }

    /**
     * Updates or inserts a Location.
     *
     * @param location The Location to be updated or inserted.
     */
    public void update(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(location);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Location.
     *
     * @param location The Location to be inserted.
     * @return The ID of the newly inserted Location.
     */
    public int insert(Location location) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(location);
        transaction.commit();
        id = location.getLocationId();
        session.close();
        return id;
    }

    /**
     * Deletes a Location.
     *
     * @param location The Location to be deleted.
     */
    public void delete(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(location);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Locations.
     *
     * @return A list of all Locations.
     */
    public List<Location> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> query = builder.createQuery(Location.class);
        Root<Location> root = query.from(Location.class);
        List<Location> locations = session.createSelectionQuery( query ).getResultList();

        session.close();

        return locations;
    }
}