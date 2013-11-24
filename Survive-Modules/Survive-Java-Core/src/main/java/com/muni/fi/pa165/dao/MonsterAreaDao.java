/* ------------------------------------------------
 * MonsterAreaDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterareaPK;
import java.util.List;

/**
 * Interface MonsterAreaDao. Interface implemented by typed JpaDao objects containing type specific methods
 *
 * @author Michal Vinkler
 */
public interface MonsterAreaDao extends GenericDao<MonsterareaPK, Long> {


   
    List<MonsterareaPK> getByMonsterId(Long id);

   
    List<MonsterareaPK> getByAreaId(Long id);
    
}
