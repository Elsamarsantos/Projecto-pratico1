package io.altar.jseproject.model;

public class Product {
	private int id;
	private Shelf[] listShelfIn;
	private int valorDesconto;
	private int iva;
	private double pvp;
	
	public Product(int id, Shelf[] listShelfIn, int valorDesconto, int iva, double pvp) {
		
		this.id = id;
		this.listShelfIn = listShelfIn;
		this.valorDesconto = valorDesconto;
		this.iva = iva;
		this.pvp = pvp;
	}

	public void int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shelf[] getListShelfIn() {
		return listShelfIn;
	}

	public void setListShelfIn(Shelf[] listShelfIn) {
		this.listShelfIn = listShelfIn;
	}

	public int getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(int valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	

}
