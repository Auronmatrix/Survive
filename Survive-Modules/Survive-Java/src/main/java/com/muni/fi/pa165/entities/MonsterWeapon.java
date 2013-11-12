/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity MonsterWeapon represents a connection between {@link Monster} and {@link Weapon}. This is many-to-many
 * relationship.
 *
 * @author Michal Vinkler
 */
@Entity
public class MonsterWeapon implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private static final long serialVersionUID = 10002L;
    //Entity Attributes
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "MONSTERID", referencedColumnName = "id")
    private Monster monster;
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "WEAPONID", referencedColumnName = "id")
    private Weapon weapon;
    private double hitRate;
    private double damage;
    private double efficiency;
    private String description;

    //Getters and setters
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  

    //Entity methods
    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public void setId(Long id) {
    //        this.id = id;
    //    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.monster);
        hash = 71 * hash + Objects.hashCode(this.weapon);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.hitRate) ^ (Double.doubleToLongBits(this.hitRate) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.damage) ^ (Double.doubleToLongBits(this.damage) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.efficiency) ^ (Double.doubleToLongBits(this.efficiency) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MonsterWeapon other = (MonsterWeapon) obj;
        if (!Objects.equals(this.monster, other.monster)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hitRate) != Double.doubleToLongBits(other.hitRate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.damage) != Double.doubleToLongBits(other.damage)) {
            return false;
        }
        if (Double.doubleToLongBits(this.efficiency) != Double.doubleToLongBits(other.efficiency)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
}
