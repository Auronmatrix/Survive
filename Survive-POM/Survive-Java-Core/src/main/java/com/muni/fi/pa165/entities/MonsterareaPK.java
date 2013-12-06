/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Auron
 */
@Embeddable
public class MonsterareaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MONSTERID")
    private long monsterid;
    @Basic(optional = false)
    @Column(name = "AREAID")
    private long areaid;

    public MonsterareaPK() {
    }

    public MonsterareaPK(long monsterid, long areaid) {
        this.monsterid = monsterid;
        this.areaid = areaid;
    }

    public long getMonsterid() {
        return monsterid;
    }

    public void setMonsterid(long monsterid) {
        this.monsterid = monsterid;
    }

    public long getAreaid() {
        return areaid;
    }

    public void setAreaid(long areaid) {
        this.areaid = areaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) monsterid;
        hash += (int) areaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonsterareaPK)) {
            return false;
        }
        MonsterareaPK other = (MonsterareaPK) object;
        if (this.monsterid != other.monsterid) {
            return false;
        }
        if (this.areaid != other.areaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.MonsterareaPK[ monsterId=" + monsterid + ", areaId=" + areaid + " ]";
    }
    
}
