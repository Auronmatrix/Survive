/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.entities;

import com.muni.fi.pa165.enums.TerrainType;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
public class AreaTest {

    static Area area;

    @BeforeClass
    public static void setUpClass() {
        area = new Area();
        area.setName("Jungle");
        area.setDescription("Area baby");
        area.setTerrain(TerrainType.JUNGLE);
    }

    /**
     * Test of getName method, of class Area.
     */
    @Test
    public void testGetName() {
//        System.out.println("getName");
        Area instance = area;
        String expResult = "Jungle";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setName method, of class Area.
     */
    @Test
    public void testSetName() {
//        System.out.println("setName");
        String name = "Jungle";
        Area instance = new Area();
        instance.setName(name);
        assertEquals(name, area.getName());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getTerrain method, of class Area.
     */
    @Test
    public void testGetTerrain() {
//        System.out.println("getTerrain");
        Area instance = area;
        TerrainType expResult = TerrainType.JUNGLE;
        TerrainType result = instance.getTerrain();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setTerrain method, of class Area.
     */
    @Test
    public void testSetTerrain() {
//        System.out.println("setTerrain");
        TerrainType terrain = TerrainType.SAVANNA;
        Area instance = new Area();
        instance.setTerrain(terrain);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getTerrain(), terrain);
    }

    /**
     * Test of getDescription method, of class Area.
     */
    @Test
    public void testGetDescription() {
//        System.out.println("getDescription");
        Area instance = area;
        String expResult = "Area baby";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDescription method, of class Area.
     */
    @Test
    public void testSetDescription() {
//        System.out.println("setDescription");
        String description = "Hell on earth";
        Area instance = new Area();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getDescription(), description);
    }

    /**
     * Test of hashCode method, of class Area.
     */
    @Test
    public void testHashCode() {
//        System.out.println("hashCode");
        Area instance = area;
        int expResult = area.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of equals method, of class Area.
     */
    @Test
    public void testEquals() {
//        System.out.println("equals");
        Object obj = new Object();
        Area instance = area;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
}