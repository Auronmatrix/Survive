package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.MonsterWeaponPkDto;
import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.entities.MonsterWeaponPK;
import com.muni.fi.pa165.service.MonsterWeaponService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.dozer.Mapper;
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

    /**
     *
     * @param monsterId
     * @param weaponId
     * @return
     */
    @Override
    public MonsterWeaponPkDto getCompositeKey(Long monsterId, Long weaponId) {
        return new MonsterWeaponPkDto(monsterId, weaponId);
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public MonsterWeaponDto save(MonsterWeaponDto dto) {
        MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
        MonsterWeaponPK pk = mapper.map(new MonsterWeaponPkDto(dto.getMonster().getId(), dto.getWeapon().getId()), MonsterWeaponPK.class);
        entity.setMonsterweaponPK(pk);
        entity = monsterWeaponDao.save(entity);
        return mapper.map(entity, MonsterWeaponDto.class);
    }

    @Override
    public MonsterWeaponDto update(MonsterWeaponDto dto) {

        MonsterWeapon entity = mapper.map(dto, MonsterWeapon.class);
        MonsterWeaponPK pk = mapper.map(new MonsterWeaponPkDto(dto.getMonster().getId(), dto.getWeapon().getId()), MonsterWeaponPK.class);
        entity.setMonsterweaponPK(pk);
        monsterWeaponDao.update(entity);
        return mapper.map(entity, MonsterWeaponDto.class);
    }

    /**
     *
     * @param dto
     */
    public void delete(MonsterWeaponDto dto) {

        monsterWeaponDao.delete(mapper.map(dto, MonsterWeapon.class));

    }

    /**
     *
     * @param dao
     */
    public void setDao(MonsterWeaponDao dao) {
        this.monsterWeaponDao = dao;
    }

    /**
     *
     * @param mapper
     */
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MonsterWeaponDto> findByMonsterId(Long id) {
        //     Monster monster = mapper.map(service.findById(id), Monster.class);
        List<MonsterWeapon> mw = monsterWeaponDao.getByMonsterId(id);
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : mw) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterWeaponDto> findByWeaponId(Long id) {
        List<MonsterWeaponDto> result = new ArrayList<>();
        for (MonsterWeapon monsterW : monsterWeaponDao.getByWeaponId(id)) {
            result.add(mapper.map(monsterW, MonsterWeaponDto.class));
        }
        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public List<MonsterWeaponDto> findAll() {
        List<MonsterWeaponDto> dtoList = new ArrayList<>();
        for (MonsterWeapon o : monsterWeaponDao.findAll()) {
            MonsterWeaponDto dto = this.mapper.map(o, MonsterWeaponDto.class);

            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public void delete(MonsterWeaponPkDto id) {
        MonsterWeaponPK pk = mapper.map(id, MonsterWeaponPK.class);
        monsterWeaponDao.delete(pk);
    }

    /**
     *
     * @param monsterId
     * @param weaponId
     * @return
     */
    @Override
    public MonsterWeaponDto findById(Long monsterId, Long weaponId) {

        MonsterWeaponPkDto pk = new MonsterWeaponPkDto(monsterId, weaponId);
        MonsterWeapon entity = monsterWeaponDao.findById(mapper.map(pk, MonsterWeaponPK.class));
        return mapper.map(entity, MonsterWeaponDto.class);
    }


}