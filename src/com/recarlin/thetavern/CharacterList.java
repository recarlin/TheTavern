package com.recarlin.thetavern;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CharacterList extends Fragment
{
	public CharacterList() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
	    return inflater.inflate(R.layout.cl, null);
	}
}
