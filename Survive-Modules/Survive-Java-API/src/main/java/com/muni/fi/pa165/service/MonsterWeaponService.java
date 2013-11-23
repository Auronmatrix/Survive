/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.service;

import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import java.util.List;



/**
 *
 * @author irina
 */
public interface MonsterWeaponService {

    public MonsterWeaponDto save(MonsterWeaponDto dto);
    
	/**
	 * Updates MonsterWeaponDto
         * 
	 * @param dto object of type MonsterWeaponDto
	 */
    public MonsterWeaponDto update(MonsterWeaponDto dto);
	
    /**
	 * Deletes MonsterWeaponDto
         * 
	 * @param dto object of type MonsterWeaponDto
	 */
    public void delete(MonsterWeaponDto dto);
    
	/**
	 * Finds MonsterWeaponDto by monsterId
         * 
	 * @param id ID of the monster
	 * @return list object of type MonsterWeaponDto
	 */
   
    public List<MonsterWeaponDto> findByMonsterId(Long id);
    /**
	 * Finds MonsterWeaponDto by weaponId
         * 
	 * @param id ID of the weapon
	 * @return list object of type MonsterWeaponDto
	 */
    public List<MonsterWeaponDto> findByWeaponId(Long id);
    
      public List<MonsterWeaponDto> findAll();
      
       public void delete(Long id);
}
