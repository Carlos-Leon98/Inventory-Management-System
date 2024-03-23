package persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * This file provides a SessionFactory for use with DAOs using Hibernate
 *
 * @author paulawaite
 * @version 3.0
 */
public class SessionFactoryProvider {

    private static final Logger logger = LogManager.getLogger(SessionFactoryProvider.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private SessionFactoryProvider() {
        throw new AssertionError("Utility class - do not instantiate");
    }

    /**
     * Build the SessionFactory.
     *
     * @return the SessionFactory
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create registry
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            logger.error("Error creating SessionFactory: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}