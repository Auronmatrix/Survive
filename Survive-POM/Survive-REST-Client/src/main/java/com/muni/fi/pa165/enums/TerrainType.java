/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.enums;

/**
 *
 * @author Aubrey Oosthuizen
 */
public enum TerrainType {

    OCEANIC, DESERT, SNOW, JUNGLE, SAVANNA, MOUNTAIN;


public static String getList()
    {
        String list = "";
        for(TerrainType t : values())
        {
            list += t.name() + ",";
        }
        return list;
    }
}
