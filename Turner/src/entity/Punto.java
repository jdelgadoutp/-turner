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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name = "punto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punto.findAll", query = "SELECT p FROM Punto p")
    , @NamedQuery(name = "Punto.findById", query = "SELECT p FROM Punto p WHERE p.id = :id")
    , @NamedQuery(name = "Punto.findByAdviser", query = "SELECT p FROM Punto p WHERE p.adviser = :adviser")
    , @NamedQuery(name = "Punto.findByActivo", query = "SELECT p FROM Punto p WHERE p.activo = :activo")
    , @NamedQuery(name = "Punto.findByAdvisername", query = "SELECT p FROM Punto p WHERE p.advisername = :advisername")})
public class Punto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "adviser")
    private String adviser;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "advisername")
    private String advisername;

    public Punto() {
    }

    public Punto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getAdvisername() {
        return advisername;
    }

    public void setAdvisername(String advisername) {
        this.advisername = advisername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punto)) {
            return false;
        }
        Punto other = (Punto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Punto[ id=" + id + " ]";
    }
    
}
