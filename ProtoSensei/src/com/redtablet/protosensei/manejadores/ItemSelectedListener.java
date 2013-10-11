package com.redtablet.protosensei.manejadores;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;
import com.redtablet.protosensei.vistas.VistaCamposBusqueda;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		if(parent.getId() == R.id.spinnerCategoria) {
			String categoria = (String) parent.getItemAtPosition(pos);
			Log.d("Sensei","Categoria " + categoria);
			Log.d("Sensei","Item: " + pos);
			if(pos != 0) {
				Bundle args = new Bundle();
				args.putInt("cat", pos);
				
				VistaCamposBusqueda campos = new VistaCamposBusqueda();
				campos.setArguments(args);
				
				MainActivity.fragmentManager.beginTransaction()
				.add(R.id.campos_frame, campos)
				.addToBackStack(null)
				.commit();
			}
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
