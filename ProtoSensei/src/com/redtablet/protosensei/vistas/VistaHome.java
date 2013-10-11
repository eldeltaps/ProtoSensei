package com.redtablet.protosensei.vistas;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VistaHome extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View vista = inflater.inflate(R.layout.vista_home, container, false);
		
		MainActivity.actionBar.removeAllTabs();
		MainActivity.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		MainActivity.actionBar.setTitle(R.string.app_name);
		MainActivity.actionBar.setSubtitle(null);

		return vista;
	}
}