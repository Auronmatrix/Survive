/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.service.MonsterService;
import com.muni.fi.pa165.dao.MonsterDao;
import com.muni.fi.pa165.dto.MonsterDto;

import com.muni.fi.pa165.entities.Monster;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Auron
 */
@Service
public class MonsterServiceImpl implements MonsterService {

    //private static final Logger logger = Logger.getLogger(MonsterServiceImpl.class.getName());
    @Inject
    private MonsterDao dao;
    @Inject
    private Mapper mapper;

    @Override
    public MonsterDto save(MonsterDto dto) {
        Monster entity = mapper.map(dto, Monster.class);
        entity = dao.save(entity);
        return mapper.map(entity, MonsterDto.class);

    }

    @Override
    public MonsterDto update(MonsterDto dto) {

        Monster entity = mapper.map(dto, Monster.class);
        dao.update(entity);
        return mapper.map(entity, MonsterDto.class);

    }

    @Override
    public void delete(MonsterDto dto) {

        dao.delete(mapper.map(dto, Monster.class));

    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public MonsterDto findById(Long id) {

        return mapper.map(dao.findById(id), MonsterDto.class);

    }

    public void setDao(MonsterDao dao) {
        this.dao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MonsterDto> findAll() {
        List<MonsterDto> dtoList = new ArrayList<>();
        for (Monster o : dao.findAll()) {
            dtoList.add(this.mapper.map(o, MonsterDto.class));
        }
        return dtoList;
    }
}