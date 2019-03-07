/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Alejandro
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal")
    , @NamedQuery(name = "Personal.findByNombrePersonal", query = "SELECT p FROM Personal p WHERE p.nombrePersonal = :nombrePersonal")
    , @NamedQuery(name = "Personal.findByApellidoPersonal", query = "SELECT p FROM Personal p WHERE p.apellidoPersonal = :apellidoPersonal")
    , @NamedQuery(name = "Personal.findByProfesionPersonal", query = "SELECT p FROM Personal p WHERE p.profesionPersonal = :profesionPersonal")
    , @NamedQuery(name = "Personal.findByFechaNacimiento", query = "SELECT p FROM Personal p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Personal.findByFechaIngreso", query = "SELECT p FROM Personal p WHERE p.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Personal.findByCategoriaPersonal", query = "SELECT p FROM Personal p WHERE p.categoriaPersonal = :categoriaPersonal")
    , @NamedQuery(name = "Personal.findByDocumPersonal", query = "SELECT p FROM Personal p WHERE p.documPersonal = :documPersonal")
    , @NamedQuery(name = "Personal.findByContacPersonal", query = "SELECT p FROM Personal p WHERE p.contacPersonal = :contacPersonal")
    , @NamedQuery(name = "Personal.findByEmailPersonal", query = "SELECT p FROM Personal p WHERE p.emailPersonal = :emailPersonal")
    , @NamedQuery(name = "Personal.findByCosto", query = "SELECT p FROM Personal p WHERE p.costo = :costo")
    , @NamedQuery(name = "Personal.findByDisponibilidad", query = "SELECT p FROM Personal p WHERE p.disponibilidad = :disponibilidad")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Personal")
    private Integer idPersonal;
    @Size(max = 45)
    @Column(name = "Nombre_Personal")
    private String nombrePersonal;
    @Size(max = 45)
    @Column(name = "Apellido_Personal")
    private String apellidoPersonal;
    @Size(max = 45)
    @Column(name = "Profesion_Personal")
    private String profesionPersonal;
    @Column(name = "fecha_Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Size(max = 45)
    @Column(name = "Categoria_Personal")
    private String categoriaPersonal;
    @Size(max = 45)
    @Column(name = "Docum_Personal")
    private String documPersonal;
    @Size(max = 45)
    @Column(name = "Contac_Personal")
    private String contacPersonal;
    @Size(max = 45)
    @Column(name = "Email_Personal")
    private String emailPersonal;
    @Column(name = "Costo")
    private Integer costo;
    @Size(max = 45)
    @Column(name = "Disponibilidad")
    private String disponibilidad;
    @JoinColumn(name = "fk_TipoDocum", referencedColumnName = "id_TipoDocum")
    @ManyToOne
    private Tipodocumentos fkTipoDocum;
    @JoinColumn(name = "fk_Proyecto", referencedColumnName = "id_Proyecto")
    @ManyToOne
    private Proyectos fkProyecto;

    public Personal() {
    }

    public Personal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getProfesionPersonal() {
        return profesionPersonal;
    }

    public void setProfesionPersonal(String profesionPersonal) {
        this.profesionPersonal = profesionPersonal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCategoriaPersonal() {
        return categoriaPersonal;
    }

    public void setCategoriaPersonal(String categoriaPersonal) {
        this.categoriaPersonal = categoriaPersonal;
    }

    public String getDocumPersonal() {
        return documPersonal;
    }

    public void setDocumPersonal(String documPersonal) {
        this.documPersonal = documPersonal;
    }

    public String getContacPersonal() {
        return contacPersonal;
    }

    public void setContacPersonal(String contacPersonal) {
        this.contacPersonal = contacPersonal;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Tipodocumentos getFkTipoDocum() {
        return fkTipoDocum;
    }

    public void setFkTipoDocum(Tipodocumentos fkTipoDocum) {
        this.fkTipoDocum = fkTipoDocum;
    }

    public Proyectos getFkProyecto() {
        return fkProyecto;
    }

    public void setFkProyecto(Proyectos fkProyecto) {
        this.fkProyecto = fkProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Personal[ idPersonal=" + idPersonal + " ]";
    }
    
}
