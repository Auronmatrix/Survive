/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.commons;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.enums.TerrainType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * Tests the basic CRUD methods for {@link GenericJpaDaoImpl} class.
 *
 * @author Michal Vinkler
 */
public class GenericJpaDaoTest extends AbstractIntegrationTest {

    @Autowired
    AreaDao dao;
    Area entity;

    public GenericJpaDaoTest() {
    }

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class GenericDAO.
     */
    @Test
    public void testSave() {

        dao.save(entity);
        Area newEntity = dao.findById(entity.getId());
        assertEquals(entity, newEntity);

    }

    /**
     * Test of save method, of class GenericDAO.
     */
    @Test(expected = DataAccessException.class)
    public void testSaveWithNull() {

        dao.save(null);

    }

    /**
     * Test of update method, of class GenericDAO.
     */
    @Test
    public void testUpdate() {

        dao.save(entity);

        entity.setName("MODIFIED");

        dao.update(entity);

        Area newEntity = dao.findById(entity.getId());
        assertEquals(entity, newEntity);

        
    }

    /**
     * Test of delete method, of class GenericDAO.
     */
    @Test
    public void testDelete() {
        
        dao.save(entity);

        dao.delete(entity);

        assertNull(dao.findById(entity.getId()));
    }

}