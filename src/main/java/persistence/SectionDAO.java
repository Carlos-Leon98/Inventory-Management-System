package persistence;

import entity.Product;
import entity.Section;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * Data Access Object class for handling Section entities.
 * @author cleonrivas
 */
public class SectionDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Retrieves a Section by its ID.
     *
     * @param id The ID of the Section to retrieve.
     * @return The Section with the specified ID, or null if not found.
     */
    public Section getById(int id) {
        Session session = sessionFactory.openSession();
        Section Section = session.get( Section.class, id );
        session.close();
        return Section;
    }

    /**
     * Updates or inserts a Section.
     *
     * @param section The Section to be updated or inserted.
     */
    public void update(Section section) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(section);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a new Section.
     *
     * @param section The Section to be inserted.
     * @return The ID of the newly inserted Section.
     */
    public int insert(Section section) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(section);
        transaction.commit();
        id = section.getSectionId();
        session.close();
        return id;
    }

    /**
     * Deletes a Section.
     *
     * @param section The Section to be deleted.
     */
    public void delete(Section section) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(section);
        transaction.commit();
        session.close();
    }

    /**
     * Retrieves a list of all Sections.
     *
     * @return A list of all Sections.
     */
    public List<Section> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Section> query = builder.createQuery(Section.class);
        Root<Section> root = query.from(Section.class);
        List<Section> sections = session.createSelectionQuery( query ).getResultList();

        session.close();

        return sections;
    }
}
