package com.priyashi.appcompatdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.priyashi.utils.Utils;

public class MainActivity extends ActionBarActivity {

	//Filed member name should be start with m
	String mArrayOfOptions [] = {"PopUp Menu","Action Provider" ,"Custom Action Provider","MultiSelect List", "Home Key up down "};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Utils.onActivityCreateSetTheme(this);
		
		/*Beware that hiding and removing the action bar causes your activity 
		to re-layout in order to account for the space consumed by the action bar. 
		If your activity often hides and shows the action bar, you might want to enable overlay mode.
		Overlay mode draws the action bar in front of your activity layout, obscuring the top portion. 
		This way, your layout remains fixed when the action bar hides and re-appears. 
		To enable overlay mode, create a custom theme for your activity and set windowActionBarOverlay to true.*/
		
		
		/*Removing the action bar* /
		 * only two lines enough
		 */
		
		/*ActionBar actionBar = getSupportActionBar();
		 * 
		 * 
		actionBar.hide();*/
		
		setContentView(R.layout.activity_main);
		ListView list=(ListView) findViewById(R.id.mainactivty_listView);

		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,mArrayOfOptions);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				goToNextScreen(arg2);
			
			}
		});
	}

	protected void goToNextScreen(int arg2) {
	Intent intent=null;
			switch (arg2) {
			case 0:
				// Popup Menu intent 
				intent=new Intent(MainActivity.this,PopUpMenuActivity.class);
				break;

			case 1:
				//Action provider Screen 
				intent=new Intent(MainActivity.this,ActionProviderScreen.class);
				break;
				
			case 2:
				//Action provider Screen 
				intent=new Intent(MainActivity.this,CustomActionProviderScreen.class);
				break;
				
			case 3:
				//Action provider Screen 
				intent=new Intent(MainActivity.this,MultiSelectList.class);
				break;
			default:
				//This is default
				intent=new Intent(MainActivity.this,PopUpMenuActivity.class);
				break;
			}
			
			startActivity(intent);
			
	}

	
}
