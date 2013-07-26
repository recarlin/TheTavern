package com.recarlin.thetavern;

import utilities.RandomNumber;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class DiceRoller extends Fragment implements OnItemSelectedListener
{
	public static Activity act;
	public static Context con;
	public static View vw;
	
	public static int curType;
	public static int curAmount;
	
	public DiceRoller() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.dr, null);
		vw = view;
	    
		act = getActivity();
		con = act.getApplicationContext();
		
		ArrayAdapter<CharSequence> typeAdpt = ArrayAdapter.createFromResource(con, R.array.dice_types, android.R.layout.simple_spinner_item);
		typeAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		try {
			((Spinner) vw.findViewById(R.id.pickType)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickType)).setAdapter(typeAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> amountAdpt = ArrayAdapter.createFromResource(con, R.array.dice_amount, android.R.layout.simple_spinner_item);
		amountAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		try { 
			((Spinner) vw.findViewById(R.id.pickAmount)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickAmount)).setAdapter(amountAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
	    Button save = (Button) vw.findViewById(R.id.rollButton);
    	save.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			for (int i = 0;i < curAmount;i++){
    				int curResult = RandomNumber.getNumber(1, curType);
    				
    				switch (curAmount) {
    				case 1:
					{
						
					}
    				case 2:
					{
						
					}
    				case 3:
					{
						
					}
    				case 4:
					{
						
					}
    				case 5:
					{
						
					}
    				case 6:
					{
						
					}
    				case 7:
					{
						
					}
    				case 8:
					{
						
					}
    				case 9:
					{
						
					}
    				case 10:
					{
						
					}
					default:
						break;
					}
    				
    			}
    		}
    	});
    	return view;
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		if(arg0 == ((Spinner) vw.findViewById(R.id.pickType)))
		{
			curType = Integer.parseInt(arg0.getItemAtPosition(arg2).toString());
		} else if(arg0 == ((Spinner) vw.findViewById(R.id.pickAmount)))
		{
			curAmount = Integer.parseInt(arg0.getItemAtPosition(arg2).toString());
		}
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
	
	}
}
