/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa.impl;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dao.gen.AbstractDaoIntegrationTest;
import com.muni.fi.pa165.entities.Systemuser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maria
 */
public class SystemUserDaoImplTest extends AbstractDaoIntegrationTest{

    @Autowired
    SystemUserDao dao;
    
    Systemuser entity;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Systemuser();
        entity.setUsername("user");
        entity.setPassword("1234");
        entity.setAccesslevel(1);
        dao.save(entity);

    }

    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testDelete() {
        dao.delete(entity);
        Systemuser deletedUser = dao.findById(entity.getId());
        Assert.assertNull(deletedUser);
    }

    @Test
    public void createTest() {
        Assert.assertNotNull(entity);
        Assert.assertNotNull(entity.getId());
    }

    @Test
    public void findTest() {
        Systemuser systemUserFound = dao.findById(entity.getId());
        Assert.assertNotNull(systemUserFound);
    }
}