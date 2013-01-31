package com.soap;

import java.util.LinkedHashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SoapExampleActivity extends Activity {

	private String NAMESPACE = "http://predic8.com/wsdl/material/ArticleService/1/";
	private String METHOD_NAME = "getAll";
	private String SOAP_ACTION = NAMESPACE+METHOD_NAME;
	private String URL = "http://www.predic8.com:8080/material/ArticleService";
	
	String response = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				SoapHelper helper = new SoapHelper();
				LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
				response = helper.getSoapRequest(NAMESPACE, METHOD_NAME, URL, SOAP_ACTION, parameters);
				Log.d("Response", response);
			}
		}).start();
    }
}
