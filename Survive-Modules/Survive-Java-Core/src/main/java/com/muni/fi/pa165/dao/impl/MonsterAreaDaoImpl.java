/* ------------------------------------------------
 * MonsterTypeJpaDao.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterAreaDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Area;
import com.muni.fi.pa165.entities.MonsterArea;
import com.muni.fi.pa165.entities.Monster;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * This class represents the implementation of all basic operations. Typed JpaDao objects extending the GenericDaoAbs
 * abstract class and implementing a Type specific interface. This Dao object will be used to perform all operations
 * within the business layer.
 *
 * @author Michal Vikler
 */
@Repository
public class MonsterAreaDaoImpl extends GenericDaoAbs<MonsterArea, Long> implements MonsterAreaDao {

    public MonsterAreaDaoImpl() {
        super(MonsterArea.class);
    }

    @Override
    public List<Area> getAllAreasForThisMonsterType(Monster monster){

//        Query query = getEntityManager().createQuery("select p. from " + getPersistentClass().getSimpleName() + " where p.monsterclass = :name");
        TypedQuery<Area> query = getEntityManager().createQuery("select m.area from MonsterLocation m where m.monster = :name", Area.class);
        query.setParameter("name", monster.getId());


        List<Area> list = query.getResultList();


        return list;
    }

    @Override
    public List<Monster> getAllMonsterTypesForThisArea(Area area){
        TypedQuery<Monster> query = getEntityManager().createQuery("select m.monster from MonsterLocation m where m.area = :name", Monster.class);
        query.setParameter("name", area.getId());
        List<Monster> list = query.getResultList();


        return list;
    }

    @Override
    public List<MonsterArea> getMonsterAreaForThisMonsterType(Monster monster){
       TypedQuery<MonsterArea> query = getEntityManager().createQuery("select m.monster from MonsterLocation m where m.monster = :name", MonsterArea.class);
        query.setParameter("name", monster.getId());
        return query.getResultList();
    }
   
    @Override
    public List<MonsterArea> getMonsterAreaForThisAreaType(Area area){
        TypedQuery<MonsterArea> query = getEntityManager().createQuery("select m.area from MonsterLocation  m where m.area = :name", MonsterArea.class);
        query.setParameter("name", area.getId());
        return query.getResultList();
    }
}
