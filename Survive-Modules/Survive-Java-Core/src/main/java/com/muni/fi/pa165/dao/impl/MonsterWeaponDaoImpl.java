/* ------------------------------------------------
 * MonsterWeaponDaoImpl.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.MonsterWeapon;
import com.muni.fi.pa165.entities.Weapon;
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
public class MonsterWeaponDaoImpl extends GenericDaoAbs<MonsterWeapon, Long> implements MonsterWeaponDao {

    public MonsterWeaponDaoImpl() {
        super(MonsterWeapon.class);
    }

    @Override
    public List<Weapon> getAllWeaponsForThisMonsterType(Monster monster) {
        TypedQuery<Weapon> query = getEntityManager().createQuery("select m.weapon from MonsterWeapon m where m.monster = :id", Weapon.class);
        query.setParameter("id", monster);
        return query.getResultList();

    }

    @Override
    public List<Monster> getAllMonstersForThisWeaponType(Weapon weapon) {
        TypedQuery<Monster> query = getEntityManager().createQuery("select m.monster from MonsterWeapon m where m.weapon = :name", Monster.class);
        query.setParameter("name", weapon.getId());
        return query.getResultList();


    }

    @Override
    public List<MonsterWeapon> getMonsterWeaponsForThisMonsterType(Long id) {
        TypedQuery<MonsterWeapon> query = getEntityManager().createQuery("select m from MonsterWeapon m where m.monster.id = :name", MonsterWeapon.class);
        query.setParameter("name", id);
        return query.getResultList();
    }

    @Override
    public List<MonsterWeapon> getMonsterWeaponsForThisWeaponType(Weapon weapon) {
         TypedQuery<MonsterWeapon> query = getEntityManager().createQuery("select m from MonsterWeapon m where m.weapon = :name", MonsterWeapon.class);
        query.setParameter("name", weapon.getId());
        return query.getResultList();
    }
}
