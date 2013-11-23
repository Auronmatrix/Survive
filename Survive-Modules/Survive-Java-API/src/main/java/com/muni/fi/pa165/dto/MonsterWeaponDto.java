/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Weapon;
import java.util.Objects;

/**
 *
 * @author irina
 */
public class MonsterWeaponDto {

    private Long monsterID;
    private Long weaponID;
    private double hitRate;
    private double damage;
    private double efficiency;
    private String description;

    public Long getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(Long monsterID) {
        this.monsterID = monsterID;
    }

    public Long getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(Long weaponID) {
        this.weaponID = weaponID;
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

}
