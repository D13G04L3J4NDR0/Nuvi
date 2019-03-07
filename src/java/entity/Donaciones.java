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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Alejandro
 */
@Entity
@Table(name = "donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donaciones.findAll", query = "SELECT d FROM Donaciones d")
    , @NamedQuery(name = "Donaciones.findByIdDonacion", query = "SELECT d FROM Donaciones d WHERE d.idDonacion = :idDonacion")
    , @NamedQuery(name = "Donaciones.findByValorDonacion", query = "SELECT d FROM Donaciones d WHERE d.valorDonacion = :valorDonacion")
    , @NamedQuery(name = "Donaciones.findByFechaDonacion", query = "SELECT d FROM Donaciones d WHERE d.fechaDonacion = :fechaDonacion")
    , @NamedQuery(name = "Donaciones.findByImgComporbante", query = "SELECT d FROM Donaciones d WHERE d.imgComporbante = :imgComporbante")})
public class Donaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Donacion")
    private Integer idDonacion;
    @Column(name = "Valor_Donacion")
    private Integer valorDonacion;
    @Column(name = "Fecha_Donacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDonacion;
    @Size(max = 45)
    @Column(name = "img_Comporbante")
    private String imgComporbante;
    @JoinColumn(name = "fk_Proyecto", referencedColumnName = "id_Proyecto")
    @ManyToOne
    private Proyectos fkProyecto;
    @JoinColumn(name = "fk_Donador", referencedColumnName = "id_Donador")
    @ManyToOne
    private Donador fkDonador;

    public Donaciones() {
    }

    public Donaciones(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Integer getValorDonacion() {
        return valorDonacion;
    }

    public void setValorDonacion(Integer valorDonacion) {
        this.valorDonacion = valorDonacion;
    }

    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getImgComporbante() {
        return imgComporbante;
    }

    public void setImgComporbante(String imgComporbante) {
        this.imgComporbante = imgComporbante;
    }

    public Proyectos getFkProyecto() {
        return fkProyecto;
    }

    public void setFkProyecto(Proyectos fkProyecto) {
        this.fkProyecto = fkProyecto;
    }

    public Donador getFkDonador() {
        return fkDonador;
    }

    public void setFkDonador(Donador fkDonador) {
        this.fkDonador = fkDonador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonacion != null ? idDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donaciones)) {
            return false;
        }
        Donaciones other = (Donaciones) object;
        if ((this.idDonacion == null && other.idDonacion != null) || (this.idDonacion != null && !this.idDonacion.equals(other.idDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Donaciones[ idDonacion=" + idDonacion + " ]";
    }
    
}
