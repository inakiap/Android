package com.example.miprimeraappnativa;

	import android.app.Activity;
	import android.os.Bundle;
	import android.webkit.WebView;
	import android.webkit.WebViewClient;

	
public class Activity_Juego extends Activity {
	
private WebView browser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juego);
		
		browser = (WebView)findViewById(R.id.webView);
	    browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setBuiltInZoomControls(true);
        browser.loadUrl("http://codigonatura.com/juego/");
        
        browser.setWebViewClient(new WebViewClient() {
            // evita que los enlaces se abran fuera nuestra app en el navegador de android
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                return false;
            }   
        });
	}
        
    @Override
    public void onBackPressed()
    {
        if (browser.canGoBack())
        {
            browser.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
	
}
