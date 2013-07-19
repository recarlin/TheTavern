package com.recarlin.thetavern;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateCharacterPage1 extends Fragment
{
	public CreateCharacterPage1() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
	    return inflater.inflate(R.layout.ccp1, null);
	}
}
