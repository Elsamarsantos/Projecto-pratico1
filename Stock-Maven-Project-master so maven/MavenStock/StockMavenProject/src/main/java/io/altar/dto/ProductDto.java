package io.altar.dto;

import io.altar.model.Entity;

public class ProductDto extends Entity{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private double valorDesconto;
	private double iva;
	private double pvp;
	
	public ProductDto(Long id, double valorDesconto, double iva, double pvp) {
		this.id=id;
		this.valorDesconto = valorDesconto;
		this.iva = iva;
		this.pvp = pvp;
	}	

	public ProductDto() {}


	public Long getId() {
		return id;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}


	public double getIva() {
		return iva;
	}


	public double getPvp() {
		return pvp;
	}
	

}
