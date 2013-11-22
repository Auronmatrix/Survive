/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dao.commons.GenericJpaDao;
import com.muni.fi.pa165.entities.Weapon;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Typed JpaDao objects extending the GenericJpaDao abstract class and implementing a Type specific interface. This Dao
 * object will be used to perform all operations within the business layer.
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
@Repository
public class WeaponJpaDaoImpl extends GenericJpaDao<Weapon, Long> implements WeaponDao {

    public WeaponJpaDaoImpl() {
        super(Weapon.class);
    }

    @Override
    public boolean checkAvailable(String name) {

        if (name == null) {
            throw new IllegalArgumentException("Null argument.");
        }

//        Assert.notNull(name); //Use to make sure no null object is passed. org.springframework.util.Assert;

        System.out.println("Trying to look for weapon named " + name);
        TypedQuery<Weapon> query = getEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.name = :name", Weapon.class);
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Weapon getByName(String name) {
        Assert.notNull(name);
        Weapon obj = null;

        TypedQuery<Weapon> query = getEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.name = :name", Weapon.class);
        query.setParameter("name", name);

        //I think the try catch can be removed. Need to verify at seminar
        try {
            obj = query.getSingleResult();
        } catch (NoResultException ex) {
            //do nothing
        }

        return obj;
    }
}
