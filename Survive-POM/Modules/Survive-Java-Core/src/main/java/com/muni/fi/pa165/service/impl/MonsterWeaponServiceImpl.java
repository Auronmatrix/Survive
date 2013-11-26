/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.service.MonsterWeaponService;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.MonsterWeaponPkDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Monsterweapon;
import com.muni.fi.pa165.entities.MonsterweaponPK;
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
  

    @Override
    public MonsterWeaponDto save(MonsterWeaponDto dto, MonsterDto monster, WeaponDto weapon ) {
        
//        dto.setMonster(mapper.map(monster, Monster.class));
//        dto.setWeapon(mapper.map(weapon, Weapon.class));
//        dto.setId(new MonsterweaponPK(dto.getMonster().getId(), dto.getWeapon().getId()));
        
        Monsterweapon entity = mapper.map(dto, Monsterweapon.class);
        monsterWeaponDao.save(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }
    
    public MonsterWeaponPkDto getCompositeKey(Long monsterId, Long weaponId)
    {
        MonsterWeaponPkDto dto = new MonsterWeaponPkDto();
        dto.setMonsterId(monsterId);
        dto.setWeaponId(weaponId);       
        return dto;
    }
    
     @Override
    public MonsterWeaponDto update(MonsterWeaponDto dto, MonsterDto monster, WeaponDto weapon ) {
        
//        dto.setMonster(mapper.map(monster, Monster.class));
//        dto.setWeapon(mapper.map(weapon, Weapon.class));
//        dto.setId(new MonsterweaponPK(dto.getMonster().getId(), dto.getWeapon().getId()));        
        Monsterweapon entity = mapper.map(dto, Monsterweapon.class);
        monsterWeaponDao.update(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }
    
    
    @Override
    public MonsterWeaponDto save(MonsterWeaponDto dto ) {
       
        Monsterweapon entity = mapper.map(dto, Monsterweapon.class);
        monsterWeaponDao.save(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }

    @Override
    public MonsterWeaponDto update(MonsterWeaponDto dto) {

        Monsterweapon entity = mapper.map(dto, Monsterweapon.class);
        monsterWeaponDao.update(entity);
        return mapper.map(entity, MonsterWeaponDto.class);

    }

   
    public void delete(MonsterWeaponDto dto) {

        monsterWeaponDao.delete(mapper.map(dto, Monsterweapon.class));

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
        List<Monsterweapon> mw = monsterWeaponDao.getByMonsterId(id);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (Monsterweapon monsterW : mw) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findByWeaponId(Long id) {
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (Monsterweapon monsterW : monsterWeaponDao.getByWeaponId(id)) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findAll() {
        List<MonsterWeaponDto> dtoList = new ArrayList<>();
        for (Monsterweapon o : monsterWeaponDao.findAll()) {
            dtoList.add(this.mapper.map(o, MonsterWeaponDto.class));
        }
        return dtoList;
    }

    @Override
    public void delete(MonsterWeaponPkDto id) {
        MonsterweaponPK pk = mapper.map(id, MonsterweaponPK.class);
        monsterWeaponDao.delete(pk);
    }
    
    @Override
    public MonsterWeaponDto findById(Long monsterId, Long weaponId)
    {
        MonsterweaponPK pk = new MonsterweaponPK(monsterId, weaponId);
        Monsterweapon entity = monsterWeaponDao.findById(pk);
        return mapper.map(entity, MonsterWeaponDto.class);
    }

    @Override
    public void delete(Long monsterId, Long weaponId) {
     MonsterWeaponPkDto pkDto = new MonsterWeaponPkDto();
     pkDto.setMonsterId(monsterId);
     pkDto.setWeaponId(weaponId);
     MonsterweaponPK pk = mapper.map(pkDto, MonsterweaponPK.class);
     monsterWeaponDao.delete(pk);
    }
}