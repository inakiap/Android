package com.example.miprimeraappnativa;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ToastListener extends Activity implements OnClickListener{

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch (id) {
		
			case R.id.button1:
				Toast noti1 = Toast.makeText(getApplicationContext(), "Toast Normal", Toast.LENGTH_LONG);
				noti1.show();
			break;
			
			case R.id.button2:
				Toast noti2 = Toast.makeText(getApplicationContext(), "Toast Gravity", Toast.LENGTH_LONG);
				noti2.show();
			break;
				
			case R.id.button3:
				Toast noti3 = Toast.makeText(getApplicationContext(), "Toast Personalizado", Toast.LENGTH_LONG);
				noti3.show();
			break;

		}
		
		
	}


}
