package persistence;

import entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling User entities.
 * @author cleonrivas
 */
public class UserDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a User by its ID.
     *
     * @param id The ID of the User to retrieve.
     * @return The User with the specified ID, or null if not found.
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User User = session.get( User.class, id );
        session.close();
        return User;
    }

    /**
     * Updates or inserts a User.
     *
     * @param user The User to be updated or inserted.
     */
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new User.
     *
     * @param user The User to be inserted.
     * @return The ID of the newly inserted User.
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        id = user.getUserId();
        session.close();
        return id;
    }

    /**
     * Deletes a User.
     *
     * @param user The User to be deleted.
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Users.
     *
     * @return A list of all Users.
     */
    public List<User> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createSelectionQuery( query ).getResultList();

        session.close();

        return users;
    }
}