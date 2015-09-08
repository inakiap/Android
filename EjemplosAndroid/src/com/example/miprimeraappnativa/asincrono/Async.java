package com.example.miprimeraappnativa.asincrono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import android.os.AsyncTask;
import android.util.Log;

public class Async extends AsyncTask<Void, Void, String> {
	
	public final String URL_local = "http://172.16.0.83:8090/ServicioAndroide/ServletAndroid";
	public final String URL_local2 = "http://172.16.1.127:8888/ProyectoParaAndroid/android";

	
	@Override
	protected String doInBackground(Void... params) {
		
		String resp = null;
		BufferedReader in = null;
		HttpURLConnection conexion = null;
		
		try {
			//creamos la conexión
			URL url = new URL(URL_local2);
			conexion = (HttpURLConnection) url.openConnection();
			//al no expecificar el método se llama a get por defecto
			if(conexion.getResponseCode() == 200){
				in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				resp = in.readLine();
				in.close();
			}
		} catch (Exception e) {
			//e.printStackTrace(); esto en Android no se puede hacer hay que pasarlo por el log
			Log.e("Async", e.getMessage());
		}
		finally{
			try {
				in.close();
				conexion.disconnect();
			} catch (IOException e) {
				Log.e("Async", e.getMessage());
			}
		}
		
		return resp;
	}
	
	@Override
	protected void onPostExecute(String result) {
		Log.d("Resultado", result);
		super.onPostExecute(result);
	}

}
