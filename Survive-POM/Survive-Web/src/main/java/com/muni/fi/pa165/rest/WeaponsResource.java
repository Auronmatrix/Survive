/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.rest;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.WeaponService;
import com.sun.jersey.spi.inject.Inject;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author xvinkle1
 */
@Path("/weapons")
@Component
@Scope("request")
//@Singleton
public class WeaponsResource implements EntityResource {

    @Context
    private UriInfo context;

    @Inject
    WeaponService weaponService;


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public List<WeaponDto> getAll() {
        return weaponService.findAll();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getPlain() {
        StringBuilder returnString = new StringBuilder();

        for (WeaponDto dto : weaponService.findAll()) {
            returnString.append(dto);
            returnString.append(" ");
        }

        return returnString.toString();
    }


    @GET
    @Path("weapon/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public WeaponDto getById(@PathParam("id") Integer id) {
        WeaponDto dto = weaponService.findById(Long.valueOf(id.toString()));
        return dto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(WeaponDto dto) {

        URI uri = context.getAbsolutePath();
        Response response;

        try {
            dto = weaponService.save(dto);
            response = Response.created(URI.create(context.getAbsolutePath() + "/" + dto.getId())).build();
        } catch (Exception ex) {
            response = Response.noContent().build();
        }

        return response;
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putXml(@PathParam("id") Integer id, WeaponDto dto) {
        Response response;
        try {
            dto = weaponService.update(dto);
            response = Response.ok(dto).build();
        } catch (Exception ex) {
            response = Response.noContent().build();
        }
        return response;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        WeaponDto dto = weaponService.findById(Long.valueOf(id));
        if (dto == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        weaponService.delete(dto.getId());
    }
}
