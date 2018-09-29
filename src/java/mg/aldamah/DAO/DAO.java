/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.DAO;

import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author kristiana
 */
public abstract class DAO<T> {
    public Transaction tx = null;
        
    public abstract T find(int id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract T delete(T obj);
    public abstract List<T> findAll();
}
