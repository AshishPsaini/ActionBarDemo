package com.priyashi.appcompatdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MultiSelectAdapter extends BaseAdapter{
	private SparseBooleanArray mSelectedItemsIds;
	private Activity mActivity;
	private ArrayList<String> mArrayList;
	private LayoutInflater mLayoutInflater;
	public MultiSelectAdapter(Activity activity,ArrayList<String> list) {
		this.mArrayList=list;
		this.mActivity=activity;
		mLayoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mArrayList.size();
	}

	@Override
	public String getItem(int arg0) {
		// TODO Auto-generated method stub
		return mArrayList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public View getView(final int arg0, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {

			convertView = mLayoutInflater.inflate(R.layout.multiselect_item, parent,false);

			holder = new ViewHolder();
			holder.textView=(TextView) convertView.findViewById(R.id.textView1_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(mArrayList.get(arg0));
		convertView.setBackgroundColor(Color.parseColor("#99cc00")); //default color
		if(mSelectedItemsIds!=null&&mSelectedItemsIds.get(arg0)) {
			convertView.setBackgroundColor(Color.RED);
		}
		return convertView;
	}


	public void remove(String object) {
		mArrayList.remove(object);

		notifyDataSetChanged();
	}

	/* public List<PropertyPicModel> getWorldPopulation() {
	        return listProperty;
	    }*/

	public void toggleSelection(int position) {
		try {
			selectView(position, !mSelectedItemsIds.get(position));
		} catch (Exception e) {
			Log.e( "Excep  toggleSelection ",e.toString());
		}
	}

	public void removeSelection() {
		mSelectedItemsIds = new SparseBooleanArray();
		notifyDataSetChanged();
	}

	public void selectView(int position, boolean value) {
		if (value) {
			mSelectedItemsIds.put(position, value);

		}
		else {
			mSelectedItemsIds.delete(position);
			
		}
		notifyDataSetChanged();
	}

	public int getSelectedCount() {
		return mSelectedItemsIds.size();
	}

	public SparseBooleanArray getSelectedIds() {
		return mSelectedItemsIds;
	}

	static class ViewHolder{


		TextView  textView;

	}

}
