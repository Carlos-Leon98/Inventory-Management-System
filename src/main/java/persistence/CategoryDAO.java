package persistence;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

/**
 * Data Access Object class for handling Category entities.
 * @author cleonrivas
 */
public class CategoryDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a CategoryDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public CategoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Category by its ID.
     *
     * @param id The ID of the Category to retrieve.
     * @return The Category with the specified ID, or null if not found.
     */
    public Category getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, id);
        }
    }

    /**
     * Updates or inserts a Category.
     *
     * @param category The Category to be updated or inserted.
     */
    public void update(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Category.
     *
     * @param category The Category to be inserted.
     * @return The ID of the newly inserted Category.
     */
    public int insert(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(category);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Category.
     *
     * @param category The Category to be deleted.
     */
    public void delete(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Categories.
     *
     * @return A list of all Categories.
     */
    public List<Category> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            return query.getResultList();
        }
    }
}
