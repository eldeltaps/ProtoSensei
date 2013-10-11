package com.redtablet.protosensei.modelos;

import java.io.Serializable;

public class AnuncioDetalle extends AnuncioListado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -903474491319811596L;
	
	private String url;
	private String categoria;
	private String descripcion;
	
	public String getUrl() {
		return url;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
