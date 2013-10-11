package com.redtablet.protosensei.manejadores;

import com.redtablet.protosensei.modelos.ListaAnuncios;
import com.redtablet.protosensei.vistas.VistaGaleria;
import com.redtablet.protosensei.vistas.VistaLista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdaptadorTabs extends FragmentPagerAdapter{

	final int PAGINAS = 2;
	private ListaAnuncios lista;
	
	public AdaptadorTabs(FragmentManager fm, ListaAnuncios lista) {
		super(fm);
		this.lista = lista;
	}

	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		data.putSerializable("lista", lista);
		
        switch(arg0){
 
            case 0:
                VistaLista lista = new VistaLista();
                lista.setArguments(data);
                return lista;
 
            case 1:
                VistaGaleria galeria = new VistaGaleria();
                galeria.setArguments(data);
                return galeria;
        }
		return null;
	}

	@Override
	public int getCount() {
		return PAGINAS;
	}
}
