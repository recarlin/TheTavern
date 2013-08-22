package com.recarlin.thetavern;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.recarlin.thetavern.R.id;

import utilities.RandomNumber;
import utilities.ReadWrite;

import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateCharacter extends Fragment implements OnItemSelectedListener
{
	private PopupWindow infoWindow;
	private String charName = "";
	
	public CreateCharacter() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		LinearLayout vw = (LinearLayout) inflater.inflate(R.layout.ccp1, null);
		
		ArrayAdapter<CharSequence> raceAdpt = ArrayAdapter.createFromResource(TabsStart.ap, R.array.races, R.layout.spinners);
		raceAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickRace)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickRace)).setAdapter(raceAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> classAdpt = ArrayAdapter.createFromResource(TabsStart.ap, R.array.classes, R.layout.spinners);
		classAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickClass)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickClass)).setAdapter(classAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> statsAdpt = ArrayAdapter.createFromResource(TabsStart.ap, R.array.stats, R.layout.spinners);
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
		
		ArrayAdapter<CharSequence> featAdpt = ArrayAdapter.createFromResource(TabsStart.ap, R.array.feats, R.layout.spinners);
		featAdpt.setDropDownViewResource(R.layout.spinners);
		try {
			((Spinner) vw.findViewById(R.id.pickFeat1)).setOnItemSelectedListener(this);
			((Spinner) vw.findViewById(R.id.pickFeat1)).setAdapter(featAdpt);
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
		
		ArrayAdapter<CharSequence> skillsAdpt = ArrayAdapter.createFromResource(TabsStart.ap, R.array.skills, R.layout.spinners);
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
		} catch (NullPointerException e) {
			Log.e("ERROR", e.toString());
		}
			((EditText)vw.findViewById(R.id.pickName)).addTextChangedListener(new TextWatcher() {
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
				}
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				}
				@Override
				public void afterTextChanged(Editable s) {
					charName = s.toString();
				}
			});
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
    			infoPopUp();
    		}
    	});
    	Button infoClass = (Button) vw.findViewById(R.id.classInfo);
    	infoClass.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoPopUp();
    		}
    	});
    	Button infoStats = (Button) vw.findViewById(R.id.statsInfo);
    	infoStats.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoPopUp();
    		}
    	});
    	Button infoFeats = (Button) vw.findViewById(R.id.featInfo);
    	infoFeats.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoPopUp();
    		}
    	});
    	Button infoSkills = (Button) vw.findViewById(R.id.skillsInfo);
    	infoSkills.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoPopUp();
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
						TextView resultTextView = (TextView) TabsStart.act.findViewById(id);
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
		String data = "";
		try {
			data = ReadWrite.readFile(TabsStart.ap, "characters", false);
		} catch (Exception e) {
			Log.e("ReadFile", "No character file");
		}
		
		String name = ((EditText) TabsStart.act.findViewById(R.id.pickName)).getText().toString();
		JSONArray charas = new JSONArray();
		JSONObject chara = new JSONObject();
		try {
			chara.put("name", name);
			
			Spinner raceSpin = (Spinner)TabsStart.act.findViewById(R.id.pickRace);
			String raceText = raceSpin.getSelectedItem().toString();
			chara.put("race", raceText);
			
			Spinner classSpin = (Spinner)TabsStart.act.findViewById(R.id.pickClass);
			String classText = classSpin.getSelectedItem().toString();
			chara.put("class", classText);
			
			Spinner stat1Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick1);
			String stat1Text = stat1Spin.getSelectedItem().toString();
			String result1 = ((TextView)TabsStart.act.findViewById(R.id.stat1)).getText().toString();
			chara.put("stat1", stat1Text);
			chara.put("result1", result1);
			
			Spinner stat2Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick2);
			String stat2Text = stat2Spin.getSelectedItem().toString();
			String result2 = ((TextView)TabsStart.act.findViewById(R.id.stat2)).getText().toString();
			chara.put("stat2", stat2Text);
			chara.put("result2", result2);
			
			Spinner stat3Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick3);
			String stat3Text = stat3Spin.getSelectedItem().toString();
			String result3 = ((TextView)TabsStart.act.findViewById(R.id.stat3)).getText().toString();
			chara.put("stat3", stat3Text);
			chara.put("result3", result3);
			
			Spinner stat4Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick4);
			String stat4Text = stat4Spin.getSelectedItem().toString();
			String result4 = ((TextView)TabsStart.act.findViewById(R.id.stat4)).getText().toString();
			chara.put("stat4", stat4Text);
			chara.put("result4", result4);
			
			Spinner stat5Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick5);
			String stat5Text = stat5Spin.getSelectedItem().toString();
			String result5 = ((TextView)TabsStart.act.findViewById(R.id.stat5)).getText().toString();
			chara.put("stat5", stat5Text);
			chara.put("result5", result5);
			
			Spinner stat6Spin = (Spinner)TabsStart.act.findViewById(R.id.statPick6);
			String stat6Text = stat6Spin.getSelectedItem().toString();
			String result6 = ((TextView)TabsStart.act.findViewById(R.id.stat6)).getText().toString();
			chara.put("stat6", stat6Text);
			chara.put("result6", result6);
			
			Spinner featSpin = (Spinner)TabsStart.act.findViewById(R.id.pickFeat1);
			String featText = featSpin.getSelectedItem().toString();
			chara.put("feat", featText);
			
			Spinner skill1Spin = (Spinner)TabsStart.act.findViewById(R.id.pickSkill1);
			String skill1Text = skill1Spin.getSelectedItem().toString();
			chara.put("skill1", skill1Text);
			
			Spinner skill2Spin = (Spinner)TabsStart.act.findViewById(R.id.pickSkill2);
			String skill2Text = skill2Spin.getSelectedItem().toString();
			chara.put("skill2", skill2Text);
			
			Spinner skill3Spin = (Spinner)TabsStart.act.findViewById(R.id.pickSkill3);
			String skill3Text = skill3Spin.getSelectedItem().toString();
			chara.put("skill3", skill3Text);
			
			Spinner skill4Spin = (Spinner)TabsStart.act.findViewById(R.id.pickSkill4);
			String skill4Text = skill4Spin.getSelectedItem().toString();
			chara.put("skill4", skill4Text);
		} catch (JSONException e) {
			Log.e("ERROR", "First JSON exception!");
		}
		if (data == "") {
			charas.put(chara);
			ReadWrite.storeFile(TabsStart.ap, "characters", charas.toString(), false);
		} else {
			try {
				JSONArray current = new JSONArray(data);
				current.put(chara);
				ReadWrite.storeFile(TabsStart.ap, "characters", current.toString(), false);
				
//				AlertDialog alert = new AlertDialog.Builder(TabsStart.ap).create();
//				alert.setTitle("Success");
//				alert.setMessage("Character Saved!");
//				alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//					public void onClick(final DialogInterface dialog, final int which) {
//					}
//				});
//				alert.show();
			} catch (JSONException e) {
				Log.e("ERROR", "JSON exception!");
			}
		}
		String stuff = ReadWrite.readFile(TabsStart.ap, "characters", false);
		Log.i("FILE", stuff);
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
			((ImageView)TabsStart.act.findViewById(R.id.portrait)).setImageBitmap(photo);
			
			File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/TheTavern");
			if (! dir.exists()){
		        if (! dir.mkdirs()){
		            Log.d("ERROR", "Failed to make directory.");
		        }
		    }
		    if (charName == "") {
				Log.e("ERROR", "Character has no name to save the picture.");
			} else {
			    File file = new File (dir, charName);
			    if (file.exists ()) file.delete (); 
			    try {
			           FileOutputStream out = new FileOutputStream(file);
			           photo.compress(Bitmap.CompressFormat.JPEG, 90, out);
			           out.flush();
			           out.close();
			    } catch (Exception e) {
			           Log.e("ERROR", "The picture did not save correctly.");
			    }
			}
		} catch (Exception e) {
			Log.e("ERROR", "Problem adding file to ImageView");
		}
	}
	private void infoPopUp() {
		LayoutInflater inflater = (LayoutInflater) TabsStart.act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.info_pop_up, (ViewGroup) TabsStart.act.findViewById(R.id.popLL));
		infoWindow = new PopupWindow(layout, 500, 500, true);
		infoWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
		
		Button closePopUp = (Button) layout.findViewById(R.id.closeInfo);
    	closePopUp.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoWindow.dismiss();
    		}
    	});
	}
}