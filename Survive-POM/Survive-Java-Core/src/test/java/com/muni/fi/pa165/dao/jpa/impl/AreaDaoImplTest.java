/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa.impl;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.dao.gen.AbstractDaoIntegrationTest;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.enums.TerrainType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
public class AreaDaoImplTest extends AbstractDaoIntegrationTest {

    @Autowired
    AreaDao dao;
    Area entity;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Area();
        entity.setName("CAVS");
        entity.setDescription("The lion sleeps there tonight");
        entity.setTerrain(TerrainType.JUNGLE);

        dao.save(entity);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testCheckAvailable method, of class AreaJpaDoa.
     */
    @Test
    public void testCheckAvailable() {


//        System.out.println("checkAvailable");
        String areaName = "CAVS";

        boolean expResult = true;
        boolean result = dao.checkAvailable(areaName);
        assertEquals(expResult, result);

    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testCheckAvailableWithNull() {
//
//        dao.checkAvailable(null);
//
//    }

    /**
     * Test of getAreanByName method, of class AreaJpaDoa.
     */

}
