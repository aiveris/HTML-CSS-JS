package cf.mindaugas.model;

import cf.mindaugas.model.BasicTypes2.Contact;
import cf.mindaugas.model.BasicTypes2.Name;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // 1 ex: simple entity creation
        // simpleEntityExample();

        // 2 ex: Basic Hybernate types:
        basicTypesExample();

        // 3 ex:

    }

    public static void basicTypesExample() throws MalformedURLException {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        Contact contact = new Contact(2,
                new Name("Mindaugas", "", "Bernatavičius"),
                "Notes 1",
                new URL("http://www.abc.com"),
                true);

        session.persist(contact);
        transaction.commit();
        session.close();
    }

    public static void simpleEntityExample(){
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

        // System.out.println("----- Check now 1 -----");
        // Thread.sleep(10000);

        transaction.commit();

        // System.out.println("----- Check now 2 -----");
        // Thread.sleep(10000);

        session.close();
        sessionFactory.close();
    }
}