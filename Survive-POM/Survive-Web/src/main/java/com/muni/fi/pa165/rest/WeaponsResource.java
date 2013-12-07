/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muni.fi.pa165.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author xvinkle1
 */
@Path("weapons")
@Component
public class WeaponsResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlain() {
        String test = "test";

        

        return test;
    }
    
}
