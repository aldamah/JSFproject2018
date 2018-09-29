/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Utilisateur
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory; 
    static {
        try { // Crée la SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Pb de conf : " +
            ex.getMessage(), ex); 
        }
    }
    
    public static final ThreadLocal session = new ThreadLocal();
    //obtention de la session courante

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Ouvre une nouvelle Session, si ce Thread n'en a aucune
        if (s == null) { s = sessionFactory.openSession(); session.set(s); }
        return s; 
    }

    //fermeture de session
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get(); session.set(null);
        if (s != null)
            s.close(); 
    }
}
