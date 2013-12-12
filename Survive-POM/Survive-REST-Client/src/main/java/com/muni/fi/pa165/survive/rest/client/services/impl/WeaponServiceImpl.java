/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.services.impl;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.survive.rest.client.services.BaseRestService;
import com.muni.fi.pa165.survive.rest.client.services.CustomRestService;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Auron
 */
public class WeaponServiceImpl extends BaseRestService implements CustomRestService<WeaponDto> {

 
    static final String WEB_TARGET = "weapons/";
    static final String ACCEPT = "accept";

    private Response response;

    public WeaponDto create(WeaponDto dto) {
        WebTarget resourceWebTarget = webTarget.path(WEB_TARGET);
        System.out.println(resourceWebTarget.getUri().toString());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_XML);
        invocationBuilder.header(ACCEPT, HEADER_XML);
        response = invocationBuilder.post(Entity.entity(dto, MediaType.APPLICATION_XML));
        WeaponDto obj = response.readEntity(WeaponDto.class);
        return obj;
    }

    public WeaponDto getById(Long id) {
        WebTarget resourceWebTarget = webTarget.path(WEB_TARGET + id.toString());
        System.out.println(resourceWebTarget.getUri().toString());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header(ACCEPT, HEADER_XML);
       response = invocationBuilder.get();
        //Object entity = response.getEntity();
       WeaponDto obj = response.readEntity(WeaponDto.class);
        return obj;
    }

    public Response update(WeaponDto dto) {
        WebTarget resourceWebTarget = webTarget.path(WEB_TARGET + dto.getId());
        System.out.println(resourceWebTarget.getUri().toString());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_XML);
        invocationBuilder.header(ACCEPT, HEADER_XML);
        response = invocationBuilder.put(Entity.entity(dto, MediaType.APPLICATION_XML));
        return response;
    }

    public Response delete(Long id) {
        WebTarget resourceWebTarget = webTarget.path(WEB_TARGET + id.toString());
        System.out.println(resourceWebTarget.getUri().toString());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
        invocationBuilder.header(ACCEPT, HEADER_JSON);
        response = invocationBuilder.delete();
        return response;
    }

    public List<WeaponDto> getAll() {
        WebTarget resourceWebTarget = webTarget.path(WEB_TARGET + "all");
        System.out.println(resourceWebTarget.getUri().toString());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.accept(MediaType.APPLICATION_XML).get();
        List<WeaponDto> list = response.readEntity(new GenericType<List<WeaponDto>>() {  });
        return list;
    }

    public Response getResponse() {
        return response;
    }
}
