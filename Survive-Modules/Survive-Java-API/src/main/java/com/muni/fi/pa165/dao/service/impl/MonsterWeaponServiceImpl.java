/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dao.service.MonsterWeaponService;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.entities.Weapon;
import javax.inject.Inject;
import org.dozer.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author irina
 */

@Service
public class MonsterWeaponServiceImpl implements MonsterWeaponService {

    //private static final Logger logger = Logger.getLogger(MonsterServiceImpl.class.getName());
    @Inject
    private MonsterWeaponDao dao;
    @Inject
    private Mapper mapper;

    @Override
    @Transactional
    public MonsterWeaponDto save(MonsterWeaponDto dto) {
            MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
            dao.save(entity);
            return mapper.map(entity, MonsterWeaponDto.class);

    }

    @Override
    @Transactional
    public MonsterWeaponDto update(MonsterWeaponDto dto) {
       
            MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
            dao.update(entity);
            return mapper.map(entity, MonsterWeaponDto.class);
       
    }

    @Override
    @Transactional
    public void delete(MonsterWeaponDto dto) {
      
            dao.delete(mapper.map(dto, MonsterWeapon.class));
       
    }

    public void setDao(MonsterWeaponDao dao) {
        this.dao = dao;
    }
    
      public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MonsterWeaponDto> findByMonsterId(Long id) {
        MonsterServiceImpl mn = new MonsterServiceImpl();
        Monster monster = mapper.map (mn.findById(id),Monster.class);
        List<MonsterWeapon> mw = dao.getMonsterWeaponsForThisMonsterType(monster);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : mw){
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findByWeaponId(Long id) {
       WeaponServiceImpl mn = new WeaponServiceImpl();
        Weapon weapon = mapper.map (mn.findById(id),Weapon.class);
        List<MonsterWeapon> mw = dao.getMonsterWeaponsForThisWeaponType(weapon);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : mw){
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }
}