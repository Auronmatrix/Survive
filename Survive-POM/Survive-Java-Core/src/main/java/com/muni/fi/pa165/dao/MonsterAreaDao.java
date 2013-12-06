/* ------------------------------------------------
 * MonsterAreaDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao;


import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.entities.MonsterareaPK;
import java.util.List;

/**
 * Interface MonsterAreaDao. Interface implemented by typed JpaDao objects containing type specific methods
 *
 * @author Michal Vinkler
 */
public interface MonsterAreaDao extends GenericDao<Monsterarea, Long> {


   
    List<Monsterarea> getByMonsterId(Long id);

   
    List<Monsterarea> getByAreaId(Long id);
    
    List<Monsterarea> findAll();
    
    Monsterarea findById(MonsterareaPK id);
    
    void delete(MonsterareaPK pk);
    
}
