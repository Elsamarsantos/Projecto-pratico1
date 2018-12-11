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

import io.altar.business.ProductBusiness;
import io.altar.dto.ProductDto;
import io.altar.dto.ShelfDto;
import io.altar.model.Product;

@Path("products")
public class ProductServices {
	
	ProductBusiness productBusiness1 = new ProductBusiness();


	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String health() {
		return "Api is working";
	}


	//criar produto	

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDto newProduct(Product product1) {

		productBusiness1.createProduct(product1);
		
		
		return productBusiness1.consultByIdProduct(product1.getId());

	}
	



	//  editar produto	

	@PUT
	@Path ("edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void editProduct(Product editProduct) {

		productBusiness1.editProductByID(editProduct);	
	

	}

	//consultar produto

	@GET
	@Path("consult/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public ProductDto consultProduct (@PathParam("id") long id) {

	
		return productBusiness1.consultByIdProduct(id);

	}

	//remover produto

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteProduct (@PathParam("id") long id) {

		productBusiness1.removeProduct(id);
		

		return "o produto foi removido.";

	}

   //consultar todos pos produtos existentes
	
	@GET
	@Path ("consultall")
	@Produces(MediaType.APPLICATION_JSON)
	public List <ProductDto> consultAllProducts() {
		
		return productBusiness1.consultAllProduct();
	}
	
	
	
	//consultar a lista de prateleiras do produto
	@GET
	@Path ("shelves/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List <ShelfDto> consultShelves(@PathParam("id")long id ) {
		
		
		return productBusiness1.listShelfInProduct(id);
	}
}
