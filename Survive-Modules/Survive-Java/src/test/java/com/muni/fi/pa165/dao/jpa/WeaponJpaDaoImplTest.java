/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dao.commons.AbstractIntegrationTest;
import com.muni.fi.pa165.entities.Weapon;
import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Aubrey Oosthuizen
 */
public class WeaponJpaDaoImplTest extends AbstractIntegrationTest {

    @Autowired
    WeaponDao dao;
    private Weapon entity;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Weapon();
        entity.setName("TESTAK47");
        entity.setCaliber(Double.valueOf(0.88));
        entity.setDescription("Africa's favourite");
        entity.setRounds(44);
        entity.setRange(100);
        entity.setWeaponClass(WeaponClass.Ranged);
        entity.setWeaponType(WeaponType.Gun);
        dao.save(entity);

    }

    @After
    public void tearDown() {
    }

    @Test(expected = DataAccessException.class)
    public void testSaveWithNull() {

        dao.save(null);

    }

    /**
     * Test of checkAvailable method, of class WeaponJpaDaoImpl.
     */
    @Test
    public void testCheckAvailable() {
//        System.out.println("checkAvailable");
        String weaponName = "TESTAK47";

        boolean expResult = true;
        boolean result = dao.checkAvailable(weaponName);
        assertEquals(expResult, result);

    }

    @Test(expected = DataAccessException.class)
    public void testCheckAvailableWithNull() {
        
        dao.checkAvailable(null);
        
    }

    /**
     * Test of getByName method, of class WeaponJpaDaoImpl.
     */
    @Test
    public void testGetWeaponByName() {
//        System.out.println("getWeaponByName");
        String weaponName = "TESTAK47";

        Weapon expResult = entity;
        Weapon result = dao.getByName(weaponName);
        assertEquals(expResult, result);
    }
}