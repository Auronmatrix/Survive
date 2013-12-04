/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.service.impl;

import com.muni.fi.pa165.dao.MonsterAreaDao;
import com.muni.fi.pa165.service.MonsterAreaService;
import com.muni.fi.pa165.dto.MonsterAreaDto;
import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.dto.MonsterAreaPkDto;
import com.muni.fi.pa165.entities.MonsterareaPK;
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
public class MonsterAreaServiceImpl implements MonsterAreaService {
    //private static final Logger logger = Logger.getLogger(MonsterServiceImpl.class.getName());

    @Inject
    private MonsterAreaDao monsterAreaDao;
    @Inject
    private Mapper mapper;

    @Override
    public MonsterAreaPkDto getCompositeKey(Long monsterId, Long areaId) {
        return new MonsterAreaPkDto(monsterId, areaId);      
    }

    @Override
    public MonsterAreaDto save(MonsterAreaDto dto) {
        Monsterarea entity = mapper.map(dto, Monsterarea.class);
        Long monster = dto.getMonster().getId();
        Long area = dto.getArea().getId();
        MonsterAreaPkDto dtoPk = new MonsterAreaPkDto(monster,area);
        MonsterareaPK pk = mapper.map(dtoPk, MonsterareaPK.class);
        entity.setMonsterareaPK(pk);
        entity = monsterAreaDao.save(entity);
        return mapper.map(entity, MonsterAreaDto.class);
    }

    @Override
    public MonsterAreaDto update(MonsterAreaDto dto) {

        Monsterarea entity = mapper.map(dto, Monsterarea.class);
        MonsterareaPK pk = mapper.map(new MonsterAreaPkDto(dto.getMonster().getId(), dto.getArea().getId()), MonsterareaPK.class);
        entity.setMonsterareaPK(pk);
        monsterAreaDao.update(entity);
        return mapper.map(entity, MonsterAreaDto.class);
    }

    public void delete(MonsterAreaDto dto) {

        monsterAreaDao.delete(mapper.map(dto, Monsterarea.class));

    }

    public void setDao(MonsterAreaDao dao) {
        this.monsterAreaDao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MonsterAreaDto> findByMonsterId(Long id) {
        //     Monster monster = mapper.map(service.findById(id), Monster.class);
        List<Monsterarea> mw = monsterAreaDao.getByMonsterId(id);
        List<MonsterAreaDto> result = new ArrayList<>();
        for (Monsterarea monsterW : mw) {
            result.add(mapper.map(monsterW, MonsterAreaDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterAreaDto> findByAreaId(Long id) {
        List<MonsterAreaDto> result = new ArrayList<>();
        for (Monsterarea monsterW : monsterAreaDao.getByAreaId(id)) {
            result.add(mapper.map(monsterW, MonsterAreaDto.class));
        }
        return result;
    }

    @Override
    public List<MonsterAreaDto> findAll() {
        List<MonsterAreaDto> dtoList = new ArrayList<>();
        for (Monsterarea o : monsterAreaDao.findAll()) {
            MonsterAreaDto dto = this.mapper.map(o, MonsterAreaDto.class);

            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public void delete(MonsterAreaPkDto id) {
        MonsterareaPK pk = mapper.map(id, MonsterareaPK.class);
        monsterAreaDao.delete(pk);
    }

    @Override
    public MonsterAreaDto findById(Long monsterId, Long areaId) {

        MonsterAreaPkDto pk = new MonsterAreaPkDto(monsterId, areaId);
        Monsterarea entity = monsterAreaDao.findById(mapper.map(pk, MonsterareaPK.class));
        return mapper.map(entity, MonsterAreaDto.class);
    }

    @Override
    public void delete(Long monsterId, Long areaId) {
        MonsterAreaPkDto pk = new MonsterAreaPkDto(monsterId, areaId);
        Monsterarea entity = monsterAreaDao.findById(mapper.map(pk, MonsterareaPK.class));
        monsterAreaDao.delete(entity);
    }
}
