package com.example.zoo2;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {
	
	public Location location;
	private Canvas canvas;
	private Bitmap bitmap;
	double stareLat = 0;
	float  i=0;
	
	Canvas canvas1;
	View view1;
	List<Location> positionList;

	public Location setLocation(Location loc){
		return location = loc;
	}
	
	public List<Location> setPosition(List<Location> listPozycja1) {
		return positionList = listPozycja1;
	}
	public PathView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		// TODO Auto-generated constructor stub
		 //  if (bitmap != null) {
	    //        bitmap.recycle();
	    //    }
		//view1 = findViewById(R.id.view2);
       // canvas= new Canvas();
       // bitmap = Bitmap.createBitmap(310, 400, Bitmap.Config.ARGB_8888);
        //canvas.setBitmap(bitmap);
      //  listaPozycji = new ArrayList<Pozycja>();
	}
	
	@Override
	public void onDraw(Canvas c) {
		Paint paint2 = new Paint();
		paint2.setAntiAlias(true);
		paint2.setStyle(Style.FILL);
		paint2.setColor(Color.parseColor("#FF00DD"));
		int x=250,y=250;
	      
		if(location != null)
		{

		     int t = 3;
			//if(location.getLatitude() != stareLat)
				try {
					
		
				     //draw onto the canvas if needed (maybe only the parts of animation that changed)
				     // canvas.drawRect(0,0,10,10,paint);
			
				      //draw the bitmap to the real canvas c
					for (int i = 0; i < positionList.size(); i++) {
						
						if(i>0)
						{
							float bearing = positionList.get(i-1).bearingTo(positionList.get(i));
							if(bearing>0 && bearing<22.5) {
								y+=t;
							}
							else if (bearing>=22.5 && bearing<67.5){
								x+=t;
								y+=t;
							}
							else if (bearing>=67.5 && bearing<112.5){
								x+=t;
							}
							else if (bearing>=112.5 && bearing<157.5){
								x+=t;
								y-=t;
							}
							else if (bearing>=157.5 && bearing<=202.5){
								y-=t;
							}
							else if (bearing>=202.5 && bearing<=247.5){
								x-=t;
								y-=t;
							}
							else if (bearing>=247.5 && bearing<=292.5){
								x-=t;
							}
							else if (bearing>=292.5 && bearing<=337.5){
								x-=t;
								y+=t;
							}
							else if (bearing>=337.5 && bearing<=360){
								y+=t;
							}
						}
					
					 c.drawCircle(x, y, 2, paint2);
							
					}
					
	

					//canvas.save();
					
				}catch (Exception e) {
			        e.printStackTrace();
			    }
			
		}

}
	
}
