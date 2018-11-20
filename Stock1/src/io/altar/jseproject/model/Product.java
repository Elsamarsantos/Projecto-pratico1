package io.altar.jseproject.model;

import java.util.Arrays;

public class Product extends Entity {
	
	private Shelf[] listShelfIn;
	private double valorDesconto;
	private double iva;
	private double pvp;
	
	public Product(Shelf[] listShelfIn, double valorDesconto, double iva, double pvp) {
		
		this.listShelfIn = listShelfIn;
		this.valorDesconto = valorDesconto;
		this.iva = iva;
		this.pvp = pvp;
	}

	public Shelf[] getListShelfIn() {
		return listShelfIn;
	}

	public void setListShelfIn(Shelf[] listShelfIn) {
		this.listShelfIn = listShelfIn;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	@Override
	public String toString() {
		return "Product"+this.getId()+" [listShelfIn=" + Arrays.toString(listShelfIn) + ", valorDesconto=" + valorDesconto + ", iva="
				+ iva + ", pvp=" + pvp + "]";
	}
	
	

}
