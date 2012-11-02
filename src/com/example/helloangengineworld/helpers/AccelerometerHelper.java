package com.example.helloangengineworld.helpers;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerHelper extends Activity implements SensorEventListener {
	
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	
	public static float TILT_X;
	public static float TILT_Y;
	
	public AccelerometerHelper (Activity activity) {
		//Recupera o sensor
		mSensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
		//Se a lista for diferente de 0, significa que tem sensor
		if (mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			//Recupera o acelerometro
			mAccelerometer = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			//Registra o Listener
			mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
		}
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		//Recupera o evento
		TILT_X = event.values[0];
		TILT_Y = event.values[1];
	}


}
