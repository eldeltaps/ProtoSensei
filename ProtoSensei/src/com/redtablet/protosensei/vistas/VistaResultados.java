package com.redtablet.protosensei.vistas;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;
import com.redtablet.protosensei.manejadores.AdaptadorTabs;
import com.redtablet.protosensei.modelos.ListaAnuncios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VistaResultados extends Fragment {
	private ViewPager mPager;
	private ListaAnuncios anuncios;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vista = inflater.inflate(R.layout.vista_resultados, container, false);
		return vista;
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		
		super.onActivityCreated(state);
		Bundle args = getArguments();

		anuncios = (ListaAnuncios)args.getSerializable("lista");
		
		MainActivity.actionBar.setTitle(String.valueOf(anuncios.getCuenta()));
		MainActivity.actionBar.setSubtitle("anuncios");
		MainActivity.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		mPager =(ViewPager)getView().findViewById(R.id.pagina_resultados);
		
        ViewPager.SimpleOnPageChangeListener pageListener = new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                MainActivity.actionBar.setSelectedNavigationItem(position);
            }
        };
 
        mPager.setOnPageChangeListener(pageListener);
 
        AdaptadorTabs adaptadorTabs = new AdaptadorTabs(MainActivity.fragmentManager, anuncios);
 
        mPager.setAdapter(adaptadorTabs);
 
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
 
            @Override
            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            }
 
            @Override
            public void onTabSelected(Tab tab, FragmentTransaction ft) {
                mPager.setCurrentItem(tab.getPosition());
            }
 
            @Override
            public void onTabReselected(Tab tab, FragmentTransaction ft) {
            }
        };
 
        Tab tab = MainActivity.actionBar.newTab()
            .setText("Lista")
            .setTabListener(tabListener);
 
        MainActivity.actionBar.addTab(tab);
 
        tab = MainActivity.actionBar.newTab()
            .setText("Galeria")
            .setTabListener(tabListener);
 
        MainActivity.actionBar.addTab(tab);
	}	
}