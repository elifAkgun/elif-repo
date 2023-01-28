package code.elif.app.features.migration.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CustomerEntityTest {

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        persist(sessionFactory);
        fetch(sessionFactory);

        sessionFactory.close();
    }

    private static void fetch(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<CustomerEntity> customer = session.createQuery("FROM CustomerEntity", CustomerEntity.class).list();
        System.out.println("id: " + customer.get(0).getId()
                + "name : " + customer.get(0).getFirstName()
                + "last name : " + customer.get(0).getLastName());

        session.close();
    }

    public static void persist(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(new CustomerEntity("1", "Cat", "Mirka"));
        session.getTransaction().commit();
        session.close();
    }
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}
