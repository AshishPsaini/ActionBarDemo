package com.priyashi.appcompatdemo;

import com.priyashi.utils.Utils;

import android.app.Application;

public class YourApplication extends Application{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Utils.changeApplicationTheme(0);
	}

}
