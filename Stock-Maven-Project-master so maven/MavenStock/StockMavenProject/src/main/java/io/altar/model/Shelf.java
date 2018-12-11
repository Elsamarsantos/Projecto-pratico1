package io.altar.model;

public class Shelf extends Entity{
	
	private static final long serialVersionUID = 1L;
	
	
	private int capacidade;
	private Product produtoAlberga;
	private double precoAluguer;
	
	public Shelf(){}
	public Shelf(int capacidade, Product produtoAlberga, double precoAluguer) {
		
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


	@Override
	public String toString() {
		if(produtoAlberga!=null)
		return "Shelf id:"+ this.getId()+" [capacidade:" + capacidade + ", Id do produto que Alberga:" + produtoAlberga.getId() + " preco do Aluguer:"
				+ precoAluguer + "]";
		else
			return "Shelf id:"+ this.getId()+" [capacidade:" + capacidade + ", Id do produto que Alberga: nenhum,"  + " preco do Aluguer:"
			+ precoAluguer + "]";
	}


	
}
