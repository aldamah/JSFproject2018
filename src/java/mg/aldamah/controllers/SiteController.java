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
import mg.aldamah.DAO.SiteDAO;
import mg.aldamah.beans.Site;

@ManagedBean(name="siteController")
@SessionScoped
public class SiteController {
    private SiteDAO siteDAO = new SiteDAO();
    private Site site = new Site();

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    public Site find(int i){
        return siteDAO.find(i);
    }
    public List<Site> findAll(){
        return siteDAO.findAll();
    }
    public String add(){
        this.siteDAO.create(this.site);
        this.site = new Site();
        return "listSite";
    }
    public void delete(Site s){
        this.siteDAO.delete(s);
    }
    public void edit(Site s){
        this.site = s;
        
    }
    public void edit(){
        this.siteDAO.update(this.site);
        
    }
    
}
