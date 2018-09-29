/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.DAO;

import java.util.List;
import mg.aldamah.beans.Visiteur;
import mg.aldamah.utils.myHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Utilisateur
 */
public class VisiteurDAO extends DAO<Visiteur> {
    @Override
    public Visiteur find(int id) {
        Visiteur visiteur= new Visiteur();
        Session session =myHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Query q=session.createQuery("from visiteur where id= :id");
            q.setInteger("id",id);
            List liste= q.list();
            visiteur= (Visiteur) liste.get(0);
            
        } catch (HibernateException e) { 
            throw e; 
        } finally {
            //session.close(); 
        }
        return visiteur;
    }

    @Override
    public Visiteur create(Visiteur obj) {
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
          //session.close();
      }
      return null;
    }

    @Override
    public Visiteur update(Visiteur obj) {
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
    public Visiteur delete(Visiteur obj) {
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
    public List<Visiteur> findAll() {
      Session session = myHibernateUtil.getSessionFactory().getCurrentSession();
       List<Visiteur> liste;
    
      try{
          tx = session.beginTransaction();
          liste = session.createCriteria(mg.aldamah.beans.Visiteur.class).list(); 
        
          tx.commit();
      }catch(HibernateException e){
          if(tx != null) 
              tx.rollback();
          throw e;
      }
        return liste;
    }

   

}
