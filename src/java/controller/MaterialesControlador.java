/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Materiales;
import facade.MaterialesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Diego Leguizamon
 */
@Named(value = "materialesControlador")
@SessionScoped
public class MaterialesControlador implements Serializable {

    @EJB
    MaterialesFacade materialesFacade;
    private Materiales materiales = new Materiales();
    
    public MaterialesControlador() {
    }
    
    
    
    public List<Materiales> listarMateriales(){
        return materialesFacade.findAll();
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }
    
}
