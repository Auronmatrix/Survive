package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.Weapon;
import com.muni.fi.pa165.service.WeaponService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michal Vinkler
 */
@Service
public class WeaponServiceImpl implements WeaponService {

    @Inject
    private WeaponDao weaponDao;
    @Inject
    private Mapper mapper;

    @Override
    public WeaponDto save(WeaponDto dto) {
        Weapon entity = mapper.map(dto, Weapon.class);
        weaponDao.save(entity);
        return mapper.map(entity, WeaponDto.class);
    }

    @Override
    public WeaponDto update(WeaponDto dto) {
        Weapon entity = mapper.map(dto, Weapon.class);
        weaponDao.update(entity);
        return mapper.map(entity, WeaponDto.class);
    }


    @Override
    public WeaponDto findById(Long id) {
        return mapper.map(weaponDao.findById(id), WeaponDto.class);
    }


    public void setDao(WeaponDao dao) {
        this.weaponDao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<WeaponDto> findAll() {
        List<WeaponDto> dtoList = new ArrayList<>();
        for (Weapon o : weaponDao.findAll()) {
            dtoList.add(this.mapper.map(o, WeaponDto.class));
        }
        return dtoList;
    }

    @Override
    public void delete(Long id) {
        weaponDao.delete(id);
    }
}
