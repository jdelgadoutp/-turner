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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name = "puntoservices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntoservices.findAll", query = "SELECT p FROM Puntoservices p")
    , @NamedQuery(name = "Puntoservices.findById", query = "SELECT p FROM Puntoservices p WHERE p.id = :id")
    , @NamedQuery(name = "Puntoservices.findByPunto", query = "SELECT p FROM Puntoservices p WHERE p.punto = :punto")
    , @NamedQuery(name = "Puntoservices.findByService", query = "SELECT p FROM Puntoservices p WHERE p.service = :service")
    , @NamedQuery(name = "Puntoservices.findByServicename", query = "SELECT p FROM Puntoservices p WHERE p.servicename = :servicename")})
public class Puntoservices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "punto")
    private String punto;
    @Column(name = "service")
    private String service;
    @Column(name = "servicename")
    private String servicename;

    public Puntoservices() {
    }

    public Puntoservices(Integer id) {
        this.id = id;
    }

    public Puntoservices(Integer id, String punto) {
        this.id = id;
        this.punto = punto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
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
        if (!(object instanceof Puntoservices)) {
            return false;
        }
        Puntoservices other = (Puntoservices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Puntoservices[ id=" + id + " ]";
    }
    
}
