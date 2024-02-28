package persistence;

import entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Data Access Object class for handling Section entities.
 * @author cleonrivas
 */
public class SectionDAO {

    private final SessionFactory sessionFactory;

    /**
     * Constructs a SectionDAO with the provided SessionFactory.
     *
     * @param sessionFactory The Hibernate SessionFactory.
     */
    public SectionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieves a Section by its ID.
     *
     * @param id The ID of the Section to retrieve.
     * @return The Section with the specified ID, or null if not found.
     */
    public Section getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Section.class, id);
        }
    }

    /**
     * Updates or inserts a Section.
     *
     * @param section The Section to be updated or inserted.
     */
    public void update(Section section) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(section);
            transaction.commit();
        }
    }

    /**
     * Inserts a new Section.
     *
     * @param section The Section to be inserted.
     * @return The ID of the newly inserted Section.
     */
    public int insert(Section section) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(section);
            transaction.commit();
            return id;
        }
    }

    /**
     * Deletes a Section.
     *
     * @param section The Section to be deleted.
     */
    public void delete(Section section) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(section);
            transaction.commit();
        }
    }

    /**
     * Retrieves a list of all Sections.
     *
     * @return A list of all Sections.
     */
    public List<Section> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Section> query = session.createQuery("FROM Section", Section.class);
            return query.getResultList();
        }
    }
}
