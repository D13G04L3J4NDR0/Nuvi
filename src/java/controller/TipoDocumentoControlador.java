/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Tipodocumentos;
import facade.TipodocumentosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Diego Alejandro
 */
@Named(value = "tipoDocumentoControlador")
@SessionScoped
public class TipoDocumentoControlador implements Serializable {

    @EJB
    TipodocumentosFacade tipodocumentosFacade;
    private Tipodocumentos tipodocumentos = new Tipodocumentos();
    
    public TipoDocumentoControlador() {
    }

    public Tipodocumentos getTipodocumentos() {
        return tipodocumentos;
    }

    public void setTipodocumentos(Tipodocumentos tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }
    
    public List<Tipodocumentos> listarTipoDocumentos(){
        return tipodocumentosFacade.findAll();
    }
}
