package com.muni.fi.pa165.service;

import com.muni.fi.pa165.dto.UserDto;
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
     * Saves UserDto
     *
     * @param dto object of type UserDto
     */
    public UserDto save(UserDto dto);

    /**
     * Updates UserDto
     *
     * @param dto object of type UserDto
     */
    public UserDto update(UserDto dto);

    /**
     * Deletes UserDto
     *
     * @param dto object of type UserDto
     */
    public void delete(UserDto dto);

    /**
     * Finds UserDto by id
     *
     * @param id ID of the systemUser
     * @return SystemUser object of type UserDto
     */
    public UserDto findById(Long id);

    public List<UserDto> findAll();

    public void delete(Long id);
}
