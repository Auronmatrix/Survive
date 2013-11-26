/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import com.muni.fi.pa165.entities.Weapon;
import java.util.Objects;

/**
 *
 * @author irina
 */
public class MonsterWeaponDto {

 
    private Monster monster;
    private Weapon weapon;
    private Integer hitRate;
    private Integer damage;
    private Integer efficiency;
    private String description;
    private MonsterweaponPK id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MonsterweaponPK getId() {
        return id;
    }

    public void setId(MonsterweaponPK id) {
        this.id = id;
    }
    
    
    


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

    
   

    public Integer getHitRate() {
        return hitRate;
    }

    public void setHitRate(Integer hitRate) {
        this.hitRate = hitRate;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

 
    public Integer getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.monster);
        hash = 47 * hash + Objects.hashCode(this.weapon);
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
        final MonsterWeaponDto other = (MonsterWeaponDto) obj;
        if (!Objects.equals(this.monster, other.monster)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        return true;
    }

    
    
}
