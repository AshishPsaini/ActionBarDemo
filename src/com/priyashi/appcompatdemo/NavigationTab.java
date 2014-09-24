package com.priyashi.appcompatdemo;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.invencible.fragement.FirstTabFragment;
import com.invencible.fragement.SecondTabFragment;

public class NavigationTab extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		  // setup action bar for tabs
	    ActionBar actionBar = getSupportActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(false);

	    Tab tab = actionBar.newTab()
	                       .setText("First Tab")
	                       .setTabListener(new TabListener<FirstTabFragment>(
	                               this, "First tab", FirstTabFragment.class));
	    actionBar.addTab(tab);

	    tab = actionBar.newTab()
	                   .setText("Second Tab")
	                   .setTabListener(new TabListener<SecondTabFragment>(
	                           this, "Second tab", SecondTabFragment.class));
	    actionBar.addTab(tab);

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main_activity_actions, menu);
	    MenuItem searchItem = menu.findItem(R.id.action_search);
	    SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
	 
	    return super.onCreateOptionsMenu(menu);
	}

}
