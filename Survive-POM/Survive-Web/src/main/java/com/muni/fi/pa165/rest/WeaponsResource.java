/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muni.fi.pa165.rest;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.WeaponService;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xvinkle1
 */

@Path("/weapons")
@Singleton
public class WeaponsResource implements EntityResource {
    
     @Context
    private UriInfo context;
    
//    @Inject
   @Autowired
    protected WeaponService weaponService;
    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Override
//    public String getPlain() {
//        String test = "test";
//
//        return test;
//    }
    
    
//    @GET
//    @Path("/all")
//    @Produces({MediaType.APPLICATION_JSON})
//    @Override
//    public Response getAll() {
//        
//        if(weaponService == null) {
//            System.out.println("WEAPON SERVICE: NULL" );
//        }
//       
//        try {
//            Collection<WeaponDto> weaponsDto = weaponService.findAll();
//            
//            GenericEntity<Collection<WeaponDto>> ge =
//                    new GenericEntity<Collection<WeaponDto>>(weaponsDto) {
//                    };
//            return Response.ok().entity(ge).build();
//        } catch (Exception ex) {
//            return Response.status(Response.Status.CONFLICT).build();
//        }
//    }
    
    
        @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlain() {
        StringBuilder returnString = new StringBuilder();
//
//        for (CustomerResource customerResource : customerDB.values()) {
//            returnString.append(customerResource);
//            returnString.append(" ");
//        }

        return returnString.toString();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<WeaponDto> getAll() {
        List<WeaponDto> weapons = new ArrayList<WeaponDto>();
//      for(CustomerResource c: customerDB.values())
//      {
//          customers.add(c);
//      }
        return weapons;
    }


    @Path("{id}")
    public WeaponDto getWeaponDto(@PathParam("id") Integer id) {
      WeaponDto dto = weaponService.findById(Long.valueOf(id.toString()));
        return dto;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
      //  return String.valueOf(customerDB.size());
        int count = 0;
        
        return String.valueOf(count);
    }

    @GET
    @Path("json/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public WeaponDto getJsonWeaponDto(@PathParam("id") Integer id) {
       WeaponDto dto = weaponService.findById(Long.valueOf(id.toString()));
        return dto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(WeaponDto dto) {
//        customerDB.put(Integer.parseInt(customerResource.getId()), customerResource);
//        System.out.println("Created customer " + customerResource.getId());
        return Response.created(URI.create(context.getAbsolutePath() + "/" + dto.getId())).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(WeaponDto dto) {
//        if (customerResource.getId() == null)
//        {
//            int id = customerDB.lastKey() + 1;
//            customerResource.setId(String.valueOf(id));
//        }
//        customerDB.put(Integer.parseInt(customerResource.getId()), customerResource);
//        System.out.println("Created customer " + customerResource.getId());
        return Response.created(URI.create(context.getAbsolutePath() + "/" + dto.getId())).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("id") Integer id, WeaponDto dto) {
//
//        System.out.println("----  putting item ");
//
//        URI uri = context.getAbsolutePath();
//
//        System.out.println(context.getAbsolutePath());

        Response response = null;
//        if (customerDB.containsKey(id)) {
//            customerDB.put(id, new CustomerResource(customerResource));
//            response = Response.created(uri).build();
//        } else {
//            response = Response.noContent().build();
//        }

        return response;
    }
    
    
      @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putXml(@PathParam("id") Integer id, WeaponDto dto) {
//
//        System.out.println("----  putting item ");
//
//        URI uri = context.getAbsolutePath();
//
//        System.out.println(context.getAbsolutePath());
//
        Response response = null;
//        if (customerDB.containsKey(id)) {
//            customerDB.put(id, new CustomerResource(customerResource));
//            response = Response.created(uri).build();
//        } else {
//            response = Response.noContent().build();
//        }
//
        return response;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
//        System.out.println("---- Deleting item nr. " + id);
//
//        if (!customerDB.containsKey(id)) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
//        }
//        customerDB.remove(id);
    }
    
}
