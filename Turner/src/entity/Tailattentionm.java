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
@Table(name = "tailattentionm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tailattentionm.findAll", query = "SELECT t FROM Tailattentionm t")
    , @NamedQuery(name = "Tailattentionm.findByServicefk", query = "SELECT t FROM Tailattentionm t WHERE t.servicefk = :servicefk")
    , @NamedQuery(name = "Tailattentionm.findByTurn", query = "SELECT t FROM Tailattentionm t WHERE t.turn = :turn")
    , @NamedQuery(name = "Tailattentionm.findByServicename", query = "SELECT t FROM Tailattentionm t WHERE t.servicename = :servicename")
    , @NamedQuery(name = "Tailattentionm.findByFact", query = "SELECT t FROM Tailattentionm t WHERE t.fact = :fact")
    , @NamedQuery(name = "Tailattentionm.findByUserid", query = "SELECT t FROM Tailattentionm t WHERE t.userid = :userid")
    , @NamedQuery(name = "Tailattentionm.findByUsername", query = "SELECT t FROM Tailattentionm t WHERE t.username = :username")
    , @NamedQuery(name = "Tailattentionm.findByPriority", query = "SELECT t FROM Tailattentionm t WHERE t.priority = :priority")
    , @NamedQuery(name = "Tailattentionm.findByPriorityname", query = "SELECT t FROM Tailattentionm t WHERE t.priorityname = :priorityname")
    , @NamedQuery(name = "Tailattentionm.findByPunt", query = "SELECT t FROM Tailattentionm t WHERE t.punt = :punt")
    , @NamedQuery(name = "Tailattentionm.findByAdvinser", query = "SELECT t FROM Tailattentionm t WHERE t.advinser = :advinser")
    , @NamedQuery(name = "Tailattentionm.findByAdvisername", query = "SELECT t FROM Tailattentionm t WHERE t.advisername = :advisername")})
public class Tailattentionm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "servicefk")
    private String servicefk;
    @Basic(optional = false)
    @Column(name = "turn")
    private int turn;
    @Column(name = "servicename")
    private String servicename;
    @Column(name = "fact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fact;
    @Column(name = "userid")
    private String userid;
    @Column(name = "username")
    private String username;
    @Column(name = "priority")
    private Boolean priority;
    @Column(name = "priorityname")
    private String priorityname;
    @Column(name = "punt")
    private String punt;
    @Column(name = "advinser")
    private String advinser;
    @Column(name = "advisername")
    private String advisername;

    public Tailattentionm() {
    }

    public Tailattentionm(String servicefk) {
        this.servicefk = servicefk;
    }

    public Tailattentionm(String servicefk, int turn) {
        this.servicefk = servicefk;
        this.turn = turn;
    }

    public String getServicefk() {
        return servicefk;
    }

    public void setServicefk(String servicefk) {
        this.servicefk = servicefk;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public Date getFact() {
        return fact;
    }

    public void setFact(Date fact) {
        this.fact = fact;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPunt() {
        return punt;
    }

    public void setPunt(String punt) {
        this.punt = punt;
    }

    public String getAdvinser() {
        return advinser;
    }

    public void setAdvinser(String advinser) {
        this.advinser = advinser;
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
        hash += (servicefk != null ? servicefk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tailattentionm)) {
            return false;
        }
        Tailattentionm other = (Tailattentionm) object;
        if ((this.servicefk == null && other.servicefk != null) || (this.servicefk != null && !this.servicefk.equals(other.servicefk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tailattentionm[ servicefk=" + servicefk + " ]";
    }
    
}
