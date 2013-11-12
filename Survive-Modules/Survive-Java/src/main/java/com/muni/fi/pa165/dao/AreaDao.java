/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.dao.commons.GenericDao;
import com.muni.fi.pa165.entities.Area;

/**
 * Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Aubrey Oosthuizen
 */
public interface AreaDao extends GenericDao<Area, Long> {

    boolean checkAvailable(String areaName);

    Area getByName(String areaName);
}
