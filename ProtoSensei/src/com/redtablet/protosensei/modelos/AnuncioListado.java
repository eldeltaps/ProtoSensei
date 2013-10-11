package com.redtablet.protosensei.modelos;

import java.io.Serializable;

public class AnuncioListado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5453389262538999069L;

	private String id;
	private String nombre;
	private String precio;
	
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
}
