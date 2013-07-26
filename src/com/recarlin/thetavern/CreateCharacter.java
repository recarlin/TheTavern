package com.recarlin.thetavern;

import org.json.JSONException;
import org.json.JSONObject;

import utilities.ReadWrite;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreateCharacter extends Fragment
{
	Activity act;
	Context con;
	
	private static String pickedRace;
	private static String pickedClass;
	private static int pickedStatSTR;
	private static int pickedStatDEX;
	private static int pickedStatCON;
	private static int pickedStatINT;
	private static int pickedStatWIS;
	private static int pickedStatCHA;
	private static String pickedFeat1;
	private static String pickedFeat2;
	private static String pickedSkill1;
	private static String pickedSkill2;
	private static String pickedSkill3;
	private static String pickedSkill4;
	private static String pickedSkill5;
	private static String pickedSkill6;
	private static String pickedSkill7;
	
	public CreateCharacter() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		LinearLayout view = (LinearLayout) inflater.inflate(R.layout.ccp1, null);
		
		act = getActivity();
		con = act.getApplicationContext();
		
		Button save = (Button) view.findViewById(R.id.saveButton);
    	save.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			GenerateCharacterFile();
    		}
    	});
		return view;
	}
	
	private void GenerateCharacterFile(){
		String name = act.findViewById(R.id.pickName).toString();
		JSONObject charas = new JSONObject();
		JSONObject chara = new JSONObject();
		try {
			chara.put("name", name);
			chara.put("race", pickedRace);
			chara.put("class", pickedClass);
			chara.put("STR", pickedStatSTR);
			chara.put("DEX", pickedStatDEX);
			chara.put("CON", pickedStatCON);
			chara.put("INT", pickedStatINT);
			chara.put("WIS", pickedStatWIS);
			chara.put("CHA", pickedStatCHA);
			chara.put("feat1", pickedFeat1);
			chara.put("feat2", pickedFeat2);
			chara.put("skill1", pickedSkill1);
			chara.put("skill2", pickedSkill2);
			chara.put("skill3", pickedSkill3);
			chara.put("skill4", pickedSkill4);
			chara.put("skill5", pickedSkill5);
			chara.put("skill6", pickedSkill6);
			chara.put("skill7", pickedSkill7);
			
			charas.put(name, chara);
			
			ReadWrite.storeFile(con, "characters", charas.toString(), false);
			
			AlertDialog alert = new AlertDialog.Builder(con).create();
			alert.setTitle("Success");
			alert.setMessage("Character Saved!");
			alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
				}
			});
			alert.show();
		} catch (JSONException e) {
			Log.e("ERROR", "JSON exception!");
		}
	}
}