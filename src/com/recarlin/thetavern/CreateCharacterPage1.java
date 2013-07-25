package com.recarlin.thetavern;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreateCharacterPage1 extends Fragment
{
	public CreateCharacterPage1() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.ccp1, null);
		
		Button save = (Button) view.findViewById(R.id.saveButton);
    	save.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Intent page2 = new Intent(getActivity().getApplicationContext(), CreateCharacterPage2.class);
				startActivityForResult(page2, 0);
    		}
    	});
		return view;
	}
}