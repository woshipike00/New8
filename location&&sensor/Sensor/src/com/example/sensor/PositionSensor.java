package com.example.sensor;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PositionSensor extends Activity implements SensorEventListener{
	
	private Button button1;
	private TextView textView;
	private SensorManager sensorManager;
	private Sensor sensor;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		button1=(Button)findViewById(R.id.button1);
		textView=(TextView)findViewById(R.id.textView1);
		button1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(PositionSensor.this, MainActivity.class);
				PositionSensor.this.startActivity(intent);
			}
			
		});
		
		sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
	}
	
	protected void onResume(){
		super.onResume();
	    sensorManager.registerListener(this, sensor , SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	protected void onPause(){
		super.onPause();
		sensorManager.unregisterListener(this,sensor);
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		String result="Azimuth: "+event.values[0]+"\n"+
				      "Pitch:   "+event.values[1]+"\n"+
				      "Roll:    "+event.values[2]+"\n";
		textView.setText(result);
	}
	
	

}

