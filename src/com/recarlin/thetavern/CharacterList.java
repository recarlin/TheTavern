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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class CharacterList extends Fragment
{
	public Context con;
	public Activity act;
	public View vw;
	
	private PopupWindow infoWindow;
	public String json;
	
	public CharacterList() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		vw = (LinearLayout) inflater.inflate(R.layout.cl, null);
		
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
				charaList.add(makeChara("characters", outPut));
			}
		} catch(JSONException e) {
			Log.e("ERROR", "Issue populating the list.");
		}
		ListView lv = (ListView) vw.findViewById(R.id.myCharacterList);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				infoPopUp(arg2);
			}
		});
		SimpleAdapter sa = new SimpleAdapter(con, charaList, R.layout.cells, new String[] {"characters"}, new int[] {R.id.characterText});
		lv.setAdapter(sa);
		return vw;
	}
	private HashMap<String, String>makeChara(String cName,String cClass){
		HashMap<String, String> charaNameClass = new HashMap<String, String>();
		charaNameClass.put(cName, cClass);
		return charaNameClass;
	}
	public void infoPopUp(int position) {
		LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.character_list_info, (ViewGroup) act.findViewById(R.id.characterPopLL));
		infoWindow = new PopupWindow(layout, 600, 1000, true);
		infoWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
		
		Button closePopUp = (Button) layout.findViewById(R.id.clClose);
    	closePopUp.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			infoWindow.dismiss();
    		}
    	});
		try {
			JSONArray characters = new JSONArray(json);
			JSONObject currentCharacter = characters.getJSONObject(position);
			
			String cName = (String) currentCharacter.get("name");
			
			String cRace = (String) currentCharacter.get("race");
			String cClass = (String) currentCharacter.get("class");
			String cRaceNClass = cRace + " - " + cClass;
			
			String cStat1 = (String) currentCharacter.get("stat1");
			String cStat2 = (String) currentCharacter.get("stat2");
			String cStat3 = (String) currentCharacter.get("stat3");
			String cStat4 = (String) currentCharacter.get("stat4");
			String cStat5 = (String) currentCharacter.get("stat5");
			String cStat6 = (String) currentCharacter.get("stat6");
			String cResult1 = (String) currentCharacter.get("result1");
			String cResult2 = (String) currentCharacter.get("result2");
			String cResult3 = (String) currentCharacter.get("result3");
			String cResult4 = (String) currentCharacter.get("result4");
			String cResult5 = (String) currentCharacter.get("result5");
			String cResult6 = (String) currentCharacter.get("result6");
			
			String cFeat = (String) currentCharacter.get("feat");
			
			String cSkill1 = (String) currentCharacter.get("skill1");
			String cSkill2 = (String) currentCharacter.get("skill2");
			String cSkill3 = (String) currentCharacter.get("skill3");
			String cSkill4 = (String) currentCharacter.get("skill4");
			
			((TextView) infoWindow.getContentView().findViewById(R.id.clName)).setText(cName);
			
//			String fileName = "/TheTavern/" + cName;
//			File imageFile = new File(fileName);
//			Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
//			((ImageView) infoWindow.getContentView().findViewById(R.id.clPortrait)).setImageBitmap(bitmap);
			
			((TextView) infoWindow.getContentView().findViewById(R.id.clRaceNClass)).setText(cRaceNClass);
			
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult1)).setText(cResult1);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat1)).setText(cStat1);
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult2)).setText(cResult2);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat2)).setText(cStat2);
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult3)).setText(cResult3);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat3)).setText(cStat3);
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult4)).setText(cResult4);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat4)).setText(cStat4);
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult5)).setText(cResult5);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat5)).setText(cStat5);
			((TextView) infoWindow.getContentView().findViewById(R.id.clResult6)).setText(cResult6);
			((TextView) infoWindow.getContentView().findViewById(R.id.clStat6)).setText(cStat6);
			
			((TextView) infoWindow.getContentView().findViewById(R.id.clFeat)).setText(cFeat);
			
			((TextView) infoWindow.getContentView().findViewById(R.id.clSkill1)).setText(cSkill1);
			((TextView) infoWindow.getContentView().findViewById(R.id.clSkill2)).setText(cSkill2);
			((TextView) infoWindow.getContentView().findViewById(R.id.clSkill3)).setText(cSkill3);
			((TextView) infoWindow.getContentView().findViewById(R.id.clSkill4)).setText(cSkill4);
		} catch (JSONException e) {
			Log.e("ERROR", "Popup issue.");
		}
	}
}
