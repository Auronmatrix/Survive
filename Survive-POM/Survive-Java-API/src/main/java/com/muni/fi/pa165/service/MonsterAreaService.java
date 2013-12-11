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
    public void delete(MonsterAreaPkDto dto);

    /**
     * Finds MonsterAreaDto by monsterId
     *
     * @param id ID of the monster
     * @return list object of type MonsterAreaDto
     */
    public List<MonsterAreaDto> findByMonsterId(Long id);

    /**
     * Finds MonsterAreaDto by areaId
     *
     * @param id ID of the area
     * @return list object of type MonsterAreaDto
     */
    public List<MonsterAreaDto> findByAreaId(Long id);

    public List<MonsterAreaDto> findAll();

   
    
    public MonsterAreaDto findById(Long monsterId, Long areaId);
}
