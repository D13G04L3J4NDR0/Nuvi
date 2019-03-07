/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Personal;
import entity.Proyectos;
import entity.Tipodocumentos;
import facade.PersonalFacade;
import facade.ProyectosFacade;
import facade.TipodocumentosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Diego Alejandro
 */
@Named(value = "personalControlador")
@SessionScoped
public class PersonalControlador implements Serializable {

    private String email = null;
    @EJB
    ProyectosFacade proyectosFacade;
    private Proyectos proyectos = new Proyectos();

    @EJB
    PersonalFacade personalFacade;
    private Personal personal = new Personal();

    @EJB
    TipodocumentosFacade tipodocumentoFacade;
    private Tipodocumentos tipodocumentos = new Tipodocumentos();

    public PersonalControlador() {
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Tipodocumentos getTipodocumentos() {
        return tipodocumentos;
    }

    public void setTipodocumentos(Tipodocumentos tipodocumentos) {
        this.tipodocumentos = tipodocumentos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Registro de personal por NUVi
    public String registrarPersonal() {
        personal.setDisponibilidad("No disponible");
        personal.setFkProyecto(proyectosFacade.find(proyectos.getIdProyecto()));
        personal.setFkTipoDocum(tipodocumentoFacade.find(tipodocumentos.getIdTipoDocum()));
        personalFacade.create(personal);
        personal = new Personal();
        // Alertas
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmación de registro", "Información registrada.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return "";

    }

    //Registro de voluntarios por landingPage
    public String registrarVoluntario() {
        if (personal.getEmailPersonal().equals(email)) {
            personal.setDisponibilidad("Disponible");
            personal.setCategoriaPersonal("Voluntario");
            personalFacade.create(personal);
            envioCorreoVoluntarios(email);

            personal = new Personal();
            setEmail("");

            // Alertas
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ahora haces parte de nuestro equipo de voluntarios", "Acabas de recibir un correo de confirmación.");
            PrimeFaces.current().dialog().showMessageDynamic(message);

            return "";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error en confirmación de correo. Intentar nuevamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            personal = new Personal();
            setEmail("");
            return "";
        }
    }

    // Crear Voluntarios más envio de correo
    public void envioCorreoVoluntarios(String email) {

        Email e = new Email("nuviproject@gmail.com", "proyectosena", email, "");
        e.enviarSimple("Confirmación registro Voluntario", "Uds se ha registrado como voluntario");

        Email e2 = new Email("nuviproject@gmail.com", "proyectosena", "asignacionnuvi@gmail.com", "admnuvi@gmail.com");
        e2.enviarSimple("Información registro voluntario", " " + personal.getNombrePersonal() + " " + personal.getApellidoPersonal() + " se ha registrado como voluntario.  Número de documento" + personal.getDocumPersonal() + "  e identificación en NUVI" + personal.getIdPersonal());
    }

    public List<Personal> listarPersonal() {
        return personalFacade.findAll();
    }

    public String actualizarPersonal(Personal objPersonal) {
        personal = objPersonal;
        if (personal.getFkProyecto() == null) {
            personal.setDisponibilidad("No disponible");
            return "AsignarPersonal";
        } else {
            // Alertas
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en asignación de voluntario", "Se encuentra en estado No disponible");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "";
        }
    }

    public String editarPersonal() {
        personal.setFkProyecto(proyectosFacade.find(proyectos.getIdProyecto()));
        personalFacade.edit(personal);
        return "ListaVoluntarios";
    }

    public String eliminarPersonal(Personal objPersonal) {
        personal = objPersonal;
        personalFacade.remove(personal);
        return "ListaPersonal";
    }

}
