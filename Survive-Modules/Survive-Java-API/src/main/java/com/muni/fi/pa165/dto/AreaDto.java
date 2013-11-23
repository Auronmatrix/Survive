/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.enums.TerrainType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Enumerated;

/**
 *
 * @author irina
 */
public class AreaDto implements Serializable {

    private Long id;
    private String name;
    private TerrainType terrain;
    private String description;
    //private List<MonsterAreaDto> locations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//     public List<MonsterAreaDto> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<MonsterAreaDto> efficiencies) {
//        this.locations = locations;
//    }
  
}
