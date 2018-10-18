/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.aldamah.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mg.aldamah.DAO.VisiterDAO;

/**
 *
 * @author Utilisateur
 */
@ManagedBean(name="reportController")
@SessionScoped
public class reportController {
    private VisiterDAO visiterDAO = new VisiterDAO();
    public List<Object>groupBySite(){
        return this.visiterDAO.groupBySite();
    }
}
