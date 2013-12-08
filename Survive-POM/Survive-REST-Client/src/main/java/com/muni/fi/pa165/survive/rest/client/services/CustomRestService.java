/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.services;

import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Auron
 */
public interface CustomRestService<T, T2> {

    Response create(T dto);

    Response getById(Long id);

    Response update(T dto);
    
    List<T2> getDtoList();

    Response delete(Long id);

    Response getAll();

}
