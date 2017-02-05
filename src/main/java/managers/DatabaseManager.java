package managers;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class DatabaseManager
{
    private static DatabaseManager instance;

    public static DatabaseManager getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private DatabaseManager()
    {

    }

    private SessionFactory sessionFactory;

    public void configure(String configFilePath, Class ...annotatedClasses)
    {
        Configuration configuration = new Configuration().configure(configFilePath);

        for (Class annotatedClass : annotatedClasses)
        {
            configuration.addAnnotatedClass(annotatedClass);
        }

        sessionFactory = configuration.buildSessionFactory();
    }

    public Long saveEntry(Object entry)
    {
        Long id = 0L;

        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                id = (Long) session.save(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return id;
    }

    public void updateEntry(Object entry)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.update(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteEntry(int id, Class entityClass)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.delete(session.load(entityClass, id));
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public <T> T getEntry(int id, Class<T> entityClass)
    {
        T entry = null;

        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                entry = session.get(entityClass, id);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return entry;
    }

    public <T> List<T> getEntries(Class<T> entityClass)
    {
        List<T> list = null;
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                list = session.createQuery("From " + entityClass.getName()).list();
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return list;
    }
}
