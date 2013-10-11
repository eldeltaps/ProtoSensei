package com.redtablet.protosensei.vistas;

import com.redtablet.protosensei.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class VistaCamposBusqueda extends Fragment {
	private Spinner precioDesde, precioHasta;
	private ArrayAdapter<CharSequence> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
					
		return inflater.inflate(R.layout.frame_campos, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		
		super.onActivityCreated(state);
		
		precioDesde = (Spinner)getView().findViewById(R.id.spinnerPrecioDesde);
		precioHasta = (Spinner)getView().findViewById(R.id.spinnerPrecioHasta);
		
		Bundle args = getArguments();
		Log.d("Sensei","Item: " + args.getInt("cat"));
		
		switch (args.getInt("cat")) {
			case 1: case 2: case 3: case 4:
				adapter = ArrayAdapter.createFromResource(getActivity(),R.array.precio_motor,R.layout.redtablet_spinner_item);
				break;
	
			default:
				adapter = ArrayAdapter.createFromResource(getActivity(),R.array.precio_inmobiliaria,R.layout.redtablet_spinner_item);
				break;
		}
		adapter.setDropDownViewResource(R.layout.redtablet_dropdown_item);
		precioDesde.setAdapter(adapter);
		precioHasta.setAdapter(adapter);
	}
}
