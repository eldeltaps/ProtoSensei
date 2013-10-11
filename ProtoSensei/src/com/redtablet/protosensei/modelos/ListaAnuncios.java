package com.redtablet.protosensei.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaAnuncios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3478085126749661563L;
	private static ListaAnuncios instance;
	private ArrayList<AnuncioListado> anuncios;
	private int cuenta;

	public static ListaAnuncios obtenerInstancia()  {
	    if (instance == null) instance = new ListaAnuncios();
	    return instance;
	}
	
	public void addAnuncio(AnuncioListado paramAnuncioListado) {
	    this.anuncios.add(paramAnuncioListado);
	}

	public AnuncioListado getAnuncio(int paramInt) {
	    return (AnuncioListado)this.anuncios.get(paramInt);
	}

	public ArrayList<AnuncioListado> getAnuncios() {
		return anuncios;
	}

	public int getCuenta() {
		cuenta = anuncios.size();
		return cuenta;
	}

	public void setAnuncios(ArrayList<AnuncioListado> anuncios) {
		this.anuncios = anuncios;
	}
}
