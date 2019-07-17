/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name = "turn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turn.findAll", query = "SELECT t FROM Turn t")
    , @NamedQuery(name = "Turn.findById", query = "SELECT t FROM Turn t WHERE t.id = :id")
    , @NamedQuery(name = "Turn.findByFact", query = "SELECT t FROM Turn t WHERE t.fact = :fact")
    , @NamedQuery(name = "Turn.findByUsers", query = "SELECT t FROM Turn t WHERE t.users = :users")
    , @NamedQuery(name = "Turn.findByUsername", query = "SELECT t FROM Turn t WHERE t.username = :username")
    , @NamedQuery(name = "Turn.findByServicename", query = "SELECT t FROM Turn t WHERE t.servicename = :servicename")
    , @NamedQuery(name = "Turn.findByPriority", query = "SELECT t FROM Turn t WHERE t.priority = :priority")
    , @NamedQuery(name = "Turn.findByPriorityname", query = "SELECT t FROM Turn t WHERE t.priorityname = :priorityname")})
public class Turn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fact;
    @Column(name = "users")
    private String users;
    @Column(name = "username")
    private String username;
    @Column(name = "servicename")
    private String servicename;
    @Column(name = "priority")
    private Boolean priority;
    @Column(name = "priorityname")
    private String priorityname;

    public Turn() {
    }

    public Turn(Integer id) {
        this.id = id;
    }

    public Turn(Integer id, Date fact) {
        this.id = id;
        this.fact = fact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFact() {
        return fact;
    }

    public void setFact(Date fact) {
        this.fact = fact;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String user) {
        this.users = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public String getPriorityname() {
        return priorityname;
    }

    public void setPriorityname(String priorityname) {
        this.priorityname = priorityname;
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
        if (!(object instanceof Turn)) {
            return false;
        }
        Turn other = (Turn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Turn[ id=" + id + " ]";
    }
    
}
