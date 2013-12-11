/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.rest;

import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.enums.TerrainType;
import com.muni.fi.pa165.service.AreaService;
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
 * @author Aubrey Oosthuizen
 */
@Path("/areas")
@Component
@Scope("request")
//@Singleton
public class AreasResource implements EntityResource {

    @Context
    private UriInfo context;
    @Inject
    AreaService areaService;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public List<AreaDto> getAll() {
        return areaService.findAll();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getPlain() {
        StringBuilder returnString = new StringBuilder();

        for (AreaDto dto : areaService.findAll()) {
            returnString.append(dto);
            returnString.append(" ");
        }

        return returnString.toString();
    }

    @GET
    @Path("area/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public AreaDto getById(@PathParam("id") Integer id) {
        AreaDto dto = areaService.findById(Long.valueOf(id.toString()));
        return dto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public AreaDto postXml(AreaDto dto) {

        URI uri = context.getAbsolutePath();
        Response response;
        AreaDto mapped = new AreaDto();
        mapped.setName(dto.getName() != null ? dto.getName() : "No name");
        mapped.setTerrain(dto.getTerrain()!= null ? dto.getTerrain(): TerrainType.DESERT);
        mapped.setDescription(dto.getDescription() != null ? dto.getDescription() : "No Description");
        try {
            dto.setId(null);
            dto = areaService.save(mapped);
            response = Response.created(URI.create(context.getAbsolutePath() + "/" + dto.getId())).build();
        } catch (Exception ex) {
            response = Response.noContent().build();
        }

        return dto;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putXml(@PathParam("id") Integer id, AreaDto dto) {
        Response response;
        try {
            dto = areaService.update(dto);
            response = Response.ok(dto).build();
        } catch (Exception ex) {
            response = Response.noContent().build();
        }
        return response;
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        AreaDto dto = areaService.findById(Long.valueOf(id));
        if (dto == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        areaService.delete(dto.getId());
        Response response = Response.ok().build();
        return response;
    }

}
