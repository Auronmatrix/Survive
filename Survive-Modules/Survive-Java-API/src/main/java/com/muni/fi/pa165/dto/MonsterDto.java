/* ------------------------------------------------
 * MonsterDto.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.entities.*;
import com.muni.fi.pa165.enums.MonsterClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data transfer object for the {@link Monster}.
 *
 *
 * @author Michal Vinkler
 */
public class MonsterDto {

    private Long id;
    private MonsterClass monsterClass;
    private String name;
    private String description;
    private Double height;
    private Double weight;
    private Double agility;
    private Double strength;
    private Double stamina;
    private Double dangerLevel;
    private String imagePath;
//    private List<MonsterWeaponDto> efficiencies = new ArrayList<>();
//    private List<MonsterAreaDto> locations = new ArrayList<>();

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long monsterId) {
        this.id = monsterId;
    }

    public MonsterClass getMonsterClass() {
        return monsterClass;
    }

    public void setMonsterClass(MonsterClass monsterClass) {
        this.monsterClass = monsterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAgility() {
        return agility;
    }

    public void setAgility(Double agility) {
        this.agility = agility;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public Double getStamina() {
        return stamina;
    }

    public void setStamina(Double stamina) {
        this.stamina = stamina;
    }

    public Double getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Double dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    public List<MonsterWeaponDto> getEfficiencies() {
//        return efficiencies;
//    }
//
//    public void setEfficiencies(List<MonsterWeaponDto> efficiencies) {
//        this.efficiencies = efficiencies;
//    }
//
//    public List<MonsterAreaDto> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<MonsterAreaDto> locations) {
//        this.locations = locations;
//    }

}
