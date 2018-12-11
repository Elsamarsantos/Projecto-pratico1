package io.altar.dto;


import io.altar.model.Product;

public class ShelfDto {
	//private static final long serialVersionUID = 1L;
	private Long id;
	
	private int capacidade;
	private Product produtoAlberga;
	private double precoAluguer;
	public ShelfDto(Long id, int capacidade, Product produtoAlberga, double precoAluguer) {
		this.id= id;
		this.capacidade = capacidade;
		this.produtoAlberga = produtoAlberga;
		this.precoAluguer = precoAluguer;
	}
	
	public ShelfDto(Long id, int capacidade, double precoAluguer) {
		this.id= id;
		this.capacidade = capacidade;

		this.precoAluguer = precoAluguer;
	}
	
	
	
	public ShelfDto() {}
	
	
	public long getId() {
		return id;
	}


	public int getCapacidade() {
		return capacidade;
	}
	
	public Product getProdutoAlberga() {
		return produtoAlberga;
	}
	
	public double getPrecoAluguer() {
		return precoAluguer;
	}
	
	

}
