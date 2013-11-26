/* ------------------------------------------------
 * MonsterweaponDaoImpl.java
 * 
 * ------------------------------------------------
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.entities.Monsterweapon;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * This class represents the implementation of all basic operations. Typed
 * JpaDao objects extending the GenericDaoAbs abstract class and implementing a
 * Type specific interface. This Dao object will be used to perform all
 * operations within the business layer.
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
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterweapon.findByMonsterid").setParameter("monsterid", id);
        EntityTransaction tx = em.getTransaction();
        List <Monsterweapon> list = new ArrayList();
        try {
                tx.begin();
                list = query.getResultList();
                tx.commit();        
        }
        finally {
            
            if (em != null) {
                em.close();
            }
        }
       return list;
    }

    @Override
    public List<Monsterweapon> getByWeaponId(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterweapon.findByWeaponid").setParameter("weaponid", id);
        EntityTransaction tx = em.getTransaction();
        List <Monsterweapon> list = new ArrayList();
        try {
                tx.begin();
                list = query.getResultList();
                tx.commit();        
        }
        finally {
            
            if (em != null) {
                em.close();
            }
        }
       return list;
    
    }
    
    @Override
    public void delete(MonsterweaponPK pk)
    {    
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        try {
                tx.begin();
                Monsterweapon entity = findById(pk);
                em.merge(pk);
               em.merge(entity);
               em.remove(entity);
               tx.commit();
               }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Monsterweapon> findAll() {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();      
        Query query = em.createNamedQuery("Monsterweapon.findAll");
        EntityTransaction tx = em.getTransaction();
        List <Monsterweapon> list = new ArrayList();
        try {
                tx.begin();
                list = query.getResultList();
                tx.commit();        
        }
        finally {
            
            if (em != null) {
                em.close();
            }
        }
       return list;
     }
    
    @Override
    public Monsterweapon findById(MonsterweaponPK id) {
      EntityManager em = this.getEntityManagerFactory().createEntityManager();      
        Query query = em.createNamedQuery("Monsterweapon.findById");
        query.setParameter("monsterweaponPK", id);
        EntityTransaction tx = em.getTransaction();
        Monsterweapon obj = null;
        try {
                tx.begin();
                obj = (Monsterweapon) query.getSingleResult();
                tx.commit();        
        }
        finally {
            
            if (em != null) {
                em.close();
            }
        }
       return obj;
        
    }
}
