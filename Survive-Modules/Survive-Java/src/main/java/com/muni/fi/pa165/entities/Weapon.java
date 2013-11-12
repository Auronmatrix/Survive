/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
@Entity
public class Weapon implements Serializable {

    private static final long serialVersionUID = 1L;
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private WeaponType weaponType;
    private WeaponClass weaponClass;
    private Integer range;
    private Double caliber;
    private Integer rounds;
    private String description;
    @OneToMany(mappedBy = "weapon",fetch = FetchType.LAZY)
    private List<MonsterWeapon> efficiencies = new ArrayList<MonsterWeapon>();

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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

    public List<MonsterWeapon> getEfficiencies() {
        return efficiencies;
    }

    public void setEfficiencies(List<MonsterWeapon> efficiencies) {
        this.efficiencies = efficiencies;
    }

    public Double getCaliber() {
        return caliber;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Weapon other = (Weapon) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Weapon{" + "weaponId=" + id + ", name=" + name + ", weaponType=" + weaponType + ", weaponClass=" + weaponClass + ", range=" + range + ", caliber=" + caliber + ", rounds=" + rounds + ", description=" + description + ", efficiencies=" + efficiencies + '}';
    }
}
