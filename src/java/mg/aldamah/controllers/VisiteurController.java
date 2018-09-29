/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.controllers;

/**
 *
 * @author Utilisateur
 */
import java.util.List;
import javax.faces.bean.*;
import mg.aldamah.DAO.VisiteurDAO;
import mg.aldamah.beans.Visiteur;

@ManagedBean(name="visiteurController")
@SessionScoped
public class VisiteurController {
    private VisiteurDAO visiteurDAO = new VisiteurDAO();
    private Visiteur visiteur = new Visiteur();

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }
    
    public Visiteur find(int i){
        return visiteurDAO.find(i);
    }
    public List<Visiteur> findAll(){
        return visiteurDAO.findAll();
    }
    public String add(){
        this.visiteurDAO.create(this.visiteur);
        this.visiteur = new Visiteur();
        return "listVisiteur";
    }
    public void delete(Visiteur s){
        this.visiteurDAO.delete(s);
    }
    public void edit(Visiteur s){
        this.visiteur = s;
       
    }
    public void edit(){
        this.visiteurDAO.update(this.visiteur);
       
    }
    
}
