/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.enums;

/**
 *
 * @author Aubrey Oosthuizen
 */
public enum MonsterClass {

    Zombie, Robot, Mutant;
    
    
public static String getList()
    {
        String list = "";
        for(MonsterClass t : values())
        {
            list += t.name() + ",";
        }
        return list;
    }

}
