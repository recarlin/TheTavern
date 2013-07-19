package com.recarlin.thetavern;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiceRoller extends Fragment
{
	public DiceRoller() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
	    return inflater.inflate(R.layout.dr, null);
	}
}
