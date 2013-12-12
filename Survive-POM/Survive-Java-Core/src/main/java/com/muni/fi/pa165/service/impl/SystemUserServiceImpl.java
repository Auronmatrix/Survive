package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.entities.SystemUser;
import com.muni.fi.pa165.service.SystemUserService;
import java.util.ArrayList;
import java.util.List;
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
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

    private static final Logger logger = Logger.getLogger(SystemUserServiceImpl.class.getName());
    @Inject
    private SystemUserDao systemUserDao;
    @Inject
    private Mapper mapper;

    @Override
    public SystemUserDto save(SystemUserDto dto) {

        SystemUser entity = mapper.map(dto, SystemUser.class);
        systemUserDao.save(entity);
        return mapper.map(entity, SystemUserDto.class);


    }

    @Override
    public SystemUserDto update(SystemUserDto dto) {

        SystemUser entity = mapper.map(dto, SystemUser.class);
        systemUserDao.update(entity);
        return mapper.map(entity, SystemUserDto.class);

    }

    @Override
    public void delete(SystemUserDto dto) {

        systemUserDao.delete(mapper.map(dto, SystemUser.class));

    }

    @Override
    public SystemUserDto findById(Long id) {

        return mapper.map(systemUserDao.findById(id), SystemUserDto.class);

    }

    @Override
    public boolean exists(Long id) {
        throw new NoSuchMethodError();
    }

    /**
     *
     * @param dao
     */
    public void setDao(SystemUserDao dao) {
        this.systemUserDao = dao;
    }

    /**
     *
     * @param mapper
     */
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     *
     * @return
     */
    @Override
    public List<SystemUserDto> findAll() {
        List<SystemUserDto> dtoList = new ArrayList<>();
        for (SystemUser o : systemUserDao.findAll()) {
            dtoList.add(this.mapper.map(o, SystemUserDto.class));
        }
        return dtoList;
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        systemUserDao.delete(id);
    }
}
