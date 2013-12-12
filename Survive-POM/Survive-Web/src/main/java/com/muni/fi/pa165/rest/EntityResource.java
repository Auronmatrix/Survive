/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muni.fi.pa165.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xvinkle1
 */
public interface EntityResource {

//    @GET
//    @Path(value = "/all")
//    @Produces(value = {MediaType.APPLICATION_JSON})
//    Response getAll();

    @GET
    @Produces(value = MediaType.TEXT_PLAIN)
    String getPlain();
    
}
