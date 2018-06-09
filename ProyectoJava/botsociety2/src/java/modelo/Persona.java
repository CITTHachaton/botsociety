/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Persona.findByRutPersona", query = "SELECT p FROM Persona p WHERE p.rutPersona = :rutPersona")
    , @NamedQuery(name = "Persona.findByIdTipoD", query = "SELECT p FROM Persona p WHERE p.idTipoD = :idTipoD")
    , @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByIdNacionalidad", query = "SELECT p FROM Persona p WHERE p.idNacionalidad = :idNacionalidad")
    , @NamedQuery(name = "Persona.findByIdComuna", query = "SELECT p FROM Persona p WHERE p.idComuna = :idComuna")
    , @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Persona.findByIdEstadoc", query = "SELECT p FROM Persona p WHERE p.idEstadoc = :idEstadoc")
    , @NamedQuery(name = "Persona.findByIdSexo", query = "SELECT p FROM Persona p WHERE p.idSexo = :idSexo")
    , @NamedQuery(name = "Persona.findByIdGenero", query = "SELECT p FROM Persona p WHERE p.idGenero = :idGenero")
    , @NamedQuery(name = "Persona.findByIdNivelE", query = "SELECT p FROM Persona p WHERE p.idNivelE = :idNivelE")
    , @NamedQuery(name = "Persona.findByProfesion", query = "SELECT p FROM Persona p WHERE p.profesion = :profesion")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")
    , @NamedQuery(name = "Persona.findByPresentacion", query = "SELECT p FROM Persona p WHERE p.presentacion = :presentacion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "rut_persona")
    private String rutPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_d")
    private int idTipoD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nacionalidad")
    private int idNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comuna")
    private int idComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoc")
    private int idEstadoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sexo")
    private int idSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_genero")
    private int idGenero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_e")
    private int idNivelE;
    @Size(max = 40)
    @Column(name = "profesion")
    private String profesion;
    @Size(max = 60)
    @Column(name = "correo")
    private String correo;
    @Size(max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 12)
    @Column(name = "celular")
    private String celular;
    @Size(max = 300)
    @Column(name = "presentacion")
    private String presentacion;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String rutPersona, int idTipoD, String nombres, String apellidos, Date fechaNacimiento, int idNacionalidad, int idComuna, String direccion, int idEstadoc, int idSexo, int idGenero, int idNivelE) {
        this.idPersona = idPersona;
        this.rutPersona = rutPersona;
        this.idTipoD = idTipoD;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idNacionalidad = idNacionalidad;
        this.idComuna = idComuna;
        this.direccion = direccion;
        this.idEstadoc = idEstadoc;
        this.idSexo = idSexo;
        this.idGenero = idGenero;
        this.idNivelE = idNivelE;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(String rutPersona) {
        this.rutPersona = rutPersona;
    }

    public int getIdTipoD() {
        return idTipoD;
    }

    public void setIdTipoD(int idTipoD) {
        this.idTipoD = idTipoD;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdEstadoc() {
        return idEstadoc;
    }

    public void setIdEstadoc(int idEstadoc) {
        this.idEstadoc = idEstadoc;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdNivelE() {
        return idNivelE;
    }

    public void setIdNivelE(int idNivelE) {
        this.idNivelE = idNivelE;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
