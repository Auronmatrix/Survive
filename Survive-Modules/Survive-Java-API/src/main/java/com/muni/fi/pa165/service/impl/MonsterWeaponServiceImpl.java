/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.service.MonsterService;
import com.muni.fi.pa165.service.MonsterWeaponService;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.entities.Weapon;
import javax.inject.Inject;
import org.dozer.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author irina
 */
@Service
public class MonsterWeaponServiceImpl implements MonsterWeaponService {

    //private static final Logger logger = Logger.getLogger(MonsterServiceImpl.class.getName());
    @Inject
    private MonsterWeaponDao monsterWeaponDao;
    @Inject
    private Mapper mapper;
    @Inject
    private MonsterService service;

    @Override
    public MonsterWeaponDto save(MonsterWeaponDto dto) {
        MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
        monsterWeaponDao.save(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }

    @Override
    public MonsterWeaponDto update(MonsterWeaponDto dto) {

        MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
        monsterWeaponDao.update(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }

    @Override
    public void delete(MonsterWeaponDto dto) {

        monsterWeaponDao.delete(mapper.map(dto, MonsterWeapon.class));

    }

    public void setDao(MonsterWeaponDao dao) {
        this.monsterWeaponDao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MonsterWeaponDto> findByMonsterId(Long id) {
        //     Monster monster = mapper.map(service.findById(id), Monster.class);
        List<MonsterWeapon> mw = monsterWeaponDao.getMonsterWeaponsForThisMonsterType(id);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : mw) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findByWeaponId(Long id) {
        WeaponServiceImpl mn = new WeaponServiceImpl();
        Weapon weapon = mapper.map(mn.findById(id), Weapon.class);
        List<MonsterWeapon> mw = monsterWeaponDao.getMonsterWeaponsForThisWeaponType(weapon);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : mw) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findAll() {
        List<MonsterWeaponDto> dtoList = new ArrayList<>();
        for (MonsterWeapon o : monsterWeaponDao.findAll()) {
            dtoList.add(this.mapper.map(o, MonsterWeaponDto.class));
        }
        return dtoList;
    }

    @Override
    public void delete(Long id) {
        monsterWeaponDao.delete(id);
    }
}