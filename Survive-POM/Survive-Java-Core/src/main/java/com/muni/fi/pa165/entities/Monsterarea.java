package com.muni.fi.pa165.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Auron
 */
@Entity
@Table(name = "MONSTERAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monsterarea.findAll", query = "SELECT m FROM Monsterarea m"),
    @NamedQuery(name = "Monsterarea.findByMonsterquantity", query = "SELECT m FROM Monsterarea m WHERE m.monsterquantity = :monsterquantity"),
    @NamedQuery(name = "Monsterarea.findByMonsterId", query = "SELECT m FROM Monsterarea m WHERE m.monsterareaPK.monsterid = :monsterid"),
    @NamedQuery(name = "Monsterarea.findById", query = "SELECT m FROM Monsterarea m WHERE m.monsterareaPK = :monsterareaPK"),
    @NamedQuery(name = "Monsterarea.findByAreaId", query = "SELECT m FROM Monsterarea m WHERE m.monsterareaPK.areaid = :areaid")
})
public class Monsterarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonsterareaPK monsterareaPK;
    @Basic(optional = false)
    @Column(name = "MONSTERQUANTITY")
    private int monsterquantity;
    @JoinColumn(name = "MONSTERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Monster monster;
    @JoinColumn(name = "AREAID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Area area;

    public Monsterarea() {
    }

    public Monsterarea(MonsterareaPK monsterareaPK) {
        this.monsterareaPK = monsterareaPK;
    }

    public Monsterarea(MonsterareaPK monsterareaPK, int monsterquantity) {
        this.monsterareaPK = monsterareaPK;
        this.monsterquantity = monsterquantity;
    }

    public Monsterarea(long monsterId, long areaId) {
        this.monsterareaPK = new MonsterareaPK(monsterId, areaId);
    }

    public MonsterareaPK getMonsterareaPK() {
        return monsterareaPK;
    }

    public void setMonsterareaPK(MonsterareaPK monsterareaPK) {
        this.monsterareaPK = monsterareaPK;
    }

    public int getMonsterquantity() {
        return monsterquantity;
    }

    public void setMonsterquantity(int monsterquantity) {
        this.monsterquantity = monsterquantity;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monsterareaPK != null ? monsterareaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monsterarea)) {
            return false;
        }
        Monsterarea other = (Monsterarea) object;
        if ((this.monsterareaPK == null && other.monsterareaPK != null) || (this.monsterareaPK != null && !this.monsterareaPK.equals(other.monsterareaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.Monsterarea[ monsterareaPK=" + monsterareaPK + " ]";
    }
}
