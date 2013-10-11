package com.redtablet.protosensei.manejadores;

import android.widget.TextView;

public class ViewHolder {
	 private TextView titulo;
	    private TextView precio;
	    
	    public TextView getTitulo() {
			return titulo;
		}
		public TextView getPrecio() {
			return precio;
		}
		public void setTitulo(TextView titulo) {
			this.titulo = titulo;
		}
		public void setPrecio(TextView precio) {
			this.precio = precio;
		}
}
