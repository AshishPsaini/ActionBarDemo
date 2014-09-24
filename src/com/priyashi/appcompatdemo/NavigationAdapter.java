package com.priyashi.appcompatdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavigationAdapter extends BaseAdapter{
	LayoutInflater mLayoutInflater;
	String [] itemArray;
	
	public NavigationAdapter(Activity activity,String listArray[]) {
		mLayoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
	    this.itemArray=	listArray;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemArray.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {

			convertView = mLayoutInflater.inflate(R.layout.navigation_list_item, parent,false);

			holder = new ViewHolder();
			holder.textView=(TextView) convertView.findViewById(R.id.text1);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(itemArray[arg0]);
		convertView.setBackgroundColor(Color.parseColor("#99cc00")); //default color
	
		return convertView;
	}
	
	static class ViewHolder {
		TextView textView;
	}

}
