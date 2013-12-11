package com.muni.fi.pa165.service;

import com.muni.fi.pa165.dto.SystemUserDto;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface SystemUserService {
    /**
     * 
     * @throws IllegalArgumentException when null is passed
     */

    boolean exists(Long id) throws IllegalArgumentException;
/**
     * Saves SystemUserDto
     *
     * @param dto object of type SystemUserDto
     */
    public SystemUserDto save(SystemUserDto dto);

    /**
     * Updates SystemUserDto
     *
     * @param dto object of type SystemUserDto
     */
    public SystemUserDto update(SystemUserDto dto);

    /**
     * Deletes SystemUserDto
     *
     * @param dto object of type SystemUserDto
     */
    public void delete(SystemUserDto dto);

    /**
     * Finds SystemUserDto by id
     *
     * @param id ID of the systemUser
     * @return SystemUser object of type SystemUserDto
     */
    public SystemUserDto findById(Long id);

    public List<SystemUserDto> findAll();

    public void delete(Long id);
}
