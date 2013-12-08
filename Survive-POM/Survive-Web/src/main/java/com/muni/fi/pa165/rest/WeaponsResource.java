/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muni.fi.pa165.rest;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.WeaponService;
import java.util.Collection;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xvinkle1
 */

@Path("/weapons")
@Singleton
public class WeaponsResource implements EntityResource {
    
//    @Inject
   @Autowired
    protected WeaponService weaponService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getPlain() {
        String test = "test";

        

        return test;
    }
    
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public Response getAll() {
        
        if(weaponService == null) {
            System.out.println("WEAPON SERVICE: NULL" );
        }
       
        try {
            Collection<WeaponDto> weaponsDto = weaponService.findAll();
            
            GenericEntity<Collection<WeaponDto>> ge =
                    new GenericEntity<Collection<WeaponDto>>(weaponsDto) {
                    };
            return Response.ok().entity(ge).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
    
}
