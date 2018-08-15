package db;

import models.Instructor;
import models.Lesson;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBInstructor {

    private static Session session;
    private static Transaction transaction;

    public static List<Lesson> getListOfLessonsOfInstructor(Instructor instructor){
        List<Lesson> result = null;
        session =HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr =session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("instructor", instructor));
            result = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
