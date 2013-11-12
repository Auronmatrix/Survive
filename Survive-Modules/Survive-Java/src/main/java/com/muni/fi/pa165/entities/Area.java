/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import com.muni.fi.pa165.enums.TerrainType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Aubrey Oosthuizen
 */
@Entity
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    //Entity attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
     * Cartographic grid name e.g. Block BX, Row 26 would be BX26
     */
    
    private String name;
    @Enumerated(EnumType.STRING)
    private TerrainType terrain;
    private String description;
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    private List<MonsterArea> locations = new ArrayList<>();

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Entity methods
    //Interface methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MonsterArea> getLocations() {
        return locations;
    }

    public void setLocations(List<MonsterArea> locations) {
        this.locations = locations;
    }

    //Equals functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Area other = (Area) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
