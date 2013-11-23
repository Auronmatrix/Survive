/* ------------------------------------------------
 * MonsterWeaponDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.entities.Weapon;
import java.util.List;

/**
 * Interface MonsterWeaponDao. Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Michal Vinkler
 */
public interface MonsterWeaponDao extends GenericDao<MonsterWeapon, Long> {

    /**
     * This method returns all the weapons which are somehow efficient against given monster.
     *
     * @return list of all areas where the monsterType was spotted
     */
    List<Weapon> getAllWeaponsForThisMonsterType(Monster monster);
 /**
     * This method returns all the monsterWeapons related with given monster
     *
     * @return list of all monsterWeapons which related with given monster
     */
    List<MonsterWeapon> getMonsterWeaponsForThisMonsterType(Long id);
    /**
     * This method returns all the monsters which are vulnerable to the given type of the weapon.
     *
     * @return list of all monsters vulnerable to given weapon
     */
    List<Monster> getAllMonstersForThisWeaponType(Weapon weapon);
    /**
     * This method returns all the monsterWeapons related with given weapon
     *
     * @return list of all monsterWeapons which related with given weapon
     */
    List<MonsterWeapon> getMonsterWeaponsForThisWeaponType(Weapon weapon);
}
