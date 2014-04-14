package com.example.zooprototype;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MyLocationListener extends Activity implements LocationListener {

	
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    String bestProvider = locationManager.getBestProvider(criteria, false);
    Location location;
    Double lat,lon;
    TextView latTextView = (TextView)findViewById(R.id.textView1);
    TextView lonTextView = (TextView)findViewById(R.id.textView2);
    
    public void getLocation(){
    	
    	location = locationManager.getLastKnownLocation(bestProvider);
    }

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
		int latitude = (int) (location.getLatitude());
	    int longitude = (int) (location.getLongitude());

	    latTextView.setText(latitude);
	    lonTextView.setText(longitude);
	    
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
