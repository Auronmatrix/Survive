/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "MONSTERWEAPON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monsterweapon.findAll", query = "SELECT m FROM Monsterweapon m"),
    @NamedQuery(name = "Monsterweapon.findByMonsterid", query = "SELECT m FROM Monsterweapon m WHERE m.monsterweaponPK.monsterid = :monsterid"),
    @NamedQuery(name = "Monsterweapon.findByWeaponid", query = "SELECT m FROM Monsterweapon m WHERE m.monsterweaponPK.weaponid = :weaponid"),
    @NamedQuery(name = "Monsterweapon.findByHitrate", query = "SELECT m FROM Monsterweapon m WHERE m.hitrate = :hitrate"),
    @NamedQuery(name = "Monsterweapon.findByEfficiency", query = "SELECT m FROM Monsterweapon m WHERE m.efficiency = :efficiency"),
    @NamedQuery(name = "Monsterweapon.findByDamage", query = "SELECT m FROM Monsterweapon m WHERE m.damage = :damage"),
    @NamedQuery(name = "Monsterweapon.findByDescription", query = "SELECT m FROM Monsterweapon m WHERE m.description = :description")})
public class Monsterweapon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonsterweaponPK monsterweaponPK;
    @Column(name = "HITRATE")
    private Integer hitrate;
    @Column(name = "EFFICIENCY")
    private Integer efficiency;
    @Column(name = "DAMAGE")
    private Integer damage;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "WEAPONID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Weapon weapon;
    @JoinColumn(name = "MONSTERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monster monster;

    public Monsterweapon() {
    }

    public Monsterweapon(MonsterweaponPK monsterweaponPK) {
        this.monsterweaponPK = monsterweaponPK;
    }

    public Monsterweapon(long monsterid, long weaponid) {
        this.monsterweaponPK = new MonsterweaponPK(monsterid, weaponid);
    }

    public MonsterweaponPK getMonsterweaponPK() {
        return monsterweaponPK;
    }

    public void setMonsterweaponPK(MonsterweaponPK monsterweaponPK) {
        this.monsterweaponPK = monsterweaponPK;
    }

    public Integer getHitrate() {
        return hitrate;
    }

    public void setHitrate(Integer hitrate) {
        this.hitrate = hitrate;
    }

    public Integer getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monsterweaponPK != null ? monsterweaponPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monsterweapon)) {
            return false;
        }
        Monsterweapon other = (Monsterweapon) object;
        if ((this.monsterweaponPK == null && other.monsterweaponPK != null) || (this.monsterweaponPK != null && !this.monsterweaponPK.equals(other.monsterweaponPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.Monsterweapon[ monsterweaponPK=" + monsterweaponPK + " ]";
    }
    
}
