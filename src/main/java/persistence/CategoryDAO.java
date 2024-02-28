package persistence;

import entity.Category;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Category entities.
 * @author cleonrivas
 */
public class CategoryDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a Category by its ID.
     *
     * @param id The ID of the Category to retrieve.
     * @return The Category with the specified ID, or null if not found.
     */
    public Category getById(int id) {
        Session session = sessionFactory.openSession();
        Category Category = session.get( Category.class, id );
        session.close();
        return Category;
    }

    /**
     * Updates or inserts a Category.
     *
     * @param category The Category to be updated or inserted.
     */
    public void update(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(category);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Category.
     *
     * @param category The Category to be inserted.
     * @return The ID of the newly inserted Category.
     */
    public int insert(Category category) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        id = category.getCategoryId();
        session.close();
        return id;
    }

    /**
     * Deletes a Category.
     *
     * @param category The Category to be deleted.
     */
    public void delete(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(category);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Categories.
     *
     * @return A list of all Categories.
     */
    public List<Category> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        List<Category> categories = session.createSelectionQuery( query ).getResultList();

        session.close();

        return categories;
    }
}
