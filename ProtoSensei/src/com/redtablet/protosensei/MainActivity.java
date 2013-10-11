package com.redtablet.protosensei;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.redtablet.protosensei.api.ListarAnuncios;
import com.redtablet.protosensei.vistas.VistaBusqueda;
import com.redtablet.protosensei.vistas.VistaGaleria;
import com.redtablet.protosensei.vistas.VistaHome;

public class MainActivity extends ActionBarActivity implements VistaGaleria.ListadoListener {

	public static FragmentManager fragmentManager;
	public static ActionBar actionBar;
	private String[] opcionesMenu;
	private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    
    private CharSequence tituloSeccion;  
    private CharSequence tituloApp;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getSupportActionBar();
		
		fragmentManager = getSupportFragmentManager();
		
		fragmentManager.beginTransaction()
		.add(R.id.content_frame, new VistaHome())
		.commit();
		
		// NavigatorDarwer
		opcionesMenu = new String[] {"home", "alertas", "favoritos", "nueva búsqueda"};
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        drawerList.setAdapter(new ArrayAdapter<String>(
        		getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opcionesMenu));
        
		drawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Fragment fragment = null;

				switch (position) {
					case 0:
						fragment =  new VistaHome();
						break;
					case 1:
						fragment = new Fragment2();
						break;
					case 2:
						fragment = new Fragment3();
						break;
					case 3:
						fragment = new VistaBusqueda();
						break;
				}

				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, fragment)
						.addToBackStack(null)
						.commit();

				drawerList.setItemChecked(position, true);

				drawerLayout.closeDrawer(drawerList);
			}
		});
		
		tituloSeccion = getTitle();
		tituloApp = getTitle();
		
		drawerToggle = new ActionBarDrawerToggle(this, 
				drawerLayout,
				R.drawable.ic_navigation_drawer, 
				R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(tituloSeccion);
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(tituloApp);
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
		};

		drawerLayout.setDrawerListener(drawerToggle);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		switch(item.getItemId())
		{
			case R.id.action_search:
				
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, new VistaBusqueda())
				.addToBackStack(null)
				.commit();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		
		return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {

		boolean menuAbierto = drawerLayout.isDrawerOpen(drawerList);
		
		if(menuAbierto)
			menu.findItem(R.id.action_search).setVisible(false);
		else
			menu.findItem(R.id.action_search).setVisible(true);
		
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	public void onButtonClick(View vista) {
		mostrarArticulos((Button)vista);
	}
	
	public void mostrarToast(Button btn) {
		Toast.makeText(this,btn.getText().toString(),Toast.LENGTH_SHORT).show();
	}
	
	public void mostrarArticulos(Button btn) {
		ListarAnuncios tareaListar = new ListarAnuncios();
	    tareaListar.execute(btn.getText().toString());
	}



	@Override
	public void onArticuloSeleccionado(String idArticulo) {
		Toast.makeText(this, idArticulo, Toast.LENGTH_SHORT).show();
	}
}