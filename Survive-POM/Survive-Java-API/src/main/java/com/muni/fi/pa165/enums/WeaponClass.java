package com.muni.fi.pa165.enums;

/**
 * Represents different classes of Weapons.
 * 
 * @author Aubrey Oosthuizen
 */
public enum WeaponClass {

    /**
     *
     */
    Ranged,
    /**
     *
     */
    Melee;

   /** 
     * Gives all possible weapon classes separated by comma.
     * 
     * @return string with all values in WeaponClass
     */
    public static String getList() {
        String list = "";
        for (WeaponClass t : values()) {
            list += t.name() + ",";
        }
        return list;
    }
}
