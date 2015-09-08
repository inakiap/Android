package com.example.miprimeraappnativa;

	import java.util.concurrent.ExecutionException;

import com.example.miprimeraappnativa.asincrono.AsyncPost;

	import android.support.v4.app.NotificationCompat;
import android.app.Activity;
//	import android.support.v7.app.ActionBarActivity;
//	import android.support.v7.app.AppCompatActivity;
	import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

	public class MainActivity2 extends Activity {

		
		
		private String dada () throws InterruptedException, ExecutionException
		{
			AsyncPost csp = new AsyncPost();
			return csp.execute(null, null, null).get();
		}
		
		private void notifica (String trucazo)
		{
			Log.d("NOT", "Vamos a preparar...: ");
			NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
			Intent i = new Intent(this, Activity_noti.class);
			i.putExtra("contigo", "Esto es para ti");
			PendingIntent contentIntent = PendingIntent.getActivity(this, 0, i, 0);

			//creamos la notificaci�n con builder, sus caracter�sticas y a que actividad hay que saltar
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
					this).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("frescas Noticias")
					.setStyle(new NotificationCompat.BigTextStyle().bigText(trucazo))
					.setContentText(trucazo);

			mBuilder.setContentIntent(contentIntent);
			mBuilder.setAutoCancel(true);//Cuando el usuario pulse la notificaci�n, desaparecer�
			mNotificationManager.notify(345, mBuilder.build());//ID notificaci�n, internatmente es un n�mero que le debemos dar
			Log.d("NOT", "Notiificacion enviada.");
		}
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			
			try {
				notifica (dada());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

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
			
			return super.onOptionsItemSelected(item);
		}
	}
