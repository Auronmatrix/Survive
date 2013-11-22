/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dao.service.WeaponService;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.Weapon;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Michal Vinkler
 */
@Transactional
public class WeaponServiceImpl implements WeaponService {

    @Inject
    private WeaponDao dao;
    @Inject
    private Mapper mapper;

    @Override
    @Transactional
    public WeaponDto save(WeaponDto dto) {
        Weapon entity = mapper.map(dto, Weapon.class);
        dao.save(entity);
        return mapper.map(entity, WeaponDto.class);
    }

    @Override
    @Transactional
    public WeaponDto update(WeaponDto dto) {
        Weapon entity = mapper.map(dto, Weapon.class);
        dao.update(entity);
        return mapper.map(entity, WeaponDto.class);
    }

    @Override
    @Transactional
    public void delete(WeaponDto dto) {
        dao.delete(mapper.map(dto, Weapon.class));
    }

    @Override
    @Transactional
    public WeaponDto findById(Long id) {
        return mapper.map(dao.findById(id), WeaponDto.class);
    }

    @Override
    public boolean checkAvailable(String name) {
        return dao.checkAvailable(name);
    }

    public void setDao(WeaponDao dao) {
        this.dao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<WeaponDto> findAll() {
        List<WeaponDto> dtoList = new ArrayList<>();
        for (Weapon o : dao.findAll()) {
            dtoList.add(this.mapper.map(o, WeaponDto.class));
        }
        return dtoList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
