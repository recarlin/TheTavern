package com.recarlin.thetavern;

import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;

import com.recarlin.thetavern.R.id;

import utilities.RandomNumber;
import utilities.ReadWrite;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateCharacter extends Fragment implements OnItemSelectedListener
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
		LinearLayout vw = (LinearLayout) inflater.inflate(R.layout.ccp1, null);
		
		act = getActivity();
		con = act.getApplicationContext();
		
		ArrayAdapter<CharSequence> raceAdpt = ArrayAdapter.createFromResource(con, R.array.races, R.layout.spinners);
		raceAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickRace)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickRace)).setAdapter(raceAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> classAdpt = ArrayAdapter.createFromResource(con, R.array.classes, R.layout.spinners);
		classAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickClass)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickClass)).setAdapter(classAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> statsAdpt = ArrayAdapter.createFromResource(con, R.array.stats, R.layout.spinners);
		statsAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.statPick1)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick1)).setAdapter(statsAdpt);
			
			((Spinner) vw.findViewById(R.id.statPick2)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick2)).setAdapter(statsAdpt);
			
			((Spinner) vw.findViewById(R.id.statPick3)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick3)).setAdapter(statsAdpt);
			
			((Spinner) vw.findViewById(R.id.statPick4)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick4)).setAdapter(statsAdpt);
			
			((Spinner) vw.findViewById(R.id.statPick5)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick5)).setAdapter(statsAdpt);
			
			((Spinner) vw.findViewById(R.id.statPick6)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.statPick6)).setAdapter(statsAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> featAdpt = ArrayAdapter.createFromResource(con, R.array.feats, R.layout.spinners);
		featAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickFeat1)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickFeat1)).setAdapter(featAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> skillsAdpt = ArrayAdapter.createFromResource(con, R.array.skills, R.layout.spinners);
		skillsAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickSkill1)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill1)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill2)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill2)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill3)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill3)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill4)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill4)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill5)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill5)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill6)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill6)).setAdapter(skillsAdpt);
			
			((Spinner) vw.findViewById(R.id.pickSkill7)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickSkill7)).setAdapter(skillsAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		Button save = (Button) vw.findViewById(R.id.saveButton);
    	save.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			GenerateCharacterFile();
    		}
    	});
    	
    	Button infoRace = (Button) vw.findViewById(R.id.raceInfo);
    	infoRace.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	Button infoClass = (Button) vw.findViewById(R.id.classInfo);
    	infoClass.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	Button infoStats = (Button) vw.findViewById(R.id.statsInfo);
    	infoStats.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	Button infoFeats = (Button) vw.findViewById(R.id.featInfo);
    	infoFeats.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	Button infoSkills = (Button) vw.findViewById(R.id.skillsInfo);
    	infoSkills.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
    	Button picture = (Button) vw.findViewById(R.id.takePicture);
    	picture.setOnClickListener(new View.OnClickListener() {
    		@SuppressLint("SimpleDateFormat")
			@Override
    		public void onClick(View v) {
    			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, 100); 
    		}
    	});
    	Button roll = (Button) vw.findViewById(R.id.rollStats);
    	roll.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			for (int i = 0;i < 6;i++){
					try {
						int curResult = RandomNumber.getNumber(3, 18);
						String nmb2str = Integer.toString(i+1);
						String resultIDString = "stat"+nmb2str;
						Class<id> cls = R.id.class;
						Field f = cls.getField(resultIDString);
						int id = f.getInt(null);
						TextView resultTextView = (TextView) act.findViewById(id);
						resultTextView.setText(String.valueOf(curResult));
					} catch (Exception e) {
						Log.e("ERROR", "Cannot set results");
					}
    			}
    		}
    	});
		return vw;
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
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
				Bitmap photo = (Bitmap) data.getExtras().get("data"); 
				((ImageView)act.findViewById(R.id.portrait)).setImageBitmap(photo);
			} catch (Exception e) {
				Log.e("ERROR", "Problem adding file to ImageView");
			}
	}
}