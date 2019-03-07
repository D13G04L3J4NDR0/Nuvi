
package controller;

import entity.Usuarios;
import facade.UsuariosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.primefaces.component.media.Media.PropertyKeys.view;


@Named(value = "sesionControlador")
@SessionScoped
public class SesionControlador implements Serializable {

    @EJB
    private UsuariosFacade usuariosFacade;
    private Usuarios usuarios;
    private int documento;
    private String clave;
    
    public SesionControlador() {
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    /*Inicio de Sesión*/
    public String iniciarSesion() {
        try {
            usuarios = usuariosFacade.iniciarSesion(documento, clave);
            System.out.println(usuarios.getNombreUsuario());
            if (usuarios != null) {
                //renderizarPermisos(usuarios.getFkRoles().getPermisosList());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarios", usuarios);
                System.out.println(usuarios);
                return "/Proyectos/RegistroProyecto.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario o contraseña errado, vuelva a intertarlo."));
                return "";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario o contraseña errado, vuelva a intertarlo."));
            return "";
        }
    }
    
    /*Validación de sesión*/

    public Usuarios traerSesion() {
        return (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarios");
    }
    
    /*Cierre de sesión*/

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarios = null;
        this.clave = "";
        return "";
    }
    
    public void verificarSesion() {
        try {
            Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarios");
            System.out.println("Verificarsesion");
            
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Error404.xhtml");
            }
        } catch (Exception e) {
            // log para guardar registro de un error
            
        }
    }

}
