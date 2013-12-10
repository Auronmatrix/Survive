/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Auron
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {
 
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.muni.fi.pa165.rest.EntityResource.class);
        resources.add(com.muni.fi.pa165.rest.WeaponsResource.class);
    }
}
