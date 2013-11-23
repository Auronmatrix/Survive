/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa.impl;

import com.muni.fi.pa165.dao.MonsterDao;
import com.muni.fi.pa165.dao.gen.AbstractDaoIntegrationTest;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.enums.MonsterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Auron
 */
public class MonsterDaoImplTest extends AbstractDaoIntegrationTest {

    @Autowired
    MonsterDao dao;
    Monster entity;

    @Before
    public void setUp() {
        entity = new Monster();
        entity.setAgility(11.0);
        entity.setDangerLevel(22.4);
        entity.setDescription("Headless Zombie");
        entity.setHeight(11.4);
        entity.setImagePath("C:\\image.png");
        entity.setMonsterClass(MonsterClass.Zombie);
        entity.setStamina(11.5);
        entity.setStrength(11.8);
        entity.setWeight(11.2);
        entity.setName("HeadlessNick");
        dao.save(entity);

    }

    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Before
    public void setUpClass() {
    }

    /**
     * Test of checkAvailable method, of class MonsterJpaDaoImpl.
     */
    @Test
    public void testCheckAvailable() {
//        System.out.println("Test checkAvailable method with valid arguments.");
        MonsterClass monsterClass = MonsterClass.Zombie;
        assertTrue(dao.checkAvailable(monsterClass));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testCheckAvailableWithNull() {
//
//        dao.checkAvailable(null);
//
//    }

    /**
     * Test of getMonsterByName method, of class MonsterJpaDaoImpl.
     */
    @Test
    public void testGetMonsterTypeByName() {
//        System.out.println("Test getMonsterTypeByName method.");
        String name = "HeadlessNick";
        assertEquals(entity, dao.getMonsterByName(name));
    }
}