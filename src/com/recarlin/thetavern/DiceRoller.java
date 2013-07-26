package com.recarlin.thetavern;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class DiceRoller extends Fragment
{
	public static Activity act;
	public static Context con;
	public static Spinner typeSpinner;
	public static Spinner amountSpinner;
	
	public DiceRoller() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.dr, null);
	    
		act = getActivity();
		con = act.getApplicationContext();
		typeSpinner = (Spinner) act.findViewById(R.id.pickType);
		amountSpinner = (Spinner) act.findViewById(R.id.pickAmount);
		
		ArrayAdapter<CharSequence> typeAdpt = ArrayAdapter.createFromResource(con, R.array.dice_types, android.R.layout.simple_spinner_item);
		typeAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		try {
			typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				Log.i("TYPE", arg0.getItemAtPosition(arg2).toString());
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
			}
		});
			typeSpinner.setAdapter(typeAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> amountAdpt = ArrayAdapter.createFromResource(con, R.array.dice_amount, android.R.layout.simple_spinner_item);
		amountAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		try { 
			amountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				Log.i("Amount", arg0.getItemAtPosition(arg2).toString());
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
			}
		});
			amountSpinner.setAdapter(amountAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
	    Button save = (Button) view.findViewById(R.id.rollButton);
    	save.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	return view;
	}
}
