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
@Table(name = "donador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donador.findAll", query = "SELECT d FROM Donador d")
    , @NamedQuery(name = "Donador.findByIdDonador", query = "SELECT d FROM Donador d WHERE d.idDonador = :idDonador")
    , @NamedQuery(name = "Donador.findByNombreDonador", query = "SELECT d FROM Donador d WHERE d.nombreDonador = :nombreDonador")
    , @NamedQuery(name = "Donador.findByDocuDonador", query = "SELECT d FROM Donador d WHERE d.docuDonador = :docuDonador")
    , @NamedQuery(name = "Donador.findByFechaIngreso", query = "SELECT d FROM Donador d WHERE d.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Donador.findByContacDonador", query = "SELECT d FROM Donador d WHERE d.contacDonador = :contacDonador")
    , @NamedQuery(name = "Donador.findByEmailDonador", query = "SELECT d FROM Donador d WHERE d.emailDonador = :emailDonador")
    , @NamedQuery(name = "Donador.findByDireccionResidencia", query = "SELECT d FROM Donador d WHERE d.direccionResidencia = :direccionResidencia")
    , @NamedQuery(name = "Donador.findByCiudadResidencia", query = "SELECT d FROM Donador d WHERE d.ciudadResidencia = :ciudadResidencia")})
public class Donador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Donador")
    private Integer idDonador;
    @Size(max = 45)
    @Column(name = "nombre_Donador")
    private String nombreDonador;
    @Column(name = "Docu_Donador")
    private Integer docuDonador;
    @Column(name = "fecha_Ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Size(max = 45)
    @Column(name = "Contac_Donador")
    private String contacDonador;
    @Size(max = 45)
    @Column(name = "Email_Donador")
    private String emailDonador;
    @Size(max = 30)
    @Column(name = "Direccion_Residencia")
    private String direccionResidencia;
    @Size(max = 30)
    @Column(name = "Ciudad_Residencia")
    private String ciudadResidencia;
    @OneToMany(mappedBy = "fkDonador")
    private List<Donaciones> donacionesList;
    @JoinColumn(name = "fk_TipoDocum", referencedColumnName = "id_TipoDocum")
    @ManyToOne
    private Tipodocumentos fkTipoDocum;

    public Donador() {
    }

    public Donador(Integer idDonador) {
        this.idDonador = idDonador;
    }

    public Integer getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(Integer idDonador) {
        this.idDonador = idDonador;
    }

    public String getNombreDonador() {
        return nombreDonador;
    }

    public void setNombreDonador(String nombreDonador) {
        this.nombreDonador = nombreDonador;
    }

    public Integer getDocuDonador() {
        return docuDonador;
    }

    public void setDocuDonador(Integer docuDonador) {
        this.docuDonador = docuDonador;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getContacDonador() {
        return contacDonador;
    }

    public void setContacDonador(String contacDonador) {
        this.contacDonador = contacDonador;
    }

    public String getEmailDonador() {
        return emailDonador;
    }

    public void setEmailDonador(String emailDonador) {
        this.emailDonador = emailDonador;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @XmlTransient
    public List<Donaciones> getDonacionesList() {
        return donacionesList;
    }

    public void setDonacionesList(List<Donaciones> donacionesList) {
        this.donacionesList = donacionesList;
    }

    public Tipodocumentos getFkTipoDocum() {
        return fkTipoDocum;
    }

    public void setFkTipoDocum(Tipodocumentos fkTipoDocum) {
        this.fkTipoDocum = fkTipoDocum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonador != null ? idDonador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donador)) {
            return false;
        }
        Donador other = (Donador) object;
        if ((this.idDonador == null && other.idDonador != null) || (this.idDonador != null && !this.idDonador.equals(other.idDonador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Donador[ idDonador=" + idDonador + " ]";
    }
    
}
