
package controller;

import entity.MaterialesProyecto;
import facade.MaterialesProyectoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;


@Named(value = "materialesRequeridosControlador")
@SessionScoped
public class MaterialesRequeridosControlador implements Serializable {

    @EJB
    MaterialesProyectoFacade materialesProyectoFacade;
    private MaterialesProyecto materialesProyecto = new MaterialesProyecto();
    
    public MaterialesRequeridosControlador() {
    }

    public MaterialesProyecto getMaterialesProyecto() {
        return materialesProyecto;
    }

    public void setMaterialesProyecto(MaterialesProyecto materialesProyecto) {
        this.materialesProyecto = materialesProyecto;
    }
    
    public String eliminarMaterialRequerido(MaterialesProyecto objMat){
        materialesProyecto = objMat;
        materialesProyectoFacade.remove(materialesProyecto);
        return "";
    }
    
    
    
}
