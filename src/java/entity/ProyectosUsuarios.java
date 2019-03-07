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
@Table(name = "proyectos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectosUsuarios.findAll", query = "SELECT p FROM ProyectosUsuarios p")
    , @NamedQuery(name = "ProyectosUsuarios.findByIdProyectoUsuario", query = "SELECT p FROM ProyectosUsuarios p WHERE p.idProyectoUsuario = :idProyectoUsuario")})
public class ProyectosUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Proyecto_Usuario")
    private Integer idProyectoUsuario;
    @JoinColumn(name = "fk_Proyecto", referencedColumnName = "id_Proyecto")
    @ManyToOne
    private Proyectos fkProyecto;
    @JoinColumn(name = "fk_Usuario", referencedColumnName = "id_Usuario")
    @ManyToOne
    private Usuarios fkUsuario;

    public ProyectosUsuarios() {
    }

    public ProyectosUsuarios(Integer idProyectoUsuario) {
        this.idProyectoUsuario = idProyectoUsuario;
    }

    public Integer getIdProyectoUsuario() {
        return idProyectoUsuario;
    }

    public void setIdProyectoUsuario(Integer idProyectoUsuario) {
        this.idProyectoUsuario = idProyectoUsuario;
    }

    public Proyectos getFkProyecto() {
        return fkProyecto;
    }

    public void setFkProyecto(Proyectos fkProyecto) {
        this.fkProyecto = fkProyecto;
    }

    public Usuarios getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuarios fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoUsuario != null ? idProyectoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosUsuarios)) {
            return false;
        }
        ProyectosUsuarios other = (ProyectosUsuarios) object;
        if ((this.idProyectoUsuario == null && other.idProyectoUsuario != null) || (this.idProyectoUsuario != null && !this.idProyectoUsuario.equals(other.idProyectoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProyectosUsuarios[ idProyectoUsuario=" + idProyectoUsuario + " ]";
    }
    
}
