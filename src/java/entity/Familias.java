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
import javax.persistence.Lob;
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
@Table(name = "familias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familias.findAll", query = "SELECT f FROM Familias f")
    , @NamedQuery(name = "Familias.findByIdFamilia", query = "SELECT f FROM Familias f WHERE f.idFamilia = :idFamilia")
    , @NamedQuery(name = "Familias.findByNombreCdeFamilia", query = "SELECT f FROM Familias f WHERE f.nombreCdeFamilia = :nombreCdeFamilia")
    , @NamedQuery(name = "Familias.findByApellidoCdeFamilia", query = "SELECT f FROM Familias f WHERE f.apellidoCdeFamilia = :apellidoCdeFamilia")
    , @NamedQuery(name = "Familias.findByFechaVisita", query = "SELECT f FROM Familias f WHERE f.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "Familias.findByDocumCdeFamilia", query = "SELECT f FROM Familias f WHERE f.documCdeFamilia = :documCdeFamilia")
    , @NamedQuery(name = "Familias.findByIntegrantesFamilia", query = "SELECT f FROM Familias f WHERE f.integrantesFamilia = :integrantesFamilia")
    , @NamedQuery(name = "Familias.findByBarrioFamilia", query = "SELECT f FROM Familias f WHERE f.barrioFamilia = :barrioFamilia")
    , @NamedQuery(name = "Familias.findByDireccionFamilia", query = "SELECT f FROM Familias f WHERE f.direccionFamilia = :direccionFamilia")
    , @NamedQuery(name = "Familias.findByCiudadFamilia", query = "SELECT f FROM Familias f WHERE f.ciudadFamilia = :ciudadFamilia")})
public class Familias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Familia")
    private Integer idFamilia;
    @Size(max = 45)
    @Column(name = "Nombre_Cde_Familia")
    private String nombreCdeFamilia;
    @Size(max = 45)
    @Column(name = "Apellido_Cde_Familia")
    private String apellidoCdeFamilia;
    @Column(name = "Fecha_Visita")
    @Temporal(TemporalType.DATE)
    private Date fechaVisita;
    @Size(max = 45)
    @Column(name = "Docum_Cde_Familia")
    private String documCdeFamilia;
    @Column(name = "Integrantes_Familia")
    private Integer integrantesFamilia;
    @Size(max = 45)
    @Column(name = "Barrio_Familia")
    private String barrioFamilia;
    @Size(max = 45)
    @Column(name = "Direccion_Familia")
    private String direccionFamilia;
    @Size(max = 45)
    @Column(name = "ciudad_Familia")
    private String ciudadFamilia;
    @Lob
    @Size(max = 65535)
    @Column(name = "imgHogar")
    private String imgHogar;
    @JoinColumn(name = "fk_TipoDocum", referencedColumnName = "id_TipoDocum")
    @ManyToOne
    private Tipodocumentos fkTipoDocum;
    @JoinColumn(name = "fk_Problematica", referencedColumnName = "id_Problematica")
    @ManyToOne
    private Problematicas fkProblematica;
    @OneToMany(mappedBy = "fkFamilia")
    private List<Proyectos> proyectosList;

    public Familias() {
    }

    public Familias(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreCdeFamilia() {
        return nombreCdeFamilia;
    }

    public void setNombreCdeFamilia(String nombreCdeFamilia) {
        this.nombreCdeFamilia = nombreCdeFamilia;
    }

    public String getApellidoCdeFamilia() {
        return apellidoCdeFamilia;
    }

    public void setApellidoCdeFamilia(String apellidoCdeFamilia) {
        this.apellidoCdeFamilia = apellidoCdeFamilia;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getDocumCdeFamilia() {
        return documCdeFamilia;
    }

    public void setDocumCdeFamilia(String documCdeFamilia) {
        this.documCdeFamilia = documCdeFamilia;
    }

    public Integer getIntegrantesFamilia() {
        return integrantesFamilia;
    }

    public void setIntegrantesFamilia(Integer integrantesFamilia) {
        this.integrantesFamilia = integrantesFamilia;
    }

    public String getBarrioFamilia() {
        return barrioFamilia;
    }

    public void setBarrioFamilia(String barrioFamilia) {
        this.barrioFamilia = barrioFamilia;
    }

    public String getDireccionFamilia() {
        return direccionFamilia;
    }

    public void setDireccionFamilia(String direccionFamilia) {
        this.direccionFamilia = direccionFamilia;
    }

    public String getCiudadFamilia() {
        return ciudadFamilia;
    }

    public void setCiudadFamilia(String ciudadFamilia) {
        this.ciudadFamilia = ciudadFamilia;
    }

    public String getImgHogar() {
        return imgHogar;
    }

    public void setImgHogar(String imgHogar) {
        this.imgHogar = imgHogar;
    }

    public Tipodocumentos getFkTipoDocum() {
        return fkTipoDocum;
    }

    public void setFkTipoDocum(Tipodocumentos fkTipoDocum) {
        this.fkTipoDocum = fkTipoDocum;
    }

    public Problematicas getFkProblematica() {
        return fkProblematica;
    }

    public void setFkProblematica(Problematicas fkProblematica) {
        this.fkProblematica = fkProblematica;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familias)) {
            return false;
        }
        Familias other = (Familias) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Familias[ idFamilia=" + idFamilia + " ]";
    }
    
}
