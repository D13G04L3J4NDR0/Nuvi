/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Familias;
import entity.Problematicas;
import entity.Tipodocumentos;
import facade.FamiliasFacade;
import facade.ProblematicasFacade;
import facade.TipodocumentosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Diego Alejandro
 */
@Named(value = "familiaControlador")
@SessionScoped
public class FamiliaControlador implements Serializable {

    @EJB
    TipodocumentosFacade tipoDocumentosFacade;
    private Tipodocumentos tipoDocumentos = new Tipodocumentos();
    
    @EJB
    FamiliasFacade familiaFacade;
    private Familias familia = new Familias();
    
    @EJB
    ProblematicasFacade problematicasFacade;
    private Problematicas problematicas = new Problematicas();
    
    UploadControler cargadeArchivo = new UploadControler();
    private Part file;
    
    public FamiliaControlador() {
    }

    public Tipodocumentos getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(Tipodocumentos tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public Familias getFamilia() {
        return familia;
    }

    public void setFamilia(Familias familia) {
        this.familia = familia;
    }

    public Problematicas getProblematicas() {
        return problematicas;
    }

    public void setProblematicas(Problematicas problematicas) {
        this.problematicas = problematicas;
    }
    
    public List<Familias> listarFamilias(){
        return familiaFacade.findAll(); 
    }
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public String registrarFamilia(){
        cargadeArchivo.upload(file);
        familia.setFkTipoDocum(tipoDocumentos);
        familia.setFkProblematica(problematicas);
        familiaFacade.create(familia);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Confirmación de registro","Registro Correcto");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        familia = new Familias();
        return "RegistroFamilia";
    }
    
    
    public String consultarFamilia(Familias fami) {
        familia = fami;
        return "InfoFamilia?faces-redirect=true";
    }
    public String actualizarFamilia(Familias fami) {
        familia = fami;
        return "ActualizarFamilia?faces-redirect=true";
    }

    public String editarFamilia() {
        familiaFacade.edit(familia);
        return "ListaFamilia?faces-redirect=true";
    }

   
    public String eliminarFamilia(Familias fami){
        familia = fami;
        familiaFacade.remove(fami);
        return "ListaFamilia";
    }
    
    public String mostrarListaFamilia(){
        return "ListaFamilia";
    }
    
    public String mostrarRegistroFamilia(){
        return "RegistroFamilia";
    }
    
    public String consultarFamilia(){
        return "ConsultaFamilia";
    }

    
}
