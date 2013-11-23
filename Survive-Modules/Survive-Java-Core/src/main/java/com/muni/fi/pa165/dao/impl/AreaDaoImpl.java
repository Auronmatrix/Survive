/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Area;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * This class represents the implementation of all basic operations. Typed JpaDao objects extending the GenericJpaDao
 * abstract class and implementing a Type specific interface. This Dao object will be used to perform all operations
 * within the business layer.
 *
 * @author Aubrey Oosthuizen
 */
@Repository
public class AreaDaoImpl extends GenericDaoAbs<Area, Long> implements AreaDao {

    public AreaDaoImpl() {
        super(Area.class);
    }

    @Override
    public boolean checkAvailable(String areaName){
        
        if(areaName == null) {
            throw new IllegalArgumentException("Null argument.");
        }
//        Assert.notNull(areaName);
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
         Area area = null;
        TypedQuery<Area> query = em.createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", Area.class);
        query.setParameter("name", areaName);
        EntityTransaction tx = em.getTransaction(); 
        try {
            tx.begin();
             area = query.getSingleResult();
           
           

        }
        finally {
            tx.commit();
            if (em != null) {
                em.close();
            }
        }
        if (area != null) {
               return true;
           }
           return false;
        
    }

    @Override
    public Area getByName(String areaName){
        Assert.notNull(areaName);
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        TypedQuery<Area> query = em.createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", Area.class);
        query.setParameter("name", areaName);
        Area area = null;
        EntityTransaction tx = em.getTransaction(); 
        try {
            tx.begin();
            area = query.getSingleResult();
        } catch (NoResultException ex) {
        } finally {
            tx.commit();
            if (em != null) {
                em.close();
            }
        }
        return area;
    }
}

