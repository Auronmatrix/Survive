/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service;

import com.muni.fi.pa165.dao.jpa.SystemUserJpaDaoImpl;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.SystemUser;

/**
 *
 * @author Auron
 */
public interface SystemUserService {

   
    boolean exists(Long id) throws IllegalArgumentException;

        public SystemUserDto save(SystemUserDto dto);
    
	/**
	 * Updates WeaponDto
         * 
	 * @param weapon object of type WeaponDto
	 */
    public SystemUserDto update(SystemUserDto dto);
	
    /**
	 * Deletes WeaponDto
         * 
	 * @param weapon object of type WeaponDto
	 */
    public void delete(SystemUserDto dto);
    
    
	/**
	 * Finds WeaponDto by id
         * 
	 * @param id ID of the weapon
	 * @return Weapon object of type WeaponDto
	 */
   
    public SystemUserDto findById(Long id);
}
    
