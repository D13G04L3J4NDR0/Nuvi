/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Problematicas;
import facade.ProblematicasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Diego Alejandro
 */
@Named(value = "problematicaControlador")
@SessionScoped
public class ProblematicaControlador implements Serializable {

    @EJB
    ProblematicasFacade problematicasFacade;
    private Problematicas problematicas = new Problematicas();
    
    public ProblematicaControlador() {
    }

    public Problematicas getProblematicas() {
        return problematicas;
    }

    public void setProblematicas(Problematicas problematicas) {
        this.problematicas = problematicas;
    }
    
    public List<Problematicas> listarProblematicas(){
        return problematicasFacade.findAll();
    }
    
}
