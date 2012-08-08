package com.soap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class SoapHelper {

	public Object getSoapRequest(String NAMESPACE, String METHOD_NAME, String URL, String SOAP_ACTION) {
		
		Object object = null;
		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("Celsius", "22");
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL, 100);
			androidHttpTransport.debug=true; 
			androidHttpTransport.call(SOAP_ACTION, envelope);
			
			String requestString = androidHttpTransport.requestDump;
			Log.d("Request in XML", requestString);
			String response = androidHttpTransport.responseDump;
			object = envelope.getResponse();
			Log.d("Response in XML", response);
			Log.d("Response in SOAP",object.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
