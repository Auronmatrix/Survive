/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service;

import com.muni.fi.pa165.dto.MonsterAreaDto;
import java.util.List;



/**
 *
 * @author irina
 */
public interface MonsterAreaService {
  
    public MonsterAreaDto save(MonsterAreaDto dto);
    
	/**
	 * Updates MonsterAreaDto
         * 
	 * @param dto object of type MonsterAreaDto
	 */
    public MonsterAreaDto update(MonsterAreaDto dto);
	
    /**
	 * Deletes MonsterAreaDto
         * 
	 * @param dto object of type MonsterAreaDto
	 */
    public void delete(MonsterAreaDto dto);
    
	/**
	 * Finds MonsterAreaDto by areaId
         * 
	 * @param id ID of the area
	 * @return list object of type MonsterAreaDto
	 */
   
    public List<MonsterAreaDto> findByAreaId(Long id);
    /**
	 * Finds MonsterAreaDto by monster
         * 
	 * @param id ID of the monster
	 * @return list object of type MonsterAreaDto
	 */
    public List<MonsterAreaDto> findByMonsterId(Long id);
    
      public List<MonsterAreaDto> findAll();
      
       public void delete(Long id);
}

    
