/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dao.commons;

import java.util.List;

/**
 *
 * @author Aubrey Oosthuizen
 *
 * GenericDao class that acts as Interface for all JPA DAO objects. Contains
 * CRUD operations on generic types T
 */
public interface GenericDao<T, ID> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

    void flush();
}
