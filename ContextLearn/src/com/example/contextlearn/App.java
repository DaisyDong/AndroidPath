package com.example.contextlearn;

import android.app.Application; 

public class App extends Application{
	private String textData = "DaisyDong";
	
	public void setTextData(String data) {
		this.textData = data; 
	}
	public String getTextData() {
		return this.textData;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		System.out.println("app create");
	}

}
