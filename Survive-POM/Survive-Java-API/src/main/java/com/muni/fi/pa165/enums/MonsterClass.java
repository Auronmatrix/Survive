package com.muni.fi.pa165.enums;

/**
 * Represents different classes of Monsters.
 * 
 * @author Aubrey Oosthuizen
 */
public enum MonsterClass {

    Zombie, Robot, Mutant;

    /** 
     * Gives all possible monster classes separated by comma.
     * 
     * @return string with all values in MonsterClass
     */
    public static String getList() {
        String list = "";
        for (MonsterClass t : values()) {
            list += t.name() + ",";
        }
        return list;
    }
}
