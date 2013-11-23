/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.service.impl.MonsterServiceImpl;
import com.muni.fi.pa165.dao.MonsterDao;
import com.muni.fi.pa165.service.AbstractServiceIntegrationTest;
import com.muni.fi.pa165.dto.MonsterAreaDto;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.enums.MonsterClass;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 *
 * @author Auron
 */
public class MonsterServiceImplTest   extends AbstractServiceIntegrationTest {
    
    @Inject
    private MonsterDao mockDAO;
    private MonsterServiceImpl service;
    
    @Inject
    private Mapper mapper;

    @Before
    public void setUp() {
        service = new MonsterServiceImpl();
        mockDAO = mock(MonsterDao.class);
        service.setDao(mockDAO);
        service.setMapper(mapper);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
//        System.out.println("Testing save");
        MonsterDto dto = new MonsterDto();
       
        dto.setId(1L);
        dto.setAgility(11.0);
        dto.setDangerLevel(22.4);
        dto.setDescription("Headless Zombie");
        dto.setHeight(11.4);
        dto.setImagePath("C:\\image.png");
        dto.setMonsterClass(MonsterClass.Zombie);
        dto.setStamina(11.5);
        dto.setStrength(11.8);
        dto.setWeight(11.2);
        dto.setName("HeadlessNick");
        
        Area area1 = new Area();
        area1.setName("Australie");
        Area area2 = new Area();
        area1.setName("New Zeland");
        MonsterAreaDto monsterAreaDto1 = new MonsterAreaDto();
        monsterAreaDto1.setArea(area1);
        monsterAreaDto1.setMonsterQuantity(10);
        MonsterAreaDto monsterAreaDto2 = new MonsterAreaDto();
        monsterAreaDto2.setArea(area2);
        monsterAreaDto2.setMonsterQuantity(20);
        List<MonsterAreaDto> list = new ArrayList<>();  
        list.add(monsterAreaDto1);
        list.add(monsterAreaDto2);
       // dto.setLocations(list);
                
    
        Monster entity = mapper.map(dto, Monster.class);
        when(mockDAO.save(any(Monster.class))).thenReturn(entity);
        MonsterDto returned = service.save(dto);
        assertEquals(returned, dto);
       // assertEquals(list, returned.getLocations());
    }

    /**
     * Test of update method, of class MonsterServiceImpl.
     */
    @Test
    public void testUpdate() {
//        System.out.println("Testing update");
        
        MonsterDto dto = new MonsterDto();
        
        dto.setId(1L);
        dto.setAgility(11.0);
        dto.setDangerLevel(22.4);
        dto.setDescription("Headless Zombie");
        dto.setHeight(11.4);
        dto.setImagePath("C:\\image.png");
        dto.setMonsterClass(MonsterClass.Zombie);
        dto.setStamina(11.5);
        dto.setStrength(11.8);
        dto.setWeight(11.2);
        dto.setName("HeadlessNick");
        
        
        Monster entity = mapper.map(dto, Monster.class);
        when(mockDAO.update(any(Monster.class))).thenReturn(entity);
        MonsterDto returned = service.update(dto);
        verify(mockDAO, times(1)).update(entity);
        verifyNoMoreInteractions(mockDAO);
        assertEquals(returned, dto);
    }
    
    
    /**
     * Test of delete method, of class MonsterServiceImpl.
     */
    @Test
    public void testDelete() {
//        System.out.println("Testing delete");
        
        MonsterDto dto = new MonsterDto();
        dto.setId(1L);
        dto.setAgility(11.0);
        dto.setDangerLevel(22.4);
        dto.setDescription("Headless Zombie");
        dto.setHeight(11.4);
        dto.setImagePath("C:\\image.png");
        dto.setMonsterClass(MonsterClass.Zombie);
        dto.setStamina(11.5);
        dto.setStrength(11.8);
        dto.setWeight(11.2);
        dto.setName("HeadlessNick");
        
        
        Monster entity = new Monster();
        entity.setId(1L);
        entity.setName("Zombie");

        service.delete(dto);

        verify(mockDAO, times(1)).delete(entity);
        verifyNoMoreInteractions(mockDAO);
        
        
  
    }

    /**
     * Test of findById method, of class MonsterServiceImpl.
     */
    @Test
    public void testFindById() {
//        System.out.println("Testing FindById");
        
        MonsterDto dto = new MonsterDto();

        dto.setId(1L);
        dto.setAgility(11.0);
        dto.setDangerLevel(22.4);
        dto.setDescription("Headless Zombie");
        dto.setHeight(11.4);
        dto.setImagePath("C:\\image.png");
        dto.setMonsterClass(MonsterClass.Zombie);
        dto.setStamina(11.5);
        dto.setStrength(11.8);
        dto.setWeight(11.2);
        dto.setName("HeadlessNick");

        Monster entity = mapper.map(dto, Monster.class);
        
        when(mockDAO.findById(dto.getId())).thenReturn(entity);

        MonsterDto returned = service.findById(dto.getId());
        verify(mockDAO, times(1)).findById(dto.getId());
        verifyNoMoreInteractions(mockDAO);

        assertEquals(returned, dto);


    }
}