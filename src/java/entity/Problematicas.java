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
@Table(name = "problematicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problematicas.findAll", query = "SELECT p FROM Problematicas p")
    , @NamedQuery(name = "Problematicas.findByIdProblematica", query = "SELECT p FROM Problematicas p WHERE p.idProblematica = :idProblematica")
    , @NamedQuery(name = "Problematicas.findByProblematica", query = "SELECT p FROM Problematicas p WHERE p.problematica = :problematica")
    , @NamedQuery(name = "Problematicas.findByDetalleProblematica", query = "SELECT p FROM Problematicas p WHERE p.detalleProblematica = :detalleProblematica")})
public class Problematicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Problematica")
    private Integer idProblematica;
    @Size(max = 45)
    @Column(name = "Problematica")
    private String problematica;
    @Size(max = 200)
    @Column(name = "Detalle_Problematica")
    private String detalleProblematica;
    @OneToMany(mappedBy = "fkProblematica")
    private List<Familias> familiasList;

    public Problematicas() {
    }

    public Problematicas(Integer idProblematica) {
        this.idProblematica = idProblematica;
    }

    public Integer getIdProblematica() {
        return idProblematica;
    }

    public void setIdProblematica(Integer idProblematica) {
        this.idProblematica = idProblematica;
    }

    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getDetalleProblematica() {
        return detalleProblematica;
    }

    public void setDetalleProblematica(String detalleProblematica) {
        this.detalleProblematica = detalleProblematica;
    }

    @XmlTransient
    public List<Familias> getFamiliasList() {
        return familiasList;
    }

    public void setFamiliasList(List<Familias> familiasList) {
        this.familiasList = familiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProblematica != null ? idProblematica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problematicas)) {
            return false;
        }
        Problematicas other = (Problematicas) object;
        if ((this.idProblematica == null && other.idProblematica != null) || (this.idProblematica != null && !this.idProblematica.equals(other.idProblematica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Problematicas[ idProblematica=" + idProblematica + " ]";
    }
    
}
