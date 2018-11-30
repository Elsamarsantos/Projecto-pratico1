package io.altar.mavenproject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/exemplos")
public class EndPoints {
	@Context
	private UriInfo context;
	
	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
	    return "URI " + context.getRequestUri().toString() + " is OK!" + "es um banana";
	}
	
	@GET
	@Path("ola/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloworld(@PathParam("username")String username) {
	    return "Ola ole hello " + username;
	}
}
