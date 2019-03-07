/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Alejandro
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findByIdProyecto", query = "SELECT p FROM Proyectos p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyectos.findByCodProyecto", query = "SELECT p FROM Proyectos p WHERE p.codProyecto = :codProyecto")
    , @NamedQuery(name = "Proyectos.findByNombreProyecto", query = "SELECT p FROM Proyectos p WHERE p.nombreProyecto = :nombreProyecto")
    , @NamedQuery(name = "Proyectos.findByFechaInicioProyecto", query = "SELECT p FROM Proyectos p WHERE p.fechaInicioProyecto = :fechaInicioProyecto")
    , @NamedQuery(name = "Proyectos.findByFechaFinProyecto", query = "SELECT p FROM Proyectos p WHERE p.fechaFinProyecto = :fechaFinProyecto")
    , @NamedQuery(name = "Proyectos.findByCostoMaterial", query = "SELECT p FROM Proyectos p WHERE p.costoMaterial = :costoMaterial")
    , @NamedQuery(name = "Proyectos.findByCostoPersonal", query = "SELECT p FROM Proyectos p WHERE p.costoPersonal = :costoPersonal")
    , @NamedQuery(name = "Proyectos.findByCostoProyecto", query = "SELECT p FROM Proyectos p WHERE p.costoProyecto = :costoProyecto")
    , @NamedQuery(name = "Proyectos.findByCantidadVoluntarios", query = "SELECT p FROM Proyectos p WHERE p.cantidadVoluntarios = :cantidadVoluntarios")
    , @NamedQuery(name = "Proyectos.findByDineroRecaudado", query = "SELECT p FROM Proyectos p WHERE p.dineroRecaudado = :dineroRecaudado")
    , @NamedQuery(name = "Proyectos.findBySolucionProyecto", query = "SELECT p FROM Proyectos p WHERE p.solucionProyecto = :solucionProyecto")
    , @NamedQuery(name = "Proyectos.findByEstadoProyecto", query = "SELECT p FROM Proyectos p WHERE p.estadoProyecto = :estadoProyecto")
    , @NamedQuery(name = "Proyectos.findByImgCierreProyecto", query = "SELECT p FROM Proyectos p WHERE p.imgCierreProyecto = :imgCierreProyecto")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Proyecto")
    private Integer idProyecto;
    @Size(max = 15)
    @Column(name = "cod_proyecto")
    private String codProyecto;
    @Size(max = 45)
    @Column(name = "Nombre_Proyecto")
    private String nombreProyecto;
    @Column(name = "FechaInicio_Proyecto")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioProyecto;
    @Column(name = "FechaFin_Proyecto")
    @Temporal(TemporalType.DATE)
    private Date fechaFinProyecto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Costo_Material")
    private Float costoMaterial;
    @Column(name = "Costo_Personal")
    private Float costoPersonal;
    @Column(name = "Costo_Proyecto")
    private Float costoProyecto;
    @Column(name = "Cantidad_Voluntarios")
    private Integer cantidadVoluntarios;
    @Column(name = "Dinero_Recaudado")
    private Float dineroRecaudado;
    @Size(max = 1000)
    @Column(name = "Solucion_Proyecto")
    private String solucionProyecto;
    @Size(max = 10)
    @Column(name = "Estado_Proyecto")
    private String estadoProyecto;
    @Size(max = 100)
    @Column(name = "imgCierreProyecto")
    private String imgCierreProyecto;
    @OneToMany(mappedBy = "fkProyecto")
    private List<MaterialesProyecto> materialesProyectoList;
    @OneToMany(mappedBy = "fkProyecto")
    private List<Personal> personalList;
    @JoinColumn(name = "fk_Familia", referencedColumnName = "id_Familia")
    @ManyToOne
    private Familias fkFamilia;
    @OneToMany(mappedBy = "fkProyecto")
    private List<Donaciones> donacionesList;
    @OneToMany(mappedBy = "fkProyecto")
    private List<ProyectosUsuarios> proyectosUsuariosList;

    public Proyectos() {
    }

    public Proyectos(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicioProyecto() {
        return fechaInicioProyecto;
    }

    public void setFechaInicioProyecto(Date fechaInicioProyecto) {
        this.fechaInicioProyecto = fechaInicioProyecto;
    }

    public Date getFechaFinProyecto() {
        return fechaFinProyecto;
    }

    public void setFechaFinProyecto(Date fechaFinProyecto) {
        this.fechaFinProyecto = fechaFinProyecto;
    }

    public Float getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(Float costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    public Float getCostoPersonal() {
        return costoPersonal;
    }

    public void setCostoPersonal(Float costoPersonal) {
        this.costoPersonal = costoPersonal;
    }

    public Float getCostoProyecto() {
        return costoProyecto;
    }

    public void setCostoProyecto(Float costoProyecto) {
        this.costoProyecto = costoProyecto;
    }

    public Integer getCantidadVoluntarios() {
        return cantidadVoluntarios;
    }

    public void setCantidadVoluntarios(Integer cantidadVoluntarios) {
        this.cantidadVoluntarios = cantidadVoluntarios;
    }

    public Float getDineroRecaudado() {
        return dineroRecaudado;
    }

    public void setDineroRecaudado(Float dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }

    public String getSolucionProyecto() {
        return solucionProyecto;
    }

    public void setSolucionProyecto(String solucionProyecto) {
        this.solucionProyecto = solucionProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getImgCierreProyecto() {
        return imgCierreProyecto;
    }

    public void setImgCierreProyecto(String imgCierreProyecto) {
        this.imgCierreProyecto = imgCierreProyecto;
    }

    @XmlTransient
    public List<MaterialesProyecto> getMaterialesProyectoList() {
        return materialesProyectoList;
    }

    public void setMaterialesProyectoList(List<MaterialesProyecto> materialesProyectoList) {
        this.materialesProyectoList = materialesProyectoList;
    }

    @XmlTransient
    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }

    public Familias getFkFamilia() {
        return fkFamilia;
    }

    public void setFkFamilia(Familias fkFamilia) {
        this.fkFamilia = fkFamilia;
    }

    @XmlTransient
    public List<Donaciones> getDonacionesList() {
        return donacionesList;
    }

    public void setDonacionesList(List<Donaciones> donacionesList) {
        this.donacionesList = donacionesList;
    }

    @XmlTransient
    public List<ProyectosUsuarios> getProyectosUsuariosList() {
        return proyectosUsuariosList;
    }

    public void setProyectosUsuariosList(List<ProyectosUsuarios> proyectosUsuariosList) {
        this.proyectosUsuariosList = proyectosUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Proyectos[ idProyecto=" + idProyecto + " ]";
    }
    
}
