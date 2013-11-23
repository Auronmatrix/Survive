/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import java.util.Objects;

/**
 *
 * @author irina
 */
public class MonsterAreaDto {

    private Long monsterID;
    private Long areaID;
    private int monsterQuantity;

    public Long getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(Long monsterID) {
        this.monsterID = monsterID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
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
}
