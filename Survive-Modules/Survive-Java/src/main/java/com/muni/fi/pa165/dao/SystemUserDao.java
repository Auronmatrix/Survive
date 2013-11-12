/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.dao.commons.GenericDao;
import com.muni.fi.pa165.entities.SystemUser;

/**
 * Interface implemented by typed JpaDao objects containing type specific methods.
 *
 * @author Maria
 */
public interface SystemUserDao extends GenericDao<SystemUser, Long> {
}
