package com.example.miprimeraappnativa.asincrono;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class AsyncPost extends AsyncTask<Void, Void, String>{

	public final String URL_local = "http://172.16.0.83:8090/ServicioAndroide/ServletAndroid";

	@Override
	protected String doInBackground(Void... params) {
		
		String mensaje = "Mensaje para el servidor"; //esto irá en el body del mensaje
		String resp = null;
		
		HttpURLConnection conexion = null;
		OutputStream out = null;
		BufferedReader in = null;
		
		
		try {
			URL url = new URL(URL_local);
			conexion = (HttpURLConnection) url.openConnection();
			conexion.setDoOutput(true);
			conexion.setRequestMethod("POST");
			conexion.setRequestProperty("Content-type", "text/plain;charset=UTF-8");
			out = conexion.getOutputStream();
			out.write(mensaje.getBytes());
			out.close();
			
			
			if(conexion.getResponseCode() == 200){
				in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				resp = in.readLine();
				in.close();
			}
			//Para adunjtar la info en el body

			
			
		} catch (Exception e) {
			Log.e(super.getClass().getName(), e.getMessage());
		}
		

		return mensaje;
	}
	
	@Override
	protected void onPostExecute(String result) {
		Log.d("Resultado", result);
		super.onPostExecute(result);
	}
}
