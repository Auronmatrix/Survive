/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service;

import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.entities.Area;

/**
 *
 * @author Auron
 */
public interface AreaService {



  
    public AreaDto save(AreaDto dto);
    
	/**
	 * Updates WeaponDto
         * 
	 * @param weapon object of type WeaponDto
	 */
    public AreaDto update(AreaDto dto);
	
    /**
	 * Deletes WeaponDto
         * 
	 * @param weapon object of type WeaponDto
	 */
    public void delete(AreaDto dto);
    
    
	/**
	 * Finds WeaponDto by id
         * 
	 * @param id ID of the weapon
	 * @return Weapon object of type WeaponDto
	 */
   
    public AreaDto findById(Long id);
}