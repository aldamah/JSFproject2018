/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.DAO;

import java.util.List;
import mg.aldamah.beans.Site;
import mg.aldamah.utils.HibernateUtil;
import mg.aldamah.utils.myHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Utilisateur
 */
public class SiteDAO extends DAO<Site>{
    @Override
    public Site find(int id) {
        Site site = new Site();
        Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q=session.createQuery("from Site where site_id= :id");
            q.setInteger("id",id);
            List liste= q.list();
            site= (Site) liste.get(0);
            session.flush();
            tx.commit();
        } catch (HibernateException e) { 
            throw e; 
        } finally {
          // session.close(); 
        }
        return site;
    }

    @Override
    public Site create(Site obj) {
      Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
      try{
          tx = session.beginTransaction();
          session.save(obj);
          session.flush();
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }finally{
         // session.close();
      }
      return null;
    }

    @Override
    public Site update(Site obj) {
       Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       try{
          tx = session.beginTransaction();
          session.update(obj);
          session.flush();
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }finally{
          //session.close();
      }
      return null;
    }

    @Override
    public Site delete(Site obj) {
        Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       try{
          tx = session.beginTransaction();
          session.delete(obj);
          session.flush();
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }finally{
          //session.close();
      }
       return null;
    }

    @Override
    public List<Site> findAll() {
       Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       List<Site> liste;
    
      try{
          tx = session.beginTransaction();
          liste = session.createCriteria(mg.aldamah.beans.Site.class).list(); 
        
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }
        return liste;
    }
}
