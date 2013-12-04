/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.service;

import com.muni.fi.pa165.dto.MonsterAreaDto;
import com.muni.fi.pa165.dto.MonsterAreaPkDto;
import java.util.List;

/**
 *
 * @author irina
 */
public interface MonsterAreaService {

    public MonsterAreaDto save(MonsterAreaDto dto);
    
    public MonsterAreaPkDto getCompositeKey(Long keyone, Long keytwo);

    /**
     * Updates MonsterWeaponDto
     *
     * @param dto object of type MonsterWeaponDto
     */
    public MonsterAreaDto update(MonsterAreaDto dto);


    /**
     * Deletes MonsterWeaponDto
     *
     * @param dto object of type MonsterWeaponDto
     */
    public void delete(MonsterAreaPkDto dto);

    /**
     * Finds MonsterWeaponDto by monsterId
     *
     * @param id ID of the monster
     * @return list object of type MonsterWeaponDto
     */
    public List<MonsterAreaDto> findByMonsterId(Long id);

    /**
     * Finds MonsterWeaponDto by weaponId
     *
     * @param id ID of the weapon
     * @return list object of type MonsterWeaponDto
     */
    public List<MonsterAreaDto> findByAreaId(Long id);

    public List<MonsterAreaDto> findAll();

    public void delete(Long id, Long id2);
    
    public MonsterAreaDto findById(Long monsterId, Long areaId);
}
