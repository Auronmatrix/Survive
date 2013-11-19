/* ------------------------------------------------
 * MonsterAreaDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.dao.commons.GenericDao;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.MonsterArea;
import com.muni.fi.pa165.entities.Monster;
import java.util.List;

/**
 * Interface MonsterAreaDao. Interface implemented by typed JpaDao objects containing type specific methods
 *
 * @author Michal Vinkler
 */
public interface MonsterAreaDao extends GenericDao<MonsterArea, Long> {

    /**
     * This method returns all the areas where the given type of a monster has been spotted.
     *
     * @return list of all areas where the monsterType was spotted
     */
    List<Area> getAllAreasForThisMonsterType(Monster monster);
    
    List<MonsterArea> getMonsterAreaForThisMonsterType(Monster monster);

    /**
     * This method returns all the spotted monsters for the specified area
     *
     * @return list of all the spotted monsters
     */
    List<Monster> getAllMonsterTypesForThisArea(Area area);
    
    List<MonsterArea> getMonsterAreaForThisAreaType(Area Area);
}
