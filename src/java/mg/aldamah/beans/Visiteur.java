package mg.aldamah.beans;
// Generated 29 sept. 2018 16:11:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Visiteur generated by hbm2java
 */
public class Visiteur  implements java.io.Serializable {


     private Integer visiteurId;
     private String visiteurNom;
     private String visiteurAdresse;
     private Set visiters = new HashSet(0);

    public Visiteur() {
    }

	
    public Visiteur(String visiteurNom, String visiteurAdresse) {
        this.visiteurNom = visiteurNom;
        this.visiteurAdresse = visiteurAdresse;
    }
    public Visiteur(String visiteurNom, String visiteurAdresse, Set visiters) {
       this.visiteurNom = visiteurNom;
       this.visiteurAdresse = visiteurAdresse;
       this.visiters = visiters;
    }
   
    public Integer getVisiteurId() {
        return this.visiteurId;
    }
    
    public void setVisiteurId(Integer visiteurId) {
        this.visiteurId = visiteurId;
    }
    public String getVisiteurNom() {
        return this.visiteurNom;
    }
    
    public void setVisiteurNom(String visiteurNom) {
        this.visiteurNom = visiteurNom;
    }
    public String getVisiteurAdresse() {
        return this.visiteurAdresse;
    }
    
    public void setVisiteurAdresse(String visiteurAdresse) {
        this.visiteurAdresse = visiteurAdresse;
    }
    public Set getVisiters() {
        return this.visiters;
    }
    
    public void setVisiters(Set visiters) {
        this.visiters = visiters;
    }




}

