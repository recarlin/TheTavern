package com.recarlin.thetavern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateCharacterPage2 extends Activity
{
	public CreateCharacterPage2() {
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccp2);
		Button back = (Button) findViewById(R.id.page2button);
    	back.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Intent page3 = new Intent(getApplicationContext(), CreateCharacterPage3.class);
				startActivityForResult(page3, 0);
    		}
    	});
	}
}