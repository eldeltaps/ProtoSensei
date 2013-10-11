package com.redtablet.protosensei.manejadores;

import java.util.ArrayList;

import com.redtablet.protosensei.R;
import com.redtablet.protosensei.modelos.AnuncioListado;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdaptadorListado extends BaseAdapter {
	 
	private ArrayList<AnuncioListado> lista;
	private LayoutInflater inflater = null;
     
	/**
	 * Construcctor del adaptador
	 * @param arrayList
	 * 		ArrayList de anuncios
	 */
    public AdaptadorListado(Context context, ArrayList<AnuncioListado> arrayList) {
    	Log.d("Sensei", "Adaptador preparado");
    	this.lista = arrayList;
		inflater = LayoutInflater.from(context);
    }
 
	@Override
    public View getView(int position, View convertView, ViewGroup parent) throws NullPointerException {
		
		ViewHolder holder;
		if (convertView == null) {
	         
            convertView = inflater.inflate(R.layout.item_lista_articulos, null);
            
            holder = new ViewHolder();
            holder.setPrecio((TextView) convertView.findViewById(R.id.precio_articulo_lista));
            holder.setTitulo((TextView) convertView.findViewById(R.id.nombre_articulo_lista));
          
            convertView.setTag(holder);
		} else {
            holder = (ViewHolder) convertView.getTag();
        }
      
        AnuncioListado anuncio = (AnuncioListado)getItem(position);
        
        if (anuncio.getPrecio().equals("0")) {
        	holder.getPrecio().setText("A consultar");
        } else {
        	holder.getPrecio().setText(anuncio.getPrecio());
        }
        holder.getTitulo().setText(anuncio.getNombre());
                   
        // Faltaria a�adir imagenes si las hay, etc, pero se hace igual
	                  
        return convertView;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	    
    public void actualizar(ArrayList<AnuncioListado> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }
}