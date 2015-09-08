package com.example.miprimeraappnativa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Activity_noti extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificacion);
		String strecivved = getIntent().getStringExtra("contigo");
		Log.e("mensaje recibido", strecivved);
	}
}



