package persistence;

import entity.Product;
import entity.Role;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Role entities.
 * @author cleonrivas
 */
public class RoleDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a Role by its ID.
     *
     * @param id The ID of the Role to retrieve.
     * @return The Role with the specified ID, or null if not found.
     */
    public Role getById(int id) {
        Session session = sessionFactory.openSession();
        Role Role = session.get( Role.class, id );
        session.close();
        return Role;
    }

    /**
     * Updates or inserts a Role.
     *
     * @param role The Role to be updated or inserted.
     */
    public void update(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(role);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Role.
     *
     * @param role The Role to be inserted.
     * @return The ID of the newly inserted Role.
     */
    public int insert(Role role) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(role);
        transaction.commit();
        id = role.getRoleId();
        session.close();
        return id;
    }

    /**
     * Deletes a Role.
     *
     * @param role The Role to be deleted.
     */
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Roles.
     *
     * @return A list of all Roles.
     */
    public List<Role> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        List<Role> roles = session.createSelectionQuery( query ).getResultList();

        session.close();

        return roles;
    }
}
