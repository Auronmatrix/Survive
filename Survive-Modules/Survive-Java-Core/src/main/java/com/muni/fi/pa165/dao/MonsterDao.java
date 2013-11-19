/* ------------------------------------------------
 * MonsterDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.dao.commons.GenericDao;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.enums.MonsterClass;

/**
 * Interface MonsterDao. Interface implemented by typed JpaDao objects containing type specific methods.
 *
 *
 * @author Michal Vinkler
 *
 *
 */
public interface MonsterDao extends GenericDao<Monster, Long> {

    /**
     * This method checks if there is a record of monster with given monsterClass.
     *
     * @return true if such a monsterClass exists
     */
    boolean checkAvailable(MonsterClass monsterClass);

    /**
     * This method returns one type of a creature according to given monsterClass.
     *
     * @return a single monster type when record in db exists, null otherwise
     */
    Monster getMonsterByName(String name);
}
