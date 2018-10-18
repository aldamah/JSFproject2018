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
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.*;
import mg.aldamah.DAO.VisiterDAO;
import mg.aldamah.DAO.VisiteurDAO;
import mg.aldamah.beans.Site;
import mg.aldamah.beans.Visiter;
import mg.aldamah.beans.Visiteur;
import org.primefaces.context.RequestContext;

@ManagedBean(name="visiterController")
@SessionScoped
public class VisiterController {
    private VisiterDAO visiterDAO = new VisiterDAO();
    private VisiteurDAO visiteurDAO = new VisiteurDAO();
    private Visiter visiter = new Visiter();
    private Visiteur visiteur = new Visiteur();
    private Site s = new Site();
    private List<Visiter> results;
    private Date date1;
    private Date date2;
    
    public Visiteur getVisiteur() {
        return visiteur;
    }

    /*public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }*/

    public Site getS() {
        return s;
    }

    public void setS(Site s) {
        this.s = s;
    }
    public String findByDates(){
        //this.results = this.visiterDAO.findByDates(this.s,this.date1,this.date2);
        return "listVisiter";
    } 
            
    public void setVisiteur(){
        System.out.println(this.visiter.getVisiteur().getVisiteurNom());
        System.out.println(this.visiter.getSite().getSiteNom());
        this.visiter.setVisiterDate(this.visiter.getVisiterDate());
        System.out.println(this.visiter.getVisiterDate());
    }
    
    public List<Visiter> findBySite() {
       return visiterDAO.findBySite(1);
    }

    public List<Visiter> findByVisiteur(int visiteur){
        return visiterDAO.findByVisiteur(visiteur);
    }
    
    public List<Visiter> findAll(){
        return visiterDAO.findAll();
    }
    public String add(){
        visiterDAO.create(this.visiter);
        System.out.print(this.visiter.getVisiterDate());
        return "listVisiter";
    }
    
    public void delete(Visiter visiter){
        this.visiterDAO.delete(visiter);
    }
    public void deleteBySite(int site){
        List<Visiter> visites = this.visiterDAO.findBySite(site);
        Iterator iter = visites.iterator();
        while(iter.hasNext())
        {
            this.visiterDAO.delete((Visiter)iter.next());
        }
    }
    
    
    public void deleteByVisiteur(int visiteur){
        List<Visiter> visites = this.visiterDAO.findByVisiteur(visiteur);
        Iterator iter = visites.iterator();
        while(iter.hasNext())
        {
            this.visiterDAO.delete((Visiter)iter.next());
        }
    }
    
    public void edit(Visiter visiter){
        this.visiter= visiter;
    }
    
    public void init(){
        this.visiter = new Visiter();
    }
    public void edit(){
        this.visiterDAO.update(this.visiter);
    }

    public Visiter getVisiter() {
        return visiter;
    }

    public void setVisiter(Visiter visite) {
        this.visiter = visite;
    }

    public List<Visiter> getResults() {
        return results;
    }

    public void setResults(List<Visiter> results) {
        this.results = results;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
    
    
}
