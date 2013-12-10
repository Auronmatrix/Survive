package com.muni.fi.pa165.dao;

import java.util.List;

/**
 *
 * @author Aubrey Oosthuizen
 *
 * GenericDao class that acts as Interface for all JPA DAO objects. Contains
 * CRUD operations on generic types T
 * 
 * @throws IllegalArgumentException when null is passed
 */
public interface GenericDao<T, ID> {

    T save(T entity)throws IllegalArgumentException;

    T update(T entity);

    void delete(T entity);

    void delete(Long id);

    T findById(ID id);

    List<T> findAll();

    void flush();
}
