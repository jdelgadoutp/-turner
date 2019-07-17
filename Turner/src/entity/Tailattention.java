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
@Table(name = "tailattention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tailattention.findAll", query = "SELECT t FROM Tailattention t")
    , @NamedQuery(name = "Tailattention.findByService", query = "SELECT t FROM Tailattention t WHERE t.service = :service")
    , @NamedQuery(name = "Tailattention.findByUsers", query = "SELECT t FROM Tailattention t WHERE t.users = :users")})
public class Tailattention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "service")
    private String service;
    @Basic(optional = false)
    @Column(name = "users")
    private int users;

    public Tailattention() {
    }

    public Tailattention(String service) {
        this.service = service;
    }

    public Tailattention(String service, int users) {
        this.service = service;
        this.users = users;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
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
        if (!(object instanceof Tailattention)) {
            return false;
        }
        Tailattention other = (Tailattention) object;
        if ((this.service == null && other.service != null) || (this.service != null && !this.service.equals(other.service))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tailattention[ service=" + service + " ]";
    }
    
}
