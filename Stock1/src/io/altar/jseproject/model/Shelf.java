package io.altar.jseproject.model;

public class Shelf extends Entity {
	
	private int capacidade;
	private Product produtoAlberga;
	private double precoAluguer;
	

	public Shelf(Long id, int capacidade, Product produtoAlberga, double precoAluguer) {
		super(id);
		this.capacidade = capacidade;
		this.produtoAlberga = produtoAlberga;
		this.precoAluguer = precoAluguer;
	}


	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	public Product getProdutoAlberga() {
		return produtoAlberga;
	}


	public void setProdutoAlberga(Product produtoAlberga) {
		this.produtoAlberga = produtoAlberga;
	}


	public double getPrecoAluguer() {
		return precoAluguer;
	}


	public void setPrecoAluguer(double precoAluguer) {
		this.precoAluguer = precoAluguer;
	}


	

	
	
}
