/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Weapon;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Typed JpaDao objects extending the GenericDaoAbs abstract class and implementing a Type specific interface. This Dao
 * object will be used to perform all operations within the business layer.
 *
 * @author Aubrey Oosthuizen / Irina Serdyukova
 */
@Repository
public class WeaponDaoImpl extends GenericDaoAbs<Weapon, Long> implements WeaponDao {

    public WeaponDaoImpl() {
        super(Weapon.class);
    }

    @Override
    public boolean checkAvailable(String name) {

        if (name == null) {
            throw new IllegalArgumentException("Null argument.");
        }

//        Assert.notNull(name); //Use to make sure no null object is passed. org.springframework.util.Assert;

        System.out.println("Trying to look for weapon named " + name);
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        TypedQuery<Weapon> query = em.createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.name = :name", Weapon.class);
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
EntityManager em = this.getEntityManagerFactory().createEntityManager();
        TypedQuery<Weapon> query = em.createQuery("select p from " + getPersistentClass().getSimpleName() + " p where p.name = :name", Weapon.class);
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
