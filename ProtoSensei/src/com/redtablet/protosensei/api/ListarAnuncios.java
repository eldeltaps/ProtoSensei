package com.redtablet.protosensei.api;

import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.redtablet.protosensei.MainActivity;
import com.redtablet.protosensei.R;
import com.redtablet.protosensei.modelos.ListaAnuncios;
import com.redtablet.protosensei.vistas.VistaProgressDialog;
import com.redtablet.protosensei.vistas.VistaResultados;
import com.redtablet.protosensei.vistas.VistaSinResultados;

public class ListarAnuncios extends AsyncTask<String, Void, String> {
	
	
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		MainActivity.fragmentManager.beginTransaction()
		.replace(R.id.content_frame, new VistaProgressDialog())
		.addToBackStack(null)
		.commit();
	}

	@Override
	protected String doInBackground(String... params) {
		String urlServer =  "http://10.0.2.2/sensei/categoria/";
		String url = urlServer + params[0];
		Log.d("Sensei", "Url: " + url);
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet del = new HttpGet(url);
		del.setHeader("content-type", "application/json");
		
		HttpResponse resp;
		String respStr="";
		try {
			resp = httpClient.execute(del);
			respStr = EntityUtils.toString(resp.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
		Log.d("Sensei", "Json: " + respStr);
		return respStr;
	}
	
	@Override
	protected void onPostExecute(String result) {
		ListaAnuncios lista = null;
		if(result.equals("")){
			
		} else {
			Type collectionType = new TypeToken<ListaAnuncios>(){}.getType();
	       	lista = new Gson().fromJson(result, collectionType);
	       	if(lista.getCuenta() != 0) {
	       		VistaResultados resultados = new VistaResultados();
		       	Bundle args = new Bundle();
		    
				args.putSerializable("lista", lista);
				resultados.setArguments(args);
				       				
				MainActivity.fragmentManager.beginTransaction()
				.replace(R.id.content_frame, resultados)
				.addToBackStack(null)
				.commit();
	       	} else {
	       		VistaSinResultados noResultados = new VistaSinResultados();
		       
	       		MainActivity.fragmentManager.beginTransaction()
				.replace(R.id.content_frame, noResultados)
				.addToBackStack(null)
				.commit();
	       	}
		}
    }
}
