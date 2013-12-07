package com.muni.fi.pa165.survive.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
public class RESTClient 
{
    public static void main( String[] args )
    {
          Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/rest-jersey-server/webresources");
        
        
        WebTarget resourceWebTarget = webTarget.path("customers/json/2");
        
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("accept", "application/json");
        
        Response response = invocationBuilder.get();
        System.out.println("Response : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
    }
}
