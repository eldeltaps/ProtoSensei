package com.redtablet.protosensei.vistas;

import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;
import com.redtablet.protosensei.manejadores.AdaptadorListado;
import com.redtablet.protosensei.modelos.AnuncioListado;
import com.redtablet.protosensei.modelos.ListaAnuncios;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class VistaListado extends Fragment {
	
	private ListaAnuncios anuncios;
	private AdaptadorListado adaptador;
	private ListView lista;
	
	private ListadoListener mCallback;
	
		// Interface que la Activity contenedora debe implementar
		// para poder tener comunicación
		public interface ListadoListener {
	        void onArticuloSeleccionado(String idArticulo);
	    }
			
		@Override
		public View onCreateView(LayoutInflater inflater, 
				                 ViewGroup container, 
				                 Bundle savedInstanceState) {
						
			return inflater.inflate(R.layout.view_galeria, container, false);
		}
			
		@Override
		public void onActivityCreated(Bundle state) {
			
			super.onActivityCreated(state);
					    			
			Bundle args = getArguments();
			
			// Recuperamos los anuncios a mostrar que se paso como
			// argumento al actualizar el fragment desde el MainActivity
			anuncios = (ListaAnuncios)args.getSerializable("lista");
			
			lista = (ListView)getView().findViewById(R.id.lista_articulos);
			Log.v("Sensei","Numero de anuncios: "+ anuncios.getCuenta());
			MainActivity.actionBar.setTitle(anuncios.getCuenta());
			MainActivity.actionBar.setSubtitle("anuncios");
					
			adaptador = new AdaptadorListado(getActivity(),anuncios.getAnuncios());
			
			lista.setAdapter(adaptador);
			
			lista.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> a , View v, int pos, long id) {
					// TODO Auto-generated method stub
					// Campo "id" del articulo seleccionado
					String articuloSeleccionado = ((AnuncioListado)a.getAdapter().getItem(pos)).getId();
			    	Log.v("Opcion seleccionada", articuloSeleccionado);
			    	
			    	// Llamamos al método que implementa la Activity pasandole
			    	// la posicion del elemento que hemos pulsado
			    	// que sera recogido por el MainActivity para mostrar la tabla correspondiente
			    	mCallback.onArticuloSeleccionado(articuloSeleccionado);
				}
			});
		}

		
		@Override
		public void onAttach(Activity activity) {
			// TODO Auto-generated method stub
			super.onAttach(activity);
			
			// Inicializamos nuestra variable de referencia del tipo
			// ListadoListener junto con el valor del objeto
			// activity que debe ser una Activity que implemente esta interface
			try {
				mCallback = (ListadoListener) activity;
			} catch (ClassCastException e) {
				Log.d("ClassCastException", "La Activity debe implementar esta Interface");
			}
		}
}
