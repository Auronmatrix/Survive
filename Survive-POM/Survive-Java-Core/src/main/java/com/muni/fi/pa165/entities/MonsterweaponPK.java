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
public class MonsterweaponPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MONSTERID")
    private long monsterid;
    @Basic(optional = false)
    @Column(name = "WEAPONID")
    private long weaponid;

    public MonsterweaponPK() {
    }

    public MonsterweaponPK(long monsterid, long weaponid) {
        this.monsterid = monsterid;
        this.weaponid = weaponid;
    }

    public long getMonsterid() {
        return monsterid;
    }

    public void setMonsterid(long monsterid) {
        this.monsterid = monsterid;
    }

    public long getWeaponid() {
        return weaponid;
    }

    public void setWeaponid(long weaponid) {
        this.weaponid = weaponid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) monsterid;
        hash += (int) weaponid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonsterweaponPK)) {
            return false;
        }
        MonsterweaponPK other = (MonsterweaponPK) object;
        if (this.monsterid != other.monsterid) {
            return false;
        }
        if (this.weaponid != other.weaponid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.MonsterweaponPK[ monsterid=" + monsterid + ", weaponid=" + weaponid + " ]";
    }
}
