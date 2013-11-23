/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Systemuser;
import org.springframework.stereotype.Repository;

/**
 * Typed JpaDao objects extending the GenericDaoAbs abstract class and implementing a Type specific interface. This Dao
 * object will be used to perform all operations within the business layer.
 *
 * @author Maria
 */
@Repository
public class SystemUserDaoImpl extends GenericDaoAbs<Systemuser, Long> implements SystemUserDao {

    public SystemUserDaoImpl() {
        super(Systemuser.class);
    }
}
