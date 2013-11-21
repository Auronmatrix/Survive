/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.jpa;

import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.dao.commons.GenericJpaDao;
import com.muni.fi.pa165.entities.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * Typed JpaDao objects extending the GenericJpaDao abstract class and implementing a Type specific interface. This Dao
 * object will be used to perform all operations within the business layer.
 *
 * @author Maria
 */
@Repository
public class SystemUserJpaDaoImpl extends GenericJpaDao<SystemUser, Long> implements SystemUserDao {

    public SystemUserJpaDaoImpl() {
        super(SystemUser.class);
    }
}
