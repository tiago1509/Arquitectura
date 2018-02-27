/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLab;

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
 * @author Personal
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findByIdMatri", query = "SELECT m FROM Matricula m WHERE m.idMatri = :idMatri")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatri")
    private Integer idMatri;
    @JoinColumn(name = "idEst", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estudiante idEst;
    @JoinColumn(name = "idMate", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Materia idMate;

    public Matricula() {
    }

    public Matricula(Integer idMatri) {
        this.idMatri = idMatri;
    }

    public Integer getIdMatri() {
        return idMatri;
    }

    public void setIdMatri(Integer idMatri) {
        this.idMatri = idMatri;
    }

    public Estudiante getIdEst() {
        return idEst;
    }

    public void setIdEst(Estudiante idEst) {
        this.idEst = idEst;
    }

    public Materia getIdMate() {
        return idMate;
    }

    public void setIdMate(Materia idMate) {
        this.idMate = idMate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatri != null ? idMatri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatri == null && other.idMatri != null) || (this.idMatri != null && !this.idMatri.equals(other.idMatri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModeloLab.Matricula[ idMatri=" + idMatri + " ]";
    }
    
}
