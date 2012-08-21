package com.soap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class SoapHelper {

	public String getSoapRequest(String NAMESPACE, String METHOD_NAME, String URL, String SOAP_ACTION, LinkedHashMap<String, String> parameters) {
		
		String response = null;
		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			addParameters(parameters, request);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL, 100);
			androidHttpTransport.debug=true; 
			androidHttpTransport.call(SOAP_ACTION, envelope);
			
			String requestString = androidHttpTransport.requestDump;
			Log.d("Request in XML", requestString);
			response = androidHttpTransport.responseDump;
			Log.d("Response in XML", response);
			Log.d("Response in SOAP",envelope.getResponse().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	private void addParameters(LinkedHashMap<String, String> parameters, SoapObject request) {
		Iterator<Entry<String, String>> iterator = parameters.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry = iterator.next();
			request.addProperty(entry.getKey(), entry.getValue());
		}
	}
}
