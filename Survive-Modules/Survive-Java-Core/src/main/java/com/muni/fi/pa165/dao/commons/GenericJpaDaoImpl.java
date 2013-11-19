/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.commons;

import com.muni.fi.pa165.entities.GenericEntity;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 *
 * @author Aubrey Oosthuizen Implementation class used for unit testing the GenericJpaDao class
 */
@Repository
public class GenericJpaDaoImpl extends GenericJpaDao<GenericEntity, Long> {

    public GenericJpaDaoImpl() {
        super(GenericEntity.class);
    }

    public boolean checkAvailable(String name){
        Assert.notNull(name);
        TypedQuery<GenericEntity> query = getEntityManager().createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", GenericEntity.class);
        GenericEntity obj = null;
        try {
            obj = query.getSingleResult();
        } catch (Exception ex) {
        }
        if (obj != null) {
            return true;
        }
        return false;

    }
}
