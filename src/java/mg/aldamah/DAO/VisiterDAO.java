/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.DAO;

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
            Query q=session.createQuery("from visiter where id= :id");
            q.setInteger("id",id);
            List liste= q.list();
            visiter= (Visiter) liste.get(0);
            
        } catch (HibernateException e) { 
            throw e; 
        } finally {
            session.close(); 
        }
        return visiter;
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
          session.close();
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
          session.close();
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
          session.close();
      }
       return null;
    }

    @Override
    public List<Visiter> findAll() {
       Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       List<Visiter> liste;
    
      try{
          tx = session.beginTransaction();
          liste = session.createCriteria(mg.aldamah.beans.Visiter.class).list(); 
        
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }
        return liste;
    }
    
}
