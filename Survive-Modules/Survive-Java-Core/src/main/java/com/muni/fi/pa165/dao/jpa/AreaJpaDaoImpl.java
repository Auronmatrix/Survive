/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa;

import com.muni.fi.pa165.dao.AreaDao;
import com.muni.fi.pa165.dao.commons.GenericJpaDao;
import com.muni.fi.pa165.entities.Area;
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
public class AreaJpaDaoImpl extends GenericJpaDao<Area, Long> implements AreaDao {

    public AreaJpaDaoImpl() {
        super(Area.class);
    }

    @Override
    public boolean checkAvailable(String areaName){
        
        if(areaName == null) {
            throw new IllegalArgumentException("Null argument.");
        }
//        Assert.notNull(areaName);
        TypedQuery<Area> query = getEntityManager().createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", Area.class);
        query.setParameter("name", areaName);
        Area area = null;
        try {
            area = query.getSingleResult();
        } catch (Exception ex) {
        }
        if (area != null) {
            return true;
        }
        return false;

    }

    @Override
    public Area getByName(String areaName){
        Assert.notNull(areaName);
        TypedQuery<Area> query = getEntityManager().createQuery("SELECT a from " + getPersistentClass().getSimpleName() + " a where a.name = :name", Area.class);
        query.setParameter("name", areaName);
        Area area = null;
        try {
            area = query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return area;
    }
}
