package cf.mindaugas.model;

import cf.mindaugas.model.Associations.OneToOne.AddressOneToOne;
import cf.mindaugas.model.Associations.OneToOne.UserOneToOne;
import cf.mindaugas.model.CollectionTypes.UserWPhone;
import cf.mindaugas.model.BasicTypes.Contact;
import cf.mindaugas.model.BasicTypes.Name;
import cf.mindaugas.model.EntityListenersModel.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Driver {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("cf.mindaugas.movie_catalog");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // 1 ex: simple entity creation
        // simpleEntityExample();

        // 2 ex: Basic Hibernate types:
        // basicTypesExample();

        // 3 ex: persisting (saving) Java collections
        // persistingCollections();

        // 4. ex: read and update entity
        // simpleEntityReadAndUpdate();

        // 5. ex: delete an entity
        // simpleEntityDelete();

        // 7. CALLBACKS AND ENTITYLISTENERS
        // entityListenersExample();

        // 8. - Associations
        oneToOneExamplePersist();

        // Contact c1 = new Contact(new Name("Name1", "Middle1", "Last1"), new URL("http://a.b.c"), true);
        // Contact c2 = new Contact(new Name("Name2", "Middle3", "Last3"), new URL("http://a.b.cf"), true);
        //
        // if (c1.equals(c2))
        //     System.out.println("Equals");
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
        User user = new User("Daniel", "Joseph");
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
    public static void persistingCollections(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<String> phones = new ArrayList<>();
        phones.add("+370 889 008033");
        phones.add("+370 456 977777");

        // CREATE
        UserWPhone userWPhone = new UserWPhone("Alexander", "Bell");
        userWPhone.setPhones(phones);
        session.persist(userWPhone);

        transaction.commit();
        session.close();
    }
    public static void simpleEntityReadAndUpdate(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // UPDATE
        User user = session.find(User.class, 1L); // NullPointerException if object is not found
        user.setName("Robert H.");
        transaction.commit();
        session.close();
    }
    public static void simpleEntityDelete() throws InterruptedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);
        transaction.commit();

        System.out.println("Entity should be in the database, please check ... I will sleep for 10s");
        Thread.sleep(10000);

        // DELETE
        Transaction transaction2 = session.beginTransaction();
        session.delete(session.find(User.class, 1L));
        transaction2.commit();

        session.close();
        sessionFactory.close();
    }
    public static void entityListenersExample(){
        Driver d = new Driver();
        long id = d.saveMovieReturnId();
        Movie movie = d.getMovie(id);
        System.out.println(movie.getAge());
    }

    public Movie getMovie(Long movieId) {
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, new Long(movieId));
        return movie;
    }

    public long saveMovieReturnId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Movie movie = new Movie();
        movie.setId(3L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");
        em.persist(movie);
        em.getTransaction().commit();
        return movie.getId();
    }
    public static long oneToOneExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AddressOneToOne addressOneToOne = new AddressOneToOne("Lithuania", "Kaunas", "Taikos pr.");
        UserOneToOne userOneToOne = new UserOneToOne("Mindaugas", "mindaugas@gmail.com", addressOneToOne);

        // session.persist(addressOneToOne); // if you are not using:
        session.persist(userOneToOne);

        transaction.commit();
        session.close();

        return userOneToOne.getId();
    }
}