/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.dao.service.AreaService;
import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.entities.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Auron
 */
@Service
public class AreaServiceImpl implements AreaService {

    private static final Logger logger = Logger.getLogger(AreaServiceImpl.class.getName());
    @Inject
    private AreaDao dao;
    @Inject
    private Mapper mapper;

    @Override
    @Transactional
    public AreaDto save(AreaDto dto) {
       
            Area entity = mapper.map(dto, Area.class);
            dao.save(entity);
            return mapper.map(entity, AreaDto.class);

       
    }

    @Override
    @Transactional
    public AreaDto update(AreaDto dto) {
        
            Area entity = mapper.map(dto, Area.class);
            dao.update(entity);
            return mapper.map(entity, AreaDto.class);
       
    }

    @Override
    @Transactional
    public void delete(AreaDto dto) {
       
            dao.delete(mapper.map(dto, Area.class));
       
    }

    @Override
    @Transactional
    public AreaDto findById(Long id) {
        
            return mapper.map(dao.findById(id), AreaDto.class);
       
    }

    public void setDao(AreaDao dao) {
        this.dao = dao;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    
    @Override
      public List<AreaDto> findAll()
      { 
//          List<Area> daoList = dao.findAll();
          List<AreaDto> dtoList = new ArrayList<>();
   //       for(Area area : daoList)
   //       {
    //          dtoList.add(this.mapper.map(area, AreaDto.class));              
    //      }
          return dtoList;
      }
}