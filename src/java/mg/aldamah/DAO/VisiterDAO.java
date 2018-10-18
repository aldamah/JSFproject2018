/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mg.aldamah.beans.Site;
import mg.aldamah.beans.Visiter;
import mg.aldamah.utils.HibernateUtil;
import mg.aldamah.utils.myHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Utilisateur
 */
public class VisiterDAO extends DAO<Visiter>{
    
    @Override
    public Visiter find(int id) {
        Visiter visiter= new Visiter();
        Session session =myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q=session.createQuery("from Visiter where visiterId= :id");
            q.setInteger("id",id);
            List liste= q.list();
            visiter= (Visiter) liste.get(0);
            session.flush();
            tx.commit();
        } catch (HibernateException e) { 
            throw e; 
        } finally {
            HibernateUtil.closeSession();
        }
        return visiter;
    }
    
    public List<Visiter> findByVisiteur(int id) {
        List<Visiter> visites= new ArrayList();
        Session session =myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q=session.createQuery("from Visiter where visiteur.visiteurId = :id");
            q.setInteger("id",id);
            visites= q.list();
            session.flush();
            tx.commit();
        } catch (HibernateException e) { 
            throw e; 
        } finally {
            HibernateUtil.closeSession(); 
        }
        return visites;
    }
    
    public List<Object> groupBySite() {
        List<Object> siteRecette = new ArrayList();
        
        Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q=session.createSQLQuery("SELECT site_nom, count(visiter_id) as effectif,sum(visiter_nbjours*site_tarifjournaliere) as Montant from visiter,site where(visiter_site_id = site_id) GROUP BY site_nom");
            List liste = q.list();
            int i = 0;
            while(i<liste.size()){
                Object temp = liste.get(i);
                System.out.println(temp);
                siteRecette.add(temp);
                i++;
            }
            session.flush();
            tx.commit();
            
        } catch (HibernateException e) { 
            throw e; 
        } finally {
           HibernateUtil.closeSession();
        }
        return siteRecette;
    }
    
    public List<Visiter> findBySite(int id) {
        List<Visiter> visites;
        Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q=session.createQuery("from Visiter where site.siteId = :id");
            q.setInteger("id",id);
            visites= q.list();
            session.flush();
            tx.commit();
            
        } catch (HibernateException e) { 
            throw e; 
        } finally {
           HibernateUtil.closeSession();
        }
        return visites;
    }

    @Override
    public Visiter create(Visiter obj) {
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
          HibernateUtil.closeSession();
      }
      return null;
    }

    @Override
    public Visiter update(Visiter obj) {
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
    public Visiter delete(Visiter obj) {
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
          HibernateUtil.closeSession();
      }
       return null;
    }

    @Override
    public List<Visiter> findAll() {
       Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       List<Visiter> visites;
      
      try{
          tx = session.beginTransaction();
          Query q=session.createQuery("from Visiter");
           visites= q.list();
           session.flush();
           tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      } 
      finally {
            HibernateUtil.closeSession();
        }
      return visites;
    }

    public List<Visiter> findByDates(Site site, Date date1, Date date2) {
        Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       List<Visiter> visites;
      
      try{
          tx = session.beginTransaction();
          Query q=session.createQuery("from Visiter where site = :site and visiterDate between :date1 and :date2");
          q.setParameter("site", site);
          q.setParameter("date2", date2);
          q.setParameter("date1", date1);
          session.flush();
           tx.commit();
          
           visites= q.list();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      } 
      finally {
            HibernateUtil.closeSession();
        }
      return visites;
    }
    
}
