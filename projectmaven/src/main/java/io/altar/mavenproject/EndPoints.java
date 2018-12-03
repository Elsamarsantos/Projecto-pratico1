package io.altar.mavenproject;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/carros")
public class EndPoints {
	
	private static Map <Long,Carros> carro = new HashMap<Long,Carros>();
	
	private static long idAtual=0;
	
	
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
	
	
	@POST
	@Consumes ("application/json")
	@Produces ("application/json")
	public Carros createCar(Carros carros) {

		carros.setId(idAtual);
		carro.put(carros.getId(),carros);
		idAtual++;
		return carros;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Carros getById(@PathParam("id")long id){

		return carro.get(id);
	}

	@GET
	@Path("/size")
	@Produces(MediaType.TEXT_PLAIN)
	public int getSize(){

		return carro.size();
	}

	
	
}
