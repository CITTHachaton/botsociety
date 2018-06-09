/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findByIdExperienciaLaboral", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idExperienciaLaboral = :idExperienciaLaboral")
    , @NamedQuery(name = "ExperienciaLaboral.findByIdPersona", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idPersona = :idPersona")
    , @NamedQuery(name = "ExperienciaLaboral.findByPeriodo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.periodo = :periodo")
    , @NamedQuery(name = "ExperienciaLaboral.findByEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.empresa = :empresa")
    , @NamedQuery(name = "ExperienciaLaboral.findByCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.cargo = :cargo")
    , @NamedQuery(name = "ExperienciaLaboral.findByGlosa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.glosa = :glosa")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_experiencia_laboral")
    private Integer idExperienciaLaboral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 40)
    @Column(name = "glosa")
    private String glosa;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public ExperienciaLaboral(Integer idExperienciaLaboral, int idPersona, String periodo, String empresa, String cargo) {
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.idPersona = idPersona;
        this.periodo = periodo;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public Integer getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperienciaLaboral != null ? idExperienciaLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.idExperienciaLaboral == null && other.idExperienciaLaboral != null) || (this.idExperienciaLaboral != null && !this.idExperienciaLaboral.equals(other.idExperienciaLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ExperienciaLaboral[ idExperienciaLaboral=" + idExperienciaLaboral + " ]";
    }
    
}
