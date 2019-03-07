package controller;

import entity.Donaciones;
import entity.Donador;
import entity.Proyectos;
import entity.Tipodocumentos;
import facade.DonacionesFacade;
import facade.DonadorFacade;
import facade.ProyectosFacade;
import facade.TipodocumentosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;

@Named(value = "donacionControlador")
@SessionScoped
public class DonacionControlador implements Serializable {

    @EJB
    DonadorFacade donadorFacade;
    private Donador donador = new Donador();

    @EJB
    DonacionesFacade donacionesFacade;
    private Donaciones donaciones = new Donaciones();

    @EJB
    TipodocumentosFacade TipodocumentosFacade;
    private Tipodocumentos tipodocumentos = new Tipodocumentos();

    @EJB
    ProyectosFacade proyectosFacade;
    private Proyectos proyectos = new Proyectos();

    private String email = null;

    private Part file;

    public DonacionControlador() {
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void registrar() {
        donadorFacade.create(donador);
        donaciones.setFkDonador(donadorFacade.find(donador.getIdDonador()));
        donacionesFacade.create(donaciones);
        donador = new Donador();
        donaciones = new Donaciones();
    }

    public void enviarCorreoDonador(String email) {
        Email e2 = new Email("nuviproject@gmail.com", "proyectosena", "alejandrohuertas1992@gmail.com", "da236@misena.edu.co");
        e2.enviarSimple("Información registro", "El Sr. " + donador.getNombreDonador() + " se ha registrado. Cedula de ciudadanía " + donador.getDocuDonador() + " y código de registro : " + donador.getIdDonador());
        Email e = new Email("nuviproject@gmail.com", "proyectosena", email, "");
        e.enviarSimple("Confirmación registro de Donación", "Uds se ha registrado");
    }

    public String ingresarDonación() {
        UploadControler cargaDeArchivo = new UploadControler();
        cargaDeArchivo.upload(file);
        donaciones.setImgComporbante(cargaDeArchivo.getPath());
        registrar();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información regsitrada", "Registro correcto");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        System.out.println("Registro correcto");
        return "";
    }

    public String registrarDonacion() {
        if (email == null ? donador.getEmailDonador() != null : !email.equals(donador.getEmailDonador())) {
            setEmail("");
        } else {
            UploadControler cargaDeArchivo = new UploadControler();
            cargaDeArchivo.upload(file);
            donaciones.setImgComporbante(cargaDeArchivo.getPath());
            enviarCorreoDonador(email);
            registrar();
            setEmail("");
            // Alertas
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha registrado tu donación", "Cada aporte es un paso más cerca a nuestra meta. Acabas de recibir un correo de confirmación.");
            PrimeFaces.current().dialog().showMessageDynamic(message);

            System.out.println("Este es nombre:" + cargaDeArchivo.getNombre());
            System.out.println("Este es path:" + cargaDeArchivo.getPath());
            
        }
        return "";
    }

    public List<Donaciones> listarDonacion() {
        return donacionesFacade.findAll();
    }

    public String asignarProyecto(Donaciones objDonaciones) {
        donaciones = objDonaciones;
        return "ListasDonacion";
    }

    public String actualizarDonacion(Donaciones objDonaciones) {

        if (objDonaciones.getFkProyecto() != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Donación ya asignada", "La donación ya se encuentra asignada.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "";
        } else {
            donaciones = objDonaciones;
            return "ActualizarDonacion?faces-redirect=true";

        }
    }

    public void editar() {
        donaciones.setFkProyecto(proyectosFacade.find(proyectos.getIdProyecto()));
        donacionesFacade.edit(donaciones);
        donaciones = new Donaciones();
    }

    public String eliminarDonacion(Donaciones objDonacion) {
        donaciones = objDonacion;
        donacionesFacade.remove(donaciones);
        return "ListaDonacion";
    }

    //CRUD 
    public String editarDonacion() {
        try {
            editar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación correcta", "La donación se asigno al proyecto");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "ListaDonaciones";
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en transacción", "Se debe asignar a un proyecto");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "";
        }

    }

}
