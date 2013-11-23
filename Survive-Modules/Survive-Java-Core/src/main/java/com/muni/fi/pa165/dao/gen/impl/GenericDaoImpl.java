/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.gen.impl;

import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Genericentity;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 *
 * @author Aubrey Oosthuizen Implementation class used for unit testing the GenericDaoAbs class
 */
@Repository
public class GenericDaoImpl extends GenericDaoAbs<Genericentity, Long> {

    public GenericDaoImpl() {
        super(Genericentity.class);
    }

    public boolean checkAvailable(String name){
        Assert.notNull(name);
        TypedQuery<Genericentity> query = getEntityManager().createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", Genericentity.class);
        Genericentity obj = null;
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
