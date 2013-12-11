package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.service.impl.MonsterAreaServiceImpl;
import com.muni.fi.pa165.dao.MonsterAreaDao;
import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.service.AbstractServiceIntegrationTest;
import com.muni.fi.pa165.dto.MonsterAreaDto;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.enums.MonsterClass;
import com.muni.fi.pa165.enums.TerrainType;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;


/**
 *
 * @author irina
 */
public class MonsterAreaServiceImplTest extends AbstractServiceIntegrationTest {

    @Inject
    private MonsterAreaDao mockDAO;
    private MonsterAreaServiceImpl service;
    @Inject
    private Mapper mapper;
    private MonsterDto monsterDto;
    private AreaDto areaDto;
    private MonsterAreaDto monsterAreaDto;

    @Before
    public void setUp() {
        service = new MonsterAreaServiceImpl();
        mockDAO = mock(MonsterAreaDao.class);
        service.setDao(mockDAO);
        service.setMapper(mapper);

        monsterDto = new MonsterDto();
        monsterDto.setId(1L);
        monsterDto.setAgility(11.0);
        monsterDto.setDangerLevel(22.2);
        monsterDto.setDescription("Headless Zombie");
        monsterDto.setHeight(11.4);
        monsterDto.setImagePath("C:\\image.png");
        monsterDto.setMonsterClass(MonsterClass.Zombie);
        monsterDto.setStamina(11.5);
        monsterDto.setStrength(11.8);
        monsterDto.setWeight(11.2);
        monsterDto.setName("HeadlessNick");
        monsterDto.setId(Long.MIN_VALUE);
        
        areaDto = new AreaDto();
        areaDto.setName("Farm");
        areaDto.setTerrain(TerrainType.SNOW);
        areaDto.setId(Long.MIN_VALUE);


        monsterAreaDto = new MonsterAreaDto();
        monsterAreaDto.setArea(areaDto);
        monsterAreaDto.setMonster(monsterDto);
        monsterAreaDto.setMonsterQuantity(5);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class MonsterAreaServiceImpl.
     */
    @Test
    public void testSave() {
        Monsterarea entity = mapper.map(monsterAreaDto, Monsterarea.class);
        when(mockDAO.save(any(Monsterarea.class))).thenReturn(entity);
        MonsterAreaDto returned = service.save(monsterAreaDto);
        assertEquals(returned, monsterAreaDto);
    }

    /**
     * Test of update method, of class MonsterAreaServiceImpl.
     */
    @Test
    public void testUpdate() {
        Monsterarea entity = mapper.map(monsterAreaDto, Monsterarea.class);
        when(mockDAO.update(any(Monsterarea.class))).thenReturn(entity);
        MonsterAreaDto returned = service.update(monsterAreaDto);
        assertEquals(returned, monsterAreaDto);
    }

    /**
     * Test of delete method, of class MonsterAreaServiceImpl.
     */
    @Test
    public void testDelete() {

        Monsterarea entity = mapper.map(monsterAreaDto, Monsterarea.class);
        service.delete(monsterAreaDto);
        verify(mockDAO, times(1)).delete(entity);
        verifyNoMoreInteractions(mockDAO);

    }
}