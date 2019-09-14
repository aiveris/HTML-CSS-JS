package cf.mindaugas.model;

import cf.mindaugas.model.CollectionTypes.UserWPhone;
import cf.mindaugas.model.BasicTypes.Contact;
import cf.mindaugas.model.BasicTypes.Name;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // 1 ex: simple entity creation
        // simpleEntityExample();

        // 2 ex: Basic Hibernate types:
        // basicTypesExample();

        // 3 ex: persisting (saving) Java collections
        persistingCollections();

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

        System.out.println("----- Transaction has begun ----------");

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);

        // How can we check whether the entity is persisted
        // during the persist() call or during the commit()?

        // System.out.println("----- Check now 1 -----");
        // Thread.sleep(10000);

        transaction.commit();

        // System.out.println("----- Check now 2 -----");
        // Thread.sleep(10000);

        session.close();
        sessionFactory.close();
    }
    public static void persistingCollections(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<String> phones = new ArrayList<>();
        phones.add("+77 889 008033");
        phones.add("+370 84 08977777");

        // CREATE
        UserWPhone userWPhone = new UserWPhone("Alexardr", "Bell");
        userWPhone.setPhones(phones);
        session.persist(userWPhone);

        transaction.commit();
        session.close();
    }
}