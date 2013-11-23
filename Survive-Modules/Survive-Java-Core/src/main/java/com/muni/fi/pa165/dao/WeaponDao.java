/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.Weapon;

/**
 * Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
public interface WeaponDao extends GenericDao<Weapon, Long> {

    boolean checkAvailable(String weaponName);

    Weapon getByName(String weaponName);
}
