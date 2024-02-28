package persistence;

import entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Role entities.
 * @author cleonrivas
 */
public class RoleDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a RoleDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public RoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Role by its ID.
     *
     * @param id The ID of the Role to retrieve.
     * @return The Role with the specified ID, or null if not found.
     */
    public Role getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Role.class, id);
        }
    }

    /**
     * Updates or inserts a Role.
     *
     * @param role The Role to be updated or inserted.
     */
    public void update(Role role) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(role);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Role.
     *
     * @param role The Role to be inserted.
     * @return The ID of the newly inserted Role.
     */
    public int insert(Role role) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(role);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Role.
     *
     * @param role The Role to be deleted.
     */
    public void delete(Role role) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Roles.
     *
     * @return A list of all Roles.
     */
    public List<Role> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery("FROM Role", Role.class);
            return query.getResultList();
        }
    }
}
