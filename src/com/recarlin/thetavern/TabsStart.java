package com.recarlin.thetavern;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

public class TabsStart extends Activity {
	public static Activity act;
	public static Context ap;
	public static String PACKAGE_NAME;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.ts);
        act = this;
        ap = getApplicationContext();
        PACKAGE_NAME = ap.getPackageName();
        
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab cct = actionbar.newTab().setText("Create New");
        ActionBar.Tab clt = actionbar.newTab().setText("Characters");
        ActionBar.Tab drt = actionbar.newTab().setText("Dice Roller");
        
        Fragment cc = new CreateCharacter();
        Fragment cl = new CharacterList();
        Fragment dr = new DiceRoller();

        cct.setTabListener(new MyTabsListener(cc));
        clt.setTabListener(new MyTabsListener(cl));
        drt.setTabListener(new MyTabsListener(dr));

        actionbar.addTab(cct);
        actionbar.addTab(clt);
        actionbar.addTab(drt);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_character_page1, menu);
		return true;
	}
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }
}
class MyTabsListener implements ActionBar.TabListener {
	public android.app.Fragment frag;
	public MyTabsListener(Fragment fragment) {
		this.frag = fragment;
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.fragment_container, frag);
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(frag);
	}
}