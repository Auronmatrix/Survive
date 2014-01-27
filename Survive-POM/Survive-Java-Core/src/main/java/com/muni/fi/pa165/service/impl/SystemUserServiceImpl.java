package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.UserDao;
import com.muni.fi.pa165.dto.UsersDto;
import com.muni.fi.pa165.entities.Users;
import com.muni.fi.pa165.service.UsersService;
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
public class UsersServiceImpl implements UsersService {

    private static final Logger logger = Logger.getLogger(UsersServiceImpl.class.getName());
    @Inject
    private UserDao systemUserDao;
    @Inject
    private Mapper mapper;

    @Override
    public UsersDto save(UsersDto dto) {

        Users entity = mapper.map(dto, Users.class);
        systemUserDao.save(entity);
        return mapper.map(entity, UsersDto.class);

    }

    @Override
    public UsersDto update(UsersDto dto) {

        Users entity = mapper.map(dto, Users.class);
        systemUserDao.update(entity);
        return mapper.map(entity, UsersDto.class);

    }

    @Override
    public void delete(UsersDto dto) {

        systemUserDao.delete(mapper.map(dto, Users.class));

    }

    @Override
    public UsersDto findById(Long id) {

        return mapper.map(systemUserDao.findById(id), UsersDto.class);

    }

    @Override
    public boolean exists(Long id) {
        throw new NoSuchMethodError();
    }

    /**
     *
     * @param dao
     */
    public void setDao(UserDao dao) {
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
    public List<UsersDto> findAll() {
        List<UsersDto> dtoList = new ArrayList<>();
        for (Users o : systemUserDao.findAll()) {
            dtoList.add(this.mapper.map(o, UsersDto.class));
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
