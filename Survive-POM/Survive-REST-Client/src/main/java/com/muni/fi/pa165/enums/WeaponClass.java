/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.enums;

/**
 *
 * @author Aubrey Oosthuizen
 */
public enum WeaponClass {

    Ranged, Melee;
    
    
public static String getList()
    {
        String list = "";
        for(WeaponClass t : values())
        {
            list += t.name() + ",";
        }
        return list;
    }

}
