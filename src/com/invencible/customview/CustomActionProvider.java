package com.invencible.customview;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.priyashi.appcompatdemo.R;

public class CustomActionProvider extends ActionProvider{
         Context mContext;
	public CustomActionProvider(Context context) {
		super(context);
		this.mContext=context;
	}
	

	@Override
	public View onCreateActionView() {
		  // Inflate the action view to be shown on the action bar.
	    LayoutInflater layoutInflater = LayoutInflater.from(mContext);
	    View view = layoutInflater.inflate(R.layout.action_provider, null);
	    ImageButton button = (ImageButton) view.findViewById(R.id.imageButton1);
	    button.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	             Toast.makeText(mContext, "Clicked ", Toast.LENGTH_LONG).show();
	        }
	    });
	    return view;

	}
	
	

}
