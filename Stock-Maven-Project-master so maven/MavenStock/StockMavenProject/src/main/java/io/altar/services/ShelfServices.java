package io.altar.services;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import io.altar.business.ShelfBusiness;
import io.altar.dto.ShelfDto;
import io.altar.model.Shelf;

@Path("shelves")
public class ShelfServices {
	
	ShelfBusiness shelfBusiness1 = new ShelfBusiness();
	
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String health() {
		return "Api is working";
	}

	
	//criar shelf

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void newShelf(Shelf shelf1) {

		shelfBusiness1.createShelf(shelf1);

		

	}


	//  editar shelf	

	@PUT
	@Path ("edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void shelfEdit(Shelf shelf1) {
		
		shelfBusiness1.toeditShelf(shelf1);
		
	}

	//consultar shelf

	@GET
	@Path("consult/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public ShelfDto consultShelf (@PathParam("id") long id) {

	
		return shelfBusiness1.consultShelf(id);

	}

	//remover shelf

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteShelf (@PathParam("id") long id) {

		shelfBusiness1.toRemoveShelf(id);

		return "a prateleira foi removida.";

	}

	@GET
	@Path ("consultall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDto> consultAllShelves() {
		
		return shelfBusiness1.consultAllShelf();
	}



}
