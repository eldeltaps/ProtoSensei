package com.redtablet.protosensei.vistas;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;
import com.redtablet.protosensei.manejadores.ItemSelectedListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class VistaBusqueda extends Fragment{
	private Spinner categorias;
	private EditText txtBuscar;
	private Button buscar;
	
	private String categoria;
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
					
		return inflater.inflate(R.layout.vista_buscar, container, false);
	}
		
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		categorias = (Spinner)getView().findViewById(R.id.spinnerCategoria);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.categorias,R.layout.redtablet_spinner_item);
		adapter.setDropDownViewResource(R.layout.redtablet_dropdown_item);
		
		categorias.setAdapter(adapter);
		
		categorias.setOnItemSelectedListener( new ItemSelectedListener());
	}
}
