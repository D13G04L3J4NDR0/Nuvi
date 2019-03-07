package controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean(name = "cargarArchivo")
public class UploadControler {

    
    private String nombre;
    private String pathReal;

    public String getPath() {
        return pathReal;
    }

    public void setPath(String path) {
        this.pathReal = path;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String upload(Part file) {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/Proyecto NUVi/Archivos/" + nombre;
            path = path + this.nombre; //
            InputStream in = file.getInputStream();        
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            in.close();
            out.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Cargado";
    }
}