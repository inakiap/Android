package com.example.miprimeraappnativa;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ProcesarEventos implements OnClickListener {

	@Override
	public void onClick(View v) {
		// aquí lo que pega es un switch que vaya repartiendo el la actividad según del elemento que haya tocado, pero en este caso no
		String mitexto = MainActivity.textoUsuario.getText().toString();
		String textoFinal = voltearElTexto(mitexto);
		MainActivity.mostrarTexto.setText(textoFinal);
	}
	
	private String voltearElTexto (String texto){
		String resultado = "";
		
		for(int i = texto.length() -1; i>=0 ; i--){
			
			resultado = resultado + texto.charAt(i); 	
		}
		
		return resultado;
	}
}
