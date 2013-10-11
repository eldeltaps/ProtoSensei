package com.redtablet.protosensei.vistas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;

public class VistaSinResultados extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View vista = inflater.inflate(R.layout.vista_sin_resultados, container, false);
		
		MainActivity.actionBar.removeAllTabs();
		MainActivity.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		MainActivity.actionBar.setTitle("0");
		MainActivity.actionBar.setSubtitle("anuncios");

		return vista;
	}
}