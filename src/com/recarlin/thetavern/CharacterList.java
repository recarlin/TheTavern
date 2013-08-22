package com.recarlin.thetavern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utilities.ReadWrite;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CharacterList extends Fragment
{
	public Context con;
	public Activity act;
	public String json;
	
	public CharacterList() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		LinearLayout vw = (LinearLayout) inflater.inflate(R.layout.ccp1, null);
		
		con = TabsStart.ap;
		act = TabsStart.act;
		
		json = ReadWrite.readFile(TabsStart.ap, "characters", false);
		ArrayList<Map<String,String>> charaList = new ArrayList<Map<String,String>>();
		try {
			JSONArray characters = new JSONArray(json);
			for(int i = 0; i<characters.length();i++){
				JSONObject character = characters.getJSONObject(i);
				String charaName = character.getString("name");
				String charaClass = character.getString("class");
				String outPut = charaName + " - " + charaClass;
				Log.i("OUTPUT", outPut);
				charaList.add(makeChara("characters", outPut));
			}
		} catch(JSONException e) {
			Log.e("ERROR", "Issue populating the list.");
		}
		ListView lv = (ListView) act.findViewById(R.id.charactersList);
		SimpleAdapter sa = new SimpleAdapter(con, charaList, R.layout.cells, new String[] {"characters"}, new int[] {R.id.characterText});
		lv.setAdapter(sa);
		return vw;
	}
	private HashMap<String, String>makeChara(String cName,String cClass){
		HashMap<String, String> charaNameClass = new HashMap<String, String>();
		charaNameClass.put(cName, cClass);
		return charaNameClass;
	}
}
