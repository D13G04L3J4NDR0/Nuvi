
package controller;

import facade.UsuariosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;


@Named(value = "importacionDeDatosIniciales")
@SessionScoped
public class ImportacionDeDatosIniciales implements Serializable {

    private Part file;
    private String tabla;
    
    @EJB
    UsuariosFacade usuariosFacade;
    
    
    public ImportacionDeDatosIniciales() {
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public void importaciondeDatos(){
        String nombre;
        nombre = file.getSubmittedFileName();
        System.out.println(nombre);
        usuariosFacade.cargarArchivos(nombre, tabla);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargue correcto", "Registros cargados correctamente");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }   

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
