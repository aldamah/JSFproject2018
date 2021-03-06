package mg.aldamah.beans;
// Generated 29 sept. 2018 16:11:40 by Hibernate Tools 4.3.1


import java.sql.Date;

/**
 * Visiter generated by hbm2java
 */
public class Visiter  implements java.io.Serializable {


     private Integer visiterId;
     private Site site;
     private Visiteur visiteur;
     private int visiterNbjours;
     private Date visiterDate;
     private int montant;

    public Visiter() {
        this.visiteur = new Visiteur();
        this.site = new Site();
    }

    public Visiter(Site site, Visiteur visiteur, int visiterNbjours, Date visiterDate) {
       this.site = site;
       this.visiteur = visiteur;
       this.visiterNbjours = visiterNbjours;
       this.visiterDate = visiterDate;
       this.montant = (visiterNbjours) * (this.site.getSiteTarifjournaliere());
    }
   
    public Integer getVisiterId() {
        return this.visiterId;
    }

    public int getMontant() {
        return this.montant;
    }

    public void setMontant() {
        this.montant = getVisiterNbjours() * this.site.getSiteTarifjournaliere();
    }
    
    public void setVisiterId(Integer visiterId) {
        this.visiterId = visiterId;
    }
    public Site getSite() {
        return this.site;
    }
    
    public void setSite(Site site) {
        this.site = site;
    }
    public Visiteur getVisiteur() {
        return this.visiteur;
    }
    
    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }
    public int getVisiterNbjours() {
        return this.visiterNbjours;
    }
    
    public void setVisiterNbjours(int visiterNbjours) {
        this.visiterNbjours = visiterNbjours;
    }
    public Date getVisiterDate() {
        return this.visiterDate;
    }
    
    public void setVisiterDate(Date visiterDate) {
        
        this.visiterDate = visiterDate;
    }




}


