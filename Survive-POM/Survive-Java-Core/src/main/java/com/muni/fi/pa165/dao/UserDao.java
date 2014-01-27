package com.muni.fi.pa165.dao;

import com.muni.fi.pa165.entities.Users;
import java.util.List;

/**
 * Interface implemented by typed JpaDao objects containing type specific
 * methods.
 *
 * @author Maria
 */
public interface UserDao extends GenericDao<Users, Long> {
    
}
