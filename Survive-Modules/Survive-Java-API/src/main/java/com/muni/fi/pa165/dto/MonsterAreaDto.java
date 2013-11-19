/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.Monster;
import java.util.Objects;

/**
 *
 * @author irina
 */
public class MonsterAreaDto {
    private Monster monster;
    private Area area;
    private int monsterQuantity;
    

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getMonsterQuantity() {
        return monsterQuantity;
    }

    public void setMonsterQuantity(int monsterQuantity) {
        this.monsterQuantity = monsterQuantity;
    }
    
 @Override
    public int hashCode() {
        int hash = 3;
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
        final MonsterAreaDto other = (MonsterAreaDto) obj;
        if (!Objects.equals(this.monster, other.monster)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (this.monsterQuantity != other.monsterQuantity) {
            return false;
        }
        return true;
    }
}
