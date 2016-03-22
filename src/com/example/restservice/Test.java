package com.example.restservice;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import com.example.bean.Request;


public class Test {

	public static void main(String[] args) {
	    ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient();

	    Request request = new Request();
	    request.setId("10609000");
        request.setFirstName("Test");
        request.setLastName("Test");
        request.setAddress("Test");
        request.setCity("Test");
        request.setMobile("Test");
        request.setMail("Test");
		request.setGender("M");
        request.setKyc("Test");
        System.out.println("Request : " + request.toString());
	    
        WebTarget target = client.target(getBaseURI());
        Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
        String response = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON)).readEntity(String.class);
        //String output = response.readEntity(String.class);
        String JsonResonse = new String();
        ////System.out.println(response.getStatus());
       // System.out.println(JsonResonse = response.readEntity(String.class));
        /*String JsonResponse = response.getEntity().toString();*/
        System.out.println("JsonResponse : " + JsonResonse);
        System.out.println("output : " + response);
	    /*WebTarget target = client.target(getBaseURI());

	    String response = target.path("RestBackingService").
	              path("insertEmployee").
	              request().
	              accept(MediaType.APPLICATION_JSON).
	              get(Response.class)
	              .toString();
	    System.out.println(target.path("RestBackingService").path("users").request().accept(MediaType.TEXT_PLAIN).get(String.class));*/
	}
	 private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/BackingRestService/rest/RestBackingService/insertEmployee").build();
		  }
	
}
