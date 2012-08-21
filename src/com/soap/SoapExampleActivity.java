package com.soap;

import java.util.LinkedHashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SoapExampleActivity extends Activity {

	private String NAMESPACE = "http://tempuri.org/";
	private String METHOD_NAME = "CelsiusToFahrenheit";
	private String SOAP_ACTION = NAMESPACE+METHOD_NAME;
	private String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SoapHelper helper = new SoapHelper();
        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("Celsius", "22");
	    String response = helper.getSoapRequest(NAMESPACE, METHOD_NAME, URL, SOAP_ACTION, parameters);
	    if(response != null){
	    	Log.d("Response", response);
	    }
    }
}
