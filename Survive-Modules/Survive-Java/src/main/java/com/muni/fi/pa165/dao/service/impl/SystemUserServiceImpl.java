/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dao.service.SystemUserService;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.entities.SystemUser;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maria
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    private static final Logger logger = Logger.getLogger(SystemUserServiceImpl.class.getName());
    @Inject
    private SystemUserDao dao;
    @Inject
    private Mapper mapper;

    @Override
    @Transactional
    public SystemUserDto save(SystemUserDto dto) {
       
            SystemUser entity = mapper.map(dto, SystemUser.class);
            dao.save(entity);
            return mapper.map(entity, SystemUserDto.class);

        
    }

    @Override
    @Transactional
    public SystemUserDto update(SystemUserDto dto) {
        
          SystemUser entity = mapper.map(dto, SystemUser.class);
            dao.update(entity);
            return mapper.map(entity, SystemUserDto.class);
       
    }

    @Override
    @Transactional
    public void delete(SystemUserDto dto) {
       
            dao.delete(mapper.map(dto, SystemUser.class));
        
    }

    @Override
    @Transactional
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
}
