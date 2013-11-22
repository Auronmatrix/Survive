/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dao.service.SystemUserService;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.entities.SystemUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maria
 */
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

    private static final Logger logger = Logger.getLogger(SystemUserServiceImpl.class.getName());
    @Inject
    private SystemUserDao dao;
    @Inject
    private Mapper mapper;

    @Override
    public SystemUserDto save(SystemUserDto dto) {

        SystemUser entity = mapper.map(dto, SystemUser.class);
        dao.save(entity);
        return mapper.map(entity, SystemUserDto.class);


    }

    @Override
    public SystemUserDto update(SystemUserDto dto) {

        SystemUser entity = mapper.map(dto, SystemUser.class);
        dao.update(entity);
        return mapper.map(entity, SystemUserDto.class);

    }

    @Override
    public void delete(SystemUserDto dto) {

        dao.delete(mapper.map(dto, SystemUser.class));

    }

    @Override
    public SystemUserDto findById(Long id) {

        return mapper.map(dao.findById(id), SystemUserDto.class);

    }

    @Override
    public boolean exists(Long id) {
        throw new NoSuchMethodError();
    }

    public void setDao(SystemUserDao dao) {
        this.dao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SystemUserDto> findAll() {
        List<SystemUserDto> dtoList = new ArrayList<>();
        for (SystemUser o : dao.findAll()) {
            dtoList.add(this.mapper.map(o, SystemUserDto.class));
        }
        return dtoList;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
