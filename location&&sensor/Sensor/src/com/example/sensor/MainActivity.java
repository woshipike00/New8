package com.example.sensor;

import java.util.ArrayList;
import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {  
	
	private SensorManager sensorManager;
	//private SensorEventListener sensorEventListener;
	private Button button1,button2,button3,button4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Acquire a reference to the system Sensor Manager
        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
     
        
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);


        button1.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				List<Sensor> devicesensor=sensorManager.getSensorList(Sensor.TYPE_ALL);
				String sensors="";
				for (int i=0;i<devicesensor.size();i++)
					sensors+=devicesensor.get(i).getName()+"\n";
				Toast.makeText(getApplicationContext(),sensors , Toast.LENGTH_SHORT).show();
			}
        	
        });
        button2.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, MotionSensor.class);
				MainActivity.this.startActivity(intent);
			}
        	
        });
        button3.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, PositionSensor.class);
				MainActivity.this.startActivity(intent);
			}
        	
        });
        button4.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, EnvironmentSensor.class);
				MainActivity.this.startActivity(intent);
			}
        	
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
