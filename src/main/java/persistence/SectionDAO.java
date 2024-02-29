package persistence;

import entity.Section;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Data Access Object class for handling Section entities.
 * @author cleonrivas
 */
public class SectionDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(CategoryDAO.class);

    /**
     * Retrieves a Section by its ID.
     *
     * @param id The ID of the Section to retrieve.
     * @return The Section with the specified ID, or null if not found.
     */
    public Section getById(int id) {
        try {
            logger.info("Section ID: " + id);

            Session session = sessionFactory.openSession();
            Section Section = session.get( Section.class, id );
            session.close();

            logger.info("Section found.");

            return Section;

        } catch (Exception e) {
            logger.error(
                    "Error finding Section: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Updates or inserts a Section.
     *
     * @param section The Section to be updated or inserted.
     */
    public void update(Section section) {
        try {
            logger.info(
                    "Updating Section: {}",
                    section
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(section);
            transaction.commit();
            session.close();

            logger.info("Section Updated.");
        } catch (Exception e) {
            logger.error(
                    "Error updating Section: {}",
                    e.getMessage(),
                    e
            );
            throw e;
        }
    }

    /**
     * Inserts a new Section.
     *
     * @param section The Section to be inserted.
     * @return The ID of the newly inserted Section.
     */
    public int insert(Section section) {
        try {
            logger.info(
                    "Section to insert: {}",
                    section
            );

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(section);
            transaction.commit();
            id = section.getSectionId();
            session.close();

            logger.info("Section Inserted.");

            return id;
        } catch (Exception e) {
            logger.error(
                    "Error Inserting Section: " +
                            e.getMessage()
            );
            throw e;
        }
    }

    /**
     * Deletes a Section.
     *
     * @param section The Section to be deleted.
     */
    public void delete(Section section) {
        try {
            logger.info(
                    "Section to delete: {}",
                    section
            );

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(section);
            transaction.commit();
            session.close();

            logger.info("Section Inserted.");
        } catch (Exception e) {
            logger.error(
                    "Error deleting Section: {}",
                    e.getMessage(), e
            );
            throw e;
        }
    }

    /**
     * Retrieves a list of all Sections.
     *
     * @return A list of all Sections.
     */
    public List<Section> getAll() {
        try {
            Session session = sessionFactory.openSession();

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Section> query = builder.createQuery(Section.class);
            Root<Section> root = query.from(Section.class);
            List<Section> sections = session.createSelectionQuery(
                    query
            ).getResultList();

            session.close();

            logger.info("All section displayed successfully.");

            return sections;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
