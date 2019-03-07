/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Alejandro
 */
@Entity
@Table(name = "materiales_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialesProyecto.findAll", query = "SELECT m FROM MaterialesProyecto m")
    , @NamedQuery(name = "MaterialesProyecto.findByIdMaterialProyecto", query = "SELECT m FROM MaterialesProyecto m WHERE m.idMaterialProyecto = :idMaterialProyecto")
    , @NamedQuery(name = "MaterialesProyecto.findByCantidadMaterial", query = "SELECT m FROM MaterialesProyecto m WHERE m.cantidadMaterial = :cantidadMaterial")
    , @NamedQuery(name = "MaterialesProyecto.findByValorUnitario", query = "SELECT m FROM MaterialesProyecto m WHERE m.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "MaterialesProyecto.findByValorTotal", query = "SELECT m FROM MaterialesProyecto m WHERE m.valorTotal = :valorTotal")})
public class MaterialesProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Material_Proyecto")
    private Integer idMaterialProyecto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad_Material")
    private Float cantidadMaterial;
    @Column(name = "Valor_Unitario")
    private Float valorUnitario;
    @Column(name = "Valor_Total")
    private Float valorTotal;
    @JoinColumn(name = "fk_Material", referencedColumnName = "id_Material")
    @ManyToOne
    private Materiales fkMaterial;
    @JoinColumn(name = "fk_Proyecto", referencedColumnName = "id_Proyecto")
    @ManyToOne
    private Proyectos fkProyecto;

    public MaterialesProyecto() {
    }

    public MaterialesProyecto(Integer idMaterialProyecto) {
        this.idMaterialProyecto = idMaterialProyecto;
    }

    public Integer getIdMaterialProyecto() {
        return idMaterialProyecto;
    }

    public void setIdMaterialProyecto(Integer idMaterialProyecto) {
        this.idMaterialProyecto = idMaterialProyecto;
    }

    public Float getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(Float cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Materiales getFkMaterial() {
        return fkMaterial;
    }

    public void setFkMaterial(Materiales fkMaterial) {
        this.fkMaterial = fkMaterial;
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
        hash += (idMaterialProyecto != null ? idMaterialProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialesProyecto)) {
            return false;
        }
        MaterialesProyecto other = (MaterialesProyecto) object;
        if ((this.idMaterialProyecto == null && other.idMaterialProyecto != null) || (this.idMaterialProyecto != null && !this.idMaterialProyecto.equals(other.idMaterialProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MaterialesProyecto[ idMaterialProyecto=" + idMaterialProyecto + " ]";
    }
    
}
