package cf.mindaugas.model;

import cf.mindaugas.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Driver {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("----- Transaciton has begun ----------");

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);

        // How can we check whether the entity is persisted
        // durring the persist() call or durring the commit()?

        // System.out.println("----- Check now -----");
        // Thread.sleep(15000);

        transaction.commit();

        // System.out.println("----- Check now -----");
        // Thread.sleep(15000);

        session.close();
        sessionFactory.close();
    }
}