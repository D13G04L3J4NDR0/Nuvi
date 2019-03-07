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
@Table(name = "materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")
    , @NamedQuery(name = "Materiales.findByIdMaterial", query = "SELECT m FROM Materiales m WHERE m.idMaterial = :idMaterial")
    , @NamedQuery(name = "Materiales.findByNombreMaterial", query = "SELECT m FROM Materiales m WHERE m.nombreMaterial = :nombreMaterial")
    , @NamedQuery(name = "Materiales.findByUnidadMedida", query = "SELECT m FROM Materiales m WHERE m.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Materiales.findByDescripcion", query = "SELECT m FROM Materiales m WHERE m.descripcion = :descripcion")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Material")
    private Integer idMaterial;
    @Size(max = 45)
    @Column(name = "Nombre_Material")
    private String nombreMaterial;
    @Size(max = 10)
    @Column(name = "Unidad_Medida")
    private String unidadMedida;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "fkMaterial")
    private List<MaterialesProyecto> materialesProyectoList;

    public Materiales() {
    }

    public Materiales(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<MaterialesProyecto> getMaterialesProyectoList() {
        return materialesProyectoList;
    }

    public void setMaterialesProyectoList(List<MaterialesProyecto> materialesProyectoList) {
        this.materialesProyectoList = materialesProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Materiales[ idMaterial=" + idMaterial + " ]";
    }
    
}
