package com.priyashi.appcompatdemo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MultiSelectList extends ActionBarActivity {

	private ArrayList<String> mList;
	private ListView mListView;
	private MultiSelectAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.multiselect_screen);
		mListView=(ListView) findViewById(R.id.mainactivty_listView);
		mList=new ArrayList<String>(100);
		for(int x=0;x<100;x++)
		{
			mList.add(""+x);
		}
		mAdapter=new MultiSelectAdapter(this,mList);
		mListView.setAdapter(mAdapter);
		mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

		// Capture ListView item click
		mListView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
			@Override
			public boolean onActionItemClicked(android.view.ActionMode mode,
					MenuItem item) {
				switch (item.getItemId()) {
				case R.id.delete:
					// Calls getSelectedIds method from ListViewAdapter Class
					SparseBooleanArray selected = mAdapter.getSelectedIds();

					// Captures all selected ids with a loop
					for (int i = (selected.size() - 1); i >= 0; i--) {
						try {
							if (selected.valueAt(i)) {
								Log.e("Sparse key ",""+selected.keyAt(i));
								mAdapter.remove(mAdapter.getItem(selected.keyAt(i)));

							}
						} catch (Exception e) {
							Log.e("Excep in For Loop  ",e.toString());
						}
					}
					// Close CAB
					mode.finish();



					return true;
				default:
					return false;
				}

			}

			@SuppressLint("NewApi")
			@Override
			public boolean onCreateActionMode(android.view.ActionMode mode,
					Menu menu) {
				mAdapter.removeSelection();

				mode.getMenuInflater().inflate(R.menu.menu_delete_list_item_action, menu);
				return true;
			}

			@Override
			public void onDestroyActionMode(android.view.ActionMode arg0) {

			}

			@Override
			public boolean onPrepareActionMode(android.view.ActionMode arg0,
					Menu arg1) {

				return false;
			}

			@Override
			public void onItemCheckedStateChanged(android.view.ActionMode mode,
					int position, long id, boolean checked) {

				// Capture total checked items
				final int checkedCount = ((AbsListView) mListView).getCheckedItemCount();
				// Set the CAB title according to total checked items
				mode.setTitle(checkedCount + " Selected");
				// Calls toggleSelection method from ListViewAdapter Class
                     if(checked){
                  
                     }
				mAdapter.toggleSelection(position);
			}
		});



	}
	
	
	 /** Callback function */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /** Create an option menu from res/menu/items.xml */
        getMenuInflater().inflate(R.menu.custom_action_view, menu);
 
        /** Get the action view of the menu item whose id is search */
        View v = (View) menu.findItem(R.id.search).getActionView();
 
        /** Get the edit text from the action view */
        EditText txtSearch = ( EditText ) v.findViewById(R.id.txt_search);
 
        /** Setting an action listener */
        txtSearch.setOnEditorActionListener(new OnEditorActionListener() {
 
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(getBaseContext(), "Search : " + v.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
 
        return super.onCreateOptionsMenu(menu);
    }
	

}
