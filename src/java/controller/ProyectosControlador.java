package controller;

import entity.Familias;
import entity.Materiales;
import entity.MaterialesProyecto;
import entity.Proyectos;
import facade.FamiliasFacade;
import facade.MaterialesFacade;
import facade.MaterialesProyectoFacade;
import facade.ProyectosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.PrimeFaces;

@Named(value = "proyectosControlador")
@SessionScoped
public class ProyectosControlador implements Serializable {

    @EJB
    ProyectosFacade proyectosFacade;
    private Proyectos proyectos = new Proyectos();

    @EJB
    FamiliasFacade familiasFacade;
    private Familias familias = new Familias();

    @EJB
    MaterialesProyectoFacade materialesProyectoFacade;
    private MaterialesProyecto materialesProyecto = new MaterialesProyecto();

    @EJB
    MaterialesFacade materialesFacade;
    private Materiales materiales = new Materiales();

    private String estado;
    private float valor;
    private float resultado;
    private String codigoProyecto;
    private List<Object[]> listadoCosto;
   

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public ProyectosControlador() {
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    public MaterialesProyecto getMaterialesProyecto() {
        return materialesProyecto;
    }

    public void setMaterialesProyecto(MaterialesProyecto materialesProyecto) {
        this.materialesProyecto = materialesProyecto;
    }

    public Familias getFamilias() {
        return familias;
    }

    public void setFamilias(Familias familias) {
        this.familias = familias;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Object[]> getListadoCosto() {
        return listadoCosto;
    }

    public void setListadoCosto(List<Object[]> listadoCosto) {
        this.listadoCosto = listadoCosto;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public List<MaterialesProyecto> listarMaterialesRequeridos() {
        return materialesProyectoFacade.consultarMaterialesRequeridosSS(proyectos.getIdProyecto());
    }

    public List<MaterialesProyecto> listarMaterialesRequeridosDos() {
        return materialesProyectoFacade.consultarMaterialesRequeridos(codigoProyecto);
    }
    

    //  FIN GETTER AND SETTER
    
    public List<Proyectos> listarProyecto() {
        return proyectosFacade.findAll();
    }

    public int registrarProy() {
        proyectos.setEstadoProyecto("Creado");
        proyectos.setFkFamilia(familiasFacade.find(familias.getIdFamilia()));
        proyectosFacade.create(proyectos);
        int cod = proyectos.getIdProyecto();
        return cod;
    }

    public String registrarProyecto() {
        System.out.println("" + proyectosFacade.consultarCodProyectos(proyectos.getCodProyecto()));
        if (proyectosFacade.consultarCodProyectos(proyectos.getCodProyecto()) > 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en registro", "El código de proyecto ya existe");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            proyectos = new Proyectos();
        } else {
            registrarProy();
            proyectos = new Proyectos();
            return "AsignarMateriales";
        }
        return "";
    }

    public String registrarMaterialesRequeridos() {
        proyectos.setEstadoProyecto("En asignación de recursos");
        materialesProyecto.setFkProyecto(proyectos);
        materialesProyecto.setFkMaterial(materialesFacade.find(materiales.getIdMaterial()));
        materialesProyectoFacade.create(materialesProyecto);
        materialesProyecto = new MaterialesProyecto();
        return "";
    }

    public void asignarCostodeMateriales(MaterialesProyecto objMat) {
        materialesProyecto = objMat;
        materialesProyecto.setValorUnitario(getValor());
        materialesProyecto.setValorTotal(calcularCostoTotal());
        materialesProyectoFacade.edit(materialesProyecto);
        materialesProyecto = new MaterialesProyecto();
        valor = 0;
    }

    public void mostrarCostoTotal() {
        resultado = 0;
        listadoCosto = materialesProyectoFacade.listarCostoMateriales(codigoProyecto);
        System.out.println(listadoCosto);
        for (int i = 0; i < listadoCosto.size(); i++) {
            System.out.println(listadoCosto.get(i));
            resultado = Float.parseFloat("" + listadoCosto.get(i)) + resultado;
        }
        proyectos.setCostoMaterial(resultado);
        proyectosFacade.edit(proyectos);
        System.out.println("Costo Guardado: "+proyectos.getCostoMaterial());
        System.out.println("Total :" + resultado);
    }

    public String crearProyecto() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto Creado", "Registro Correcto");
        PrimeFaces.current().dialog().showMessageDynamic(message);        
        proyectos = new Proyectos();
        return "ConsultaProyecto?faces-redirect=true";
    }

    public List<Proyectos> listarEstadosdeProyecto() {
        return proyectosFacade.consultarEstadosdeProyectos(estado);
    }

    public List<Proyectos> listarEstadoCreado() {
        String creado = "creado";
        return proyectosFacade.consultarEstadosdeProyectos(creado);
    }

    /*Calcular Costo de cada Material*/
    public float calcularCostoTotal() {
        float valorTotal = materialesProyecto.getValorUnitario() * materialesProyecto.getCantidadMaterial();
        return valorTotal;
    }

    /*Consultar por Código de proyecto*/

    public String guardarCostoMaterial(MaterialesProyecto objProyect) {
        System.out.println(proyectos);
        float to = resultado;
        proyectos.setCostoMaterial(to);
        System.out.println("2 "+proyectos);
        System.out.println("Objeto"+objProyect);
        System.out.println("Objeto fk_Proyecto"+objProyect.getFkProyecto());
        //proyectosFacade.edit(objProyect.getFkProyecto());
        return "";
    }

    public String cierre() {
        proyectos.setEstadoProyecto("Cerrado");
        proyectosFacade.edit(proyectos);
        System.out.println(proyectos.getEstadoProyecto());
        return "CerrarProyecto";
    }

    public String cerrarProyecto(Proyectos proy) {
        proyectos = proy;
        if ("Creado".equals(proyectos.getEstadoProyecto())) {
            return "Cierre";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en opción", "El proyecto ya se encuentra en estado Cerrado");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "";
        }
    }
    
    public String mostrarMensajedeRegistroProyecto(){
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Correcto", "Materiales Registrados");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "ListaProyectos";
    }
    
    // lista estados
    
    public List<Proyectos> listarEstadoProyecto(){
        return proyectosFacade.consultarEstadosdeProyectos(estado);
    }


    @FacesValidator("primeDateRangeValidator")
    public class PrimeDateRangeValidator implements Validator {

        @Override
        public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            if (value == null) {
                return;
            }

            //Leave the null handling of startDate to required="true"
            Object startDateValue = component.getAttributes().get("fechaInicioProyecto");
            System.out.println("Fecha Obtenida: " + startDateValue);
            if (startDateValue == null) {
                return;
            }

            Date startDate = (Date) startDateValue;
            Date endDate = (Date) value;
            if (endDate.before(startDate)) {
                FacesMessage message = new FacesMessage("La fecha Final no puede ser anterior a la fecha Inicial.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }
    
    public void ir(){
        String hola ="";
    }
    
    
    
    


}
