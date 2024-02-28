package persistence;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling User entities.
 * @author cleonrivas
 */
public class UserDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a UserDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a User by its ID.
     *
     * @param id The ID of the User to retrieve.
     * @return The User with the specified ID, or null if not found.
     */
    public User getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    /**
     * Updates or inserts a User.
     *
     * @param user The User to be updated or inserted.
     */
    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        }
    }

    /**
     * Inserts a new User.
     *
     * @param user The User to be inserted.
     * @return The ID of the newly inserted User.
     */
    public int insert(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(user);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a User.
     *
     * @param user The User to be deleted.
     */
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Users.
     *
     * @return A list of all Users.
     */
    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.getResultList();
        }
    }
}