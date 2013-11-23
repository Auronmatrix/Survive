/* ------------------------------------------------
 * Monster.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.entities;

import com.muni.fi.pa165.enums.MonsterClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity Monster represents one type of a monster.
 *
 *
 * @author Michal Vinkler
 */
@Entity
public class Monster implements Serializable {

    private static final long serialVersionUID = 10001L;
    /**
     * Id of this type of monster.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Class of a monster - represented by enumeration.
     */
    @Enumerated(EnumType.STRING)
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
    /**
     * List of all the weapon efficiencies bound to this monster.
     */
    @OneToMany(mappedBy = "monster")
    private List<MonsterWeapon> efficiencies = new ArrayList<>();
    /**
     * List of all locations where this type of a monster was spotted.
     */
    @OneToMany(mappedBy = "monster")
    private List<MonsterArea> locations = new ArrayList<>();

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

    public List<MonsterWeapon> getEfficiencies() {
        return efficiencies;
    }

    public void setEfficiencies(List<MonsterWeapon> efficiencies) {
        this.efficiencies = efficiencies;
    }

    public List<MonsterArea> getLocations() {
        return locations;
    }

    public void setLocations(List<MonsterArea> locations) {
        this.locations = locations;
    }

    //Equals and hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Monster other = (Monster) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
