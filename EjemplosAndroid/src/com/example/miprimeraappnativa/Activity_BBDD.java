package com.example.miprimeraappnativa;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity_BBDD extends Activity{
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) 
//	{
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //Abrimos la base de datos 'bdAndroid' en modo escritura
//        BBDDSQLite crearBD = new BBDDSQLite(this, "bdAndroid", null, 1);
//        SQLiteDatabase bd = crearBD.getWritableDatabase();
//      
//        //Si hemos abierto correctamente la base de datos
//        if (null != bd){
//        	//Insertamos 5 usuarios de ejemplo
//	        for (int i = 0; i<6 ; i++){
//	        	int cod = i;
//	        	String nombre = "user" + i;
//	        	
//	        bd.execSQL("INSERT INTO Usuarios (codigo, nombre) VALUES ("+cod+",'"+nombre+"')");	
//	        }
//        }
//        bd.close();
//	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView txtcontactos = (TextView) findViewById(R.id.txtregistro);
		BBDDSQLite usdbh =
	           new BBDDSQLite(this, "bdAndroid", null, 1);
	 
	       SQLiteDatabase db = usdbh.getWritableDatabase();
		
		Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
		
		Log.d("Ndatos", c.getCount()+"");
		StringBuffer datos = new StringBuffer();
		
		if (c.moveToFirst()) {
		    //Recorremos el cursor hasta que no haya más registros
		    do {
		         String codigo= c.getString(0);
		         String nombre = c.getString(1);
		         datos.append("codigo y nombre ");
					datos.append(codigo + " " + nombre);
					datos.append("\n");
		    } while(c.moveToNext());
		}
		
		c.close();
		txtcontactos.setText(datos);
	}

	
}
