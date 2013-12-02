/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

/**
 *
 * @author Auron
 */
public class MonsterWeaponPkDto {
    
    private Long monsterId;
    private Long weaponId;
    
    public MonsterWeaponPkDto()
    {
        
    }
    
    
    public MonsterWeaponPkDto(Long monsterId, Long weaponId)
    {
        this.monsterId = monsterId;
        this.weaponId = weaponId;
    }

    public Long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Long monsterId) {
        this.monsterId = monsterId;
    }

    public Long getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Long weaponId) {
        this.weaponId = weaponId;
    }
    
    
    
}
