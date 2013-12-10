package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.MonsterAreaDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Monsterarea;
import com.muni.fi.pa165.entities.MonsterareaPK;
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
public class MonsterAreaDaoImpl extends GenericDaoAbs<Monsterarea, Long> implements MonsterAreaDao {

    public MonsterAreaDaoImpl() {
        super(Monsterarea.class);
    }

    @Override
    public List<Monsterarea> getByMonsterId(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterweapon.findByMonsterid").setParameter("monsterid", id);
        EntityTransaction tx = em.getTransaction();
        List<Monsterarea> list = new ArrayList();
        try {
            tx.begin();
            list = query.getResultList();
            tx.commit();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public List<Monsterarea> getByAreaId(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterweapon.findByAreaid").setParameter("areaid", id);
        EntityTransaction tx = em.getTransaction();
        List<Monsterarea> list = new ArrayList();
        try {
            tx.begin();
            list = query.getResultList();
            tx.commit();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return list;

    }

    @Override
    public void delete(MonsterareaPK pk) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Query query = em.createNamedQuery("Monsterarea.findById");
        query.setParameter("monsterareaPK", pk);
        Monsterarea obj = null;
        try {
            tx.begin();
            obj = (Monsterarea) query.getSingleResult();
            //em.merge(pk);
            em.merge(obj);
            em.remove(obj);
            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public List<Monsterarea> findAll() {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterarea.findAll");
        EntityTransaction tx = em.getTransaction();
        List<Monsterarea> list = new ArrayList();
        try {
            tx.begin();
            list = query.getResultList();
            tx.commit();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return list;
    }

    @Override
    public Monsterarea findById(MonsterareaPK id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query query = em.createNamedQuery("Monsterarea.findById");
        query.setParameter("monsterareaPK", id);
        EntityTransaction tx = em.getTransaction();
        Monsterarea obj = null;
        try {
            tx.begin();
            obj = (Monsterarea) query.getSingleResult();
            tx.commit();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return obj;

    }
}
