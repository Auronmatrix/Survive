package com.muni.fi.pa165.dao.gen.impl;

import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.GenericEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 *
 * @author Aubrey Oosthuizen
 *
 * Implementation class used for unit testing the GenericJpaDao class
 */
@Repository
public class GenericDaoImpl extends GenericDaoAbs<GenericEntity, Long> {

    /**
     *
     */
    public GenericDaoImpl() {
        super(GenericEntity.class);
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean checkAvailable(String name) {
        Assert.notNull(name);
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            TypedQuery<GenericEntity> query = em.createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", GenericEntity.class);
            GenericEntity obj = null;
            try {
                tx.begin();
                obj = query.getSingleResult();
            } catch (Exception ex) {
            }
            if (obj != null) {
                return true;
            }
            return false;
        } finally {
            tx.commit();
                em.close();
        }


    }
}
