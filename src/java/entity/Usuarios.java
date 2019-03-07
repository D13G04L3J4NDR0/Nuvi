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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuarios.findByApellidoUsuario", query = "SELECT u FROM Usuarios u WHERE u.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "Usuarios.findByDocumUsuario", query = "SELECT u FROM Usuarios u WHERE u.documUsuario = :documUsuario")
    , @NamedQuery(name = "Usuarios.findByClaveUsuario", query = "SELECT u FROM Usuarios u WHERE u.claveUsuario = :claveUsuario")
    , @NamedQuery(name = "Usuarios.findByContacUsuario", query = "SELECT u FROM Usuarios u WHERE u.contacUsuario = :contacUsuario")
    , @NamedQuery(name = "Usuarios.findByEmailUsuario", query = "SELECT u FROM Usuarios u WHERE u.emailUsuario = :emailUsuario")
    , @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Usuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "Nombre_Usuario")
    private String nombreUsuario;
    @Size(max = 45)
    @Column(name = "Apellido_Usuario")
    private String apellidoUsuario;
    @Column(name = "Docum_Usuario")
    private Integer documUsuario;
    @Size(max = 45)
    @Column(name = "Clave_Usuario")
    private String claveUsuario;
    @Size(max = 45)
    @Column(name = "Contac_Usuario")
    private String contacUsuario;
    @Size(max = 45)
    @Column(name = "Email_Usuario")
    private String emailUsuario;
    @Column(name = "Estado")
    private Integer estado;
    @JoinColumn(name = "fk_TipoDocum", referencedColumnName = "id_TipoDocum")
    @ManyToOne
    private Tipodocumentos fkTipoDocum;
    @JoinColumn(name = "fk_roles", referencedColumnName = "id_Rol")
    @ManyToOne
    private Roles fkRoles;
    @OneToMany(mappedBy = "fkUsuario")
    private List<ProyectosUsuarios> proyectosUsuariosList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Integer getDocumUsuario() {
        return documUsuario;
    }

    public void setDocumUsuario(Integer documUsuario) {
        this.documUsuario = documUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getContacUsuario() {
        return contacUsuario;
    }

    public void setContacUsuario(String contacUsuario) {
        this.contacUsuario = contacUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Tipodocumentos getFkTipoDocum() {
        return fkTipoDocum;
    }

    public void setFkTipoDocum(Tipodocumentos fkTipoDocum) {
        this.fkTipoDocum = fkTipoDocum;
    }

    public Roles getFkRoles() {
        return fkRoles;
    }

    public void setFkRoles(Roles fkRoles) {
        this.fkRoles = fkRoles;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
