package com.example.miprimeraappnativa;

import com.example.miprimeraappnativa.asincrono.AsyncPost;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	public static EditText textoUsuario;
	public static TextView mostrarTexto;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //código para ver el servicio creado
        AsyncPost mget = new AsyncPost();
        mget.execute();
        
        
        //código para dar la vuelta al texto
        Button boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new ProcesarEventos());
        textoUsuario = (EditText) findViewById(R.id.editText1);
        mostrarTexto = (TextView) findViewById(R.id.textView2);
        
      //Abrimos la base de datos 'bdAndroid' en modo escritura
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
        
        //código para imprimir las filas de la bd en la pantalla
//        TextView txtcontactos = (TextView) findViewById(R.id.txtregistro);
//		BBDDSQLite usdbh = new BBDDSQLite(this, "bdAndroid", null, 1);
//	 
//	    SQLiteDatabase db = usdbh.getWritableDatabase();
//		
//		Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
//		
//		Log.d("Ndatos", c.getCount()+"");
//		StringBuffer datos = new StringBuffer();
//		
//		if (c.moveToFirst()) {
//		    //Recorremos el cursor hasta que no haya más registros
//		    do {
//		         String codigo= c.getString(0);
//		         String nombre = c.getString(1);
//		         datos.append("codigo y nombre ");
//					datos.append(codigo + " " + nombre);
//					datos.append("\n");
//		    } while(c.moveToNext());
//		}
//		
//		c.close();
//		txtcontactos.setText(datos);
    }

    //Estos dos métodos siguientes tienen que ver con el menú de la barra (depende de la versión para que aparezca)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
        switch(id){
        	case R.id.action_close: finish();
        		break;
    		
        	case R.id.action_1: 
    			Intent cn = new Intent("android.intent.action.VIEW", Uri.parse("http://codigonatura.com"));
    			startActivity(cn);
    			break;
    			
        	case R.id.action_2:
    			Intent juego = new Intent(this, Activity_Juego.class);
    			startActivity(juego);
    			break;
    			
        	case R.id.action_3: 
    			Intent d = new Intent("android.intent.action.VIEW", Uri.parse("http://www.eldiario.es"));
    			startActivity(d);
    			break;
    		
        	case R.id.action_4:
        		Intent e = new Intent(this, ToastListener.class);
        		startActivity(e);
    			break;
        }
        
		return super.onOptionsItemSelected(item);
    }
    
		
}
