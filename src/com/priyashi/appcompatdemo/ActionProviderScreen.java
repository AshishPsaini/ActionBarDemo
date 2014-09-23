package com.priyashi.appcompatdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class ActionProviderScreen extends ActionBarActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	
	/*inflate the menu resource into the given Menu to
	 *  add each item to the action bar:
	 */	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.share_action_provider, menu);

		// Set up ShareActionProvider's default share intent
		MenuItem shareItem = menu.findItem(R.id.action_share);
		ShareActionProvider mShareActionProvider = (ShareActionProvider)
				MenuItemCompat.getActionProvider(shareItem);
		mShareActionProvider.setShareIntent(getDefaultIntent());

		return super.onCreateOptionsMenu(menu);

	}
	
	/** Defines a default (dummy) share intent to initialize the action provider.
	 * However, as soon as the actual content to be used in the intent
	 * is known or changes, you must update the share intent by again calling
	 * mShareActionProvider.setShareIntent()
	 */
	private Intent getDefaultIntent() {

		try {
		
			final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND_MULTIPLE);
			emailIntent.setType("text/plain");
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, 
					new String[]{"emailTo"});
			emailIntent.putExtra(android.content.Intent.EXTRA_CC, 
					new String[]{"emailCC"});
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject"); 
			emailIntent.putExtra(Intent.EXTRA_TEXT, " email body content");
			return emailIntent;
			
		} catch (Exception e) {
			return null;
		}
	}
}
