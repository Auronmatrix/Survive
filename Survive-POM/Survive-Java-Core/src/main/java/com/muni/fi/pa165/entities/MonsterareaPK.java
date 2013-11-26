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
    @Column(name = "MONSTER_ID")
    private long monsterId;
    @Basic(optional = false)
    @Column(name = "AREA_ID")
    private long areaId;

    public MonsterareaPK() {
    }

    public MonsterareaPK(long monsterId, long areaId) {
        this.monsterId = monsterId;
        this.areaId = areaId;
    }

    public long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(long monsterId) {
        this.monsterId = monsterId;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) monsterId;
        hash += (int) areaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonsterareaPK)) {
            return false;
        }
        MonsterareaPK other = (MonsterareaPK) object;
        if (this.monsterId != other.monsterId) {
            return false;
        }
        if (this.areaId != other.areaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.MonsterareaPK[ monsterId=" + monsterId + ", areaId=" + areaId + " ]";
    }
    
}
