/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

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
 * @author Aubrey
 */
@Entity
@Table(name = "SYSTEMUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemuser.findAll", query = "SELECT s FROM Systemuser s"),
    @NamedQuery(name = "Systemuser.findById", query = "SELECT s FROM Systemuser s WHERE s.id = :id"),
    @NamedQuery(name = "Systemuser.findByAccesslevel", query = "SELECT s FROM Systemuser s WHERE s.accesslevel = :accesslevel"),
    @NamedQuery(name = "Systemuser.findByPassword", query = "SELECT s FROM Systemuser s WHERE s.password = :password"),
    @NamedQuery(name = "Systemuser.findByUsername", query = "SELECT s FROM Systemuser s WHERE s.username = :username")})
public class Systemuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "ACCESSLEVEL")
    private int accesslevel;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;

    public Systemuser() {
    }

    public Systemuser(Long id) {
        this.id = id;
    }

    public Systemuser(Long id, int accesslevel, String password, String username) {
        this.id = id;
        this.accesslevel = accesslevel;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof Systemuser)) {
            return false;
        }
        Systemuser other = (Systemuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.Systemuser[ id=" + id + " ]";
    }
    
}
