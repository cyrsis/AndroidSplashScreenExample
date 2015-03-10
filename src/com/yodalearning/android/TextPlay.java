package com.yodalearning.android;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textplay);
		
		final EditText comm = (EditText) findViewById(R.id.etCommand);
		Button btry = (Button) findViewById(R.id.bTry);
		final ToggleButton pastog = (ToggleButton) findViewById(R.id.tbPassword);
		final TextView dynamic = (TextView) findViewById(R.id.tvResults);
		
		pastog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (pastog.isChecked()) {
					comm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}else{
					comm.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			}
		});
		
		btry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String check = comm.getText().toString();
				if (check.contentEquals("left")){
					dynamic.setGravity(Gravity.LEFT);
				}else if (check.contentEquals("center")) {
					dynamic.setGravity(Gravity.CENTER);
				}else if (check.contentEquals("right")) {
					dynamic.setGravity(Gravity.RIGHT);
				} else if (check.contentEquals("blue")) {
					dynamic.setTextColor(Color.BLUE);
					
				}else if (check.contentEquals("random")) {
					Random crazy = new Random();
					dynamic.setText("Random");
					dynamic.setTextSize(crazy.nextInt(75));
					dynamic.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
					switch(crazy.nextInt(3)){
					case 0:
						dynamic.setGravity(Gravity.LEFT);
						break;
					case 1:
						dynamic.setGravity(Gravity.CENTER);
						break;
					case 2:
						dynamic.setGravity(Gravity.RIGHT);
						break;
					}
					
				} else {
					dynamic.setText("invalid");
					dynamic.setGravity(Gravity.CENTER);
					dynamic.setTextColor(Color.WHITE);
				}
				
			}
		});
	}
	
	

}
