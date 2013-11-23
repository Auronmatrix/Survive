/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data transfer object for the {@link Weapon}.
 *
 * @author Michal Vinkler
 */
public class WeaponDto {

    private Long id;
    private String name;
    private WeaponType weaponType;
    private WeaponClass weaponClass;
    private Integer range;
    private Double caliber;
    private Integer rounds;
    private String description;
    // private List<MonsterWeaponDto> efficiencies = new ArrayList<>();

    public Double getCaliber() {
        return caliber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long weaponId) {
        this.id = weaponId;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public WeaponClass getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(WeaponClass weaponClass) {
        this.weaponClass = weaponClass;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<MonsterWeaponDto> getEfficiencies() {
//        return efficiencies;
//    }
//
//    public void setEfficiencies(List<MonsterWeaponDto> efficiencies) {
//        this.efficiencies = efficiencies;
//    }
    
}
