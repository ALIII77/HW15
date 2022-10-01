package Q1.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private HibernateUtils(){
        throw new UnsupportedOperationException("This is a utility class and cannot be instate.");
    }

    private static final SessionFactory SESSION_FACTORY=
            new Configuration().configure().buildSessionFactory();

    public static Session getHibernateSession() {
        return SESSION_FACTORY.openSession();
    }

}
