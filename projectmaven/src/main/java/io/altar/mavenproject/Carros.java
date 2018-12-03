package io.altar.mavenproject;

import java.io.Serializable;

public class  Carros implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private int portas;
	private String marca;
	public Carros () {
		
	}


	public Carros(long id, int portas, String marca) {
		super();
		this.id = id;
		this.portas = portas;
		this.marca = marca;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Carros [id=" + id + ", portas=" + portas + ", marca=" + marca + "]";
	}
	



}
