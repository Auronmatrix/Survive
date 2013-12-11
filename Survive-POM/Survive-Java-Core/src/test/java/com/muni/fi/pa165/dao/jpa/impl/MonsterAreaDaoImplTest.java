/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa.impl;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.dao.MonsterAreaDao;
import com.muni.fi.pa165.dao.MonsterDao;
import com.muni.fi.pa165.dao.gen.AbstractDaoIntegrationTest;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.entities.MonsterareaPK;
import com.muni.fi.pa165.enums.MonsterClass;
import com.muni.fi.pa165.enums.TerrainType;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author irina
 */
public class MonsterAreaDaoImplTest extends AbstractDaoIntegrationTest {
    
    @Autowired
    MonsterDao monsterDao;
    Monster monster;
    @Autowired
    AreaDao areaDao;
    Area area;
    @Autowired
    MonsterAreaDao monsterAreaDao;
    Monsterarea monsterArea;
    
    @Before
    public void setUp() {
        monster = new Monster();
        monster.setAgility(11.0);
        monster.setDangerlevel(22.4);
        monster.setDescription("Headless Zombie");
        monster.setHeight(11.4);
        monster.setImagepath("C:\\image.png");
        monster.setMonsterclass(MonsterClass.Zombie);
        monster.setStamina(11.5);
        monster.setStrength(11.8);
        monster.setWeight(11.2);
        monster.setName("HeadlessNick");
        monsterDao.save(monster);
        
        area = new Area();
        area.setName("Farm");
        area.setTerrain(TerrainType.SNOW);
        areaDao.save(area);
        
        monsterArea = new Monsterarea();
        monsterArea.setArea(area);
        monsterArea.setMonster(monster);
        monsterArea.setMonsterquantity(50);
        monsterArea.setMonsterareaPK(new MonsterareaPK(monster.getId(), area.getId()));
        monsterAreaDao.save(monsterArea);
}
    @After
    public void tearDown() {
        for (Monsterarea item : monsterAreaDao.findAll()){
            monsterAreaDao.delete(item.getMonsterareaPK());
        }
    }
    @Before
    public void setUpClass() {
    }
    
    @Test
     public void testFindAll() {
         List<Monsterarea> monsterAreas = monsterAreaDao.findAll();
         assertEquals("List contains only one monsterArea.",1 , monsterAreas.size());
         assertEquals("In the is proper monsterArea.", monsterArea, monsterAreas.get(0));
     }
    
    @Test
     public void testFindByMonsterId() {
         List<Monsterarea> monsterAreas = monsterAreaDao.getByMonsterId(monster.getId());
         assertEquals("List contains only one monsterArea.",1 , monsterAreas.size());
         assertEquals("In the is proper monsterArea.", monsterArea, monsterAreas.get(0));
     }
    @Test
     public void testFindByAreaId() {
         List<Monsterarea> monsterAreas = monsterAreaDao.getByAreaId(area.getId());
         assertEquals("List contains only one monsterArea.",1 , monsterAreas.size());
         assertEquals("In the is proper monsterArea.", monsterArea, monsterAreas.get(0));
     }
    @Test
    public void testDelete(){
        monsterAreaDao.delete(monsterArea.getMonsterareaPK());
        List<Monsterarea> monsterAreas = monsterAreaDao.findAll();
        assertEquals("List should be empty.", 0, monsterAreas.size());
    }
}
