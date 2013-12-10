package com.muni.fi.pa165.enums;

/**
 * Represents different types of terrain.
 * 
 * @author Aubrey Oosthuizen
 */
public enum TerrainType {

    OCEANIC, DESERT, SNOW, JUNGLE, SAVANNA, MOUNTAIN;

    /** 
     * Gives all possible terrain types separated by comma.
     * 
     * @return string with all values in TerrainType
     */
    public static String getList() {
        String list = "";
        for (TerrainType t : values()) {
            list += t.name() + ",";
        }
        return list;
    }
}
