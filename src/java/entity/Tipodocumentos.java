/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Alejandro
 */
@Entity
@Table(name = "tipodocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumentos.findAll", query = "SELECT t FROM Tipodocumentos t")
    , @NamedQuery(name = "Tipodocumentos.findByIdTipoDocum", query = "SELECT t FROM Tipodocumentos t WHERE t.idTipoDocum = :idTipoDocum")
    , @NamedQuery(name = "Tipodocumentos.findByTipoDocum", query = "SELECT t FROM Tipodocumentos t WHERE t.tipoDocum = :tipoDocum")
    , @NamedQuery(name = "Tipodocumentos.findByDescripcion", query = "SELECT t FROM Tipodocumentos t WHERE t.descripcion = :descripcion")})
public class Tipodocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_TipoDocum")
    private Integer idTipoDocum;
    @Size(max = 10)
    @Column(name = "Tipo_Docum")
    private String tipoDocum;
    @Size(max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "fkTipoDocum")
    private List<Familias> familiasList;
    @OneToMany(mappedBy = "fkTipoDocum")
    private List<Personal> personalList;
    @OneToMany(mappedBy = "fkTipoDocum")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "fkTipoDocum")
    private List<Donador> donadorList;

    public Tipodocumentos() {
    }

    public Tipodocumentos(Integer idTipoDocum) {
        this.idTipoDocum = idTipoDocum;
    }

    public Integer getIdTipoDocum() {
        return idTipoDocum;
    }

    public void setIdTipoDocum(Integer idTipoDocum) {
        this.idTipoDocum = idTipoDocum;
    }

    public String getTipoDocum() {
        return tipoDocum;
    }

    public void setTipoDocum(String tipoDocum) {
        this.tipoDocum = tipoDocum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Familias> getFamiliasList() {
        return familiasList;
    }

    public void setFamiliasList(List<Familias> familiasList) {
        this.familiasList = familiasList;
    }

    @XmlTransient
    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Donador> getDonadorList() {
        return donadorList;
    }

    public void setDonadorList(List<Donador> donadorList) {
        this.donadorList = donadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocum != null ? idTipoDocum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumentos)) {
            return false;
        }
        Tipodocumentos other = (Tipodocumentos) object;
        if ((this.idTipoDocum == null && other.idTipoDocum != null) || (this.idTipoDocum != null && !this.idTipoDocum.equals(other.idTipoDocum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tipodocumentos[ idTipoDocum=" + idTipoDocum + " ]";
    }
    
}
