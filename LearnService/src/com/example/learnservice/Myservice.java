package com.example.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Myservice extends Service{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
