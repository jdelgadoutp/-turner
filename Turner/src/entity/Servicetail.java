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
@Table(name = "servicetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicetail.findAll", query = "SELECT s FROM Servicetail s")
    , @NamedQuery(name = "Servicetail.findByService", query = "SELECT s FROM Servicetail s WHERE s.service = :service")
    , @NamedQuery(name = "Servicetail.findByUsers", query = "SELECT s FROM Servicetail s WHERE s.users = :users")})
public class Servicetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "service")
    private String service;
    @Column(name = "users")
    private Integer users;

    public Servicetail() {
    }

    public Servicetail(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (service != null ? service.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicetail)) {
            return false;
        }
        Servicetail other = (Servicetail) object;
        if ((this.service == null && other.service != null) || (this.service != null && !this.service.equals(other.service))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Servicetail[ service=" + service + " ]";
    }
    
}
