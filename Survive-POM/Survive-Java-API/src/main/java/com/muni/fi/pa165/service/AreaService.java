package com.muni.fi.pa165.service;

import com.muni.fi.pa165.dto.AreaDto;
import java.util.List;

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

    public void delete(Long id);

    /**
     * Finds WeaponDto by id
     *
     * @param id ID of the weapon
     * @return Weapon object of type WeaponDto
     */
    public AreaDto findById(Long id);

    public List<AreaDto> findAll();
}
