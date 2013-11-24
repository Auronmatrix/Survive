/* ------------------------------------------------
 * MonsterweaponDaoImpl.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import java.util.List;
import javax.persistence.EntityManager;
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
public class MonsterWeaponDaoImpl extends GenericDaoAbs<MonsterweaponPK, Long> implements MonsterWeaponDao {

    public MonsterWeaponDaoImpl() {
        super(MonsterweaponPK.class);
    }

    @Override   
    public List<MonsterweaponPK> getByMonsterId(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
       TypedQuery<MonsterweaponPK> query = em.createQuery("select o from Monsterweapon o where o.monster.id = :id", MonsterweaponPK.class);
       query.setParameter("id", id);
       return query.getResultList();
    }

    @Override
    public List<MonsterweaponPK> getByWeaponId(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        TypedQuery<MonsterweaponPK> query = em.createQuery("select o from Monsterweapon o where o.weapon.id = :id", MonsterweaponPK.class);
       query.setParameter("id", id);
       return query.getResultList();
    }
}
