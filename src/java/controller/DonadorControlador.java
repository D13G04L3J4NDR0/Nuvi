/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Donaciones;
import entity.Donador;
import entity.Tipodocumentos;
import facade.DonacionesFacade;
import facade.DonadorFacade;
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
@Named(value = "donadorControlador")
@SessionScoped
public class DonadorControlador implements Serializable {

    @EJB
    DonadorFacade donadorFacade;
    private Donador donador = new Donador();

    @EJB
    DonacionesFacade donacionesFacade;
    private Donaciones donaciones = new Donaciones();

    @EJB
    TipodocumentosFacade TipodocumentosFacade;
    private Tipodocumentos tipodocumentos = new Tipodocumentos();
    
    public DonadorControlador() {
    }

    public Donador getDonador() {
        return donador;
    }

    public void setDonador(Donador donador) {
        this.donador = donador;
    }

    public Donaciones getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Donaciones donaciones) {
        this.donaciones = donaciones;
    }

    public Tipodocumentos getTipodocumentos() {
        return tipodocumentos;
    }

    public void setTipodocumentos(Tipodocumentos tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }
    
    public List<Donador> listarDonadores() {
        return donadorFacade.findAll();
    }
    
    public String registrarDonador() {
        donadorFacade.create(donador);
        donador = new Donador();
        return "";
    }

    public String actualizarDonador(Donador objDonador) {
        donador = objDonador;
        return "Editar";
    }

    public String editarDonador() {
        donadorFacade.edit(donador);
        donador = new Donador();
        return "Lista";
    }

    public String eliminarDonador(Donador objDonador) {
        donadorFacade.remove(objDonador);
        return "Lista";
    }
    
    
}
