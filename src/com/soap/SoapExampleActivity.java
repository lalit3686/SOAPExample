package com.soap;

import android.app.Activity;
import android.os.Bundle;

public class SoapExampleActivity extends Activity {

	public static int counter = 0;
	public static String response = ""; 
	SoapHelper helper;
	private String NAMESPACE = "http://tempuri.org/";
	private String METHOD_NAME = "CelsiusToFahrenheit";
	private String SOAP_ACTION = NAMESPACE+METHOD_NAME;
	private String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        helper = new SoapHelper();
	    helper.getSoapRequest(NAMESPACE, METHOD_NAME, URL, SOAP_ACTION);
    }
}
