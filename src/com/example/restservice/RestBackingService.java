package com.example.restservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bean.Request;
import com.example.bean.Response;
import com.example.dao.RestBackingServiceDao;

@Path("/RestBackingService")
public class RestBackingService {

	@POST
	   @Path("/insertEmployee")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response insertEmployee(Request request){
		//String result = "Track saved : " + request;
		System.out.println("request : " + request );
		System.out.println("request.getId()" + request.getId());
		RestBackingServiceDao dao = new RestBackingServiceDao();
		Response response = dao.insertData(request);
	      return response;
	}
}
