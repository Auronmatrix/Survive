package com.muni.fi.pa165.enums;

/**
 * Represents different types of Weapons.
 * 
 * @author Aubrey Oosthuizen
 */
public enum WeaponType {

    /**
     *
     */
    Gun,
    /**
     *
     */
    Blade,
    /**
     *
     */
    Blunt,
    /**
     *
     */
    Explosive;

    /** 
     * Gives all possible weapon types separated by comma.
     * 
     * @return string with all values in WeaponType
     */
    public static String getList() {
        String list = "";
        for (WeaponType t : values()) {
            list += t.name() + ",";
        }
        return list;
    }
}
