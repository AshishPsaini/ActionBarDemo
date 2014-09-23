package com.priyashi.appcompatdemo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;

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

}
