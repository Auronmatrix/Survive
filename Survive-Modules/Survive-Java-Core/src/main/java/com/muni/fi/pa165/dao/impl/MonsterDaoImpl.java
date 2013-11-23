/* ------------------------------------------------
 * MonsterDaoImpl.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.enums.MonsterClass;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * This class represents the implementation of all basic operations. Typed JpaDao objects extending the GenericDaoAbs
 * abstract class and implementing a Type specific interface. This Dao object will be used to perform all operations
 * within the business layer.
 *
 * @author Michal Vikler
 */
@Repository
public class MonsterDaoImpl extends GenericDaoAbs<Monster, Long> implements MonsterDao {

    public MonsterDaoImpl() {
        super(Monster.class);
    }

    @Override
    public boolean checkAvailable(MonsterClass monsterClass) {

        if (monsterClass == null) {
            throw new IllegalArgumentException("Null argument.");
        }

//        Assert.notNull(monsterClass);

        TypedQuery<Monster> query = getEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.monsterclass = :class", Monster.class);
        query.setParameter("class", monsterClass);

        if (!query.getResultList().isEmpty()) {
            return true;
        }
        return false;

    }

    @Override
    public Monster getMonsterByName(String name) {
        Assert.notNull(name);
        Monster monster = null;

        TypedQuery<Monster> query = getEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.name = :name", Monster.class);
        query.setParameter("name", name.toString());

        //I think since this is a typed query we can remove the try catch. Will verify at seminar
        try {
            monster = query.getSingleResult();
        } catch (NoResultException ex) {
            //do nothing
        }
        return monster;

    }
}
