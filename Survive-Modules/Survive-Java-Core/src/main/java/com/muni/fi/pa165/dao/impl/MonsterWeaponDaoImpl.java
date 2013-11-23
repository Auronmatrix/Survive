/* ------------------------------------------------
 * MonsterweaponDaoImpl.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Monsterweapon;
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
public class MonsterWeaponDaoImpl extends GenericDaoAbs<Monsterweapon, Long> implements MonsterWeaponDao {

    public MonsterWeaponDaoImpl() {
        super(Monsterweapon.class);
    }

    @Override   
    public List<Monsterweapon> getByMonsterId(Long id) {
       TypedQuery<Monsterweapon> query = getEntityManager().createQuery("select o from Monsterweapon o where o.monster.id = :id", Monsterweapon.class);
       query.setParameter("id", id);
       return query.getResultList();
    }

    @Override
    public List<Monsterweapon> getByWeaponId(Long id) {
        TypedQuery<Monsterweapon> query = getEntityManager().createQuery("select o from Monsterweapon o where o.weapon.id = :id", Monsterweapon.class);
       query.setParameter("id", id);
       return query.getResultList();
    }
}
