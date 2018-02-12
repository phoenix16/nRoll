package com.fingerprint.nroll;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Papertoss extends Activity implements OnClickListener{

	Button b;
	TextView t;
	int counter;
//	MyAnimation a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		a = new MyAnimation(this);
//		setContentView(a);
		
		counter = 50;
				
		setContentView(R.layout.papertoss);
		initialize();
	}
	
	
	
	
	private void initialize() {
		// TODO Auto-generated method stub
		b = (Button) findViewById(R.id.tossButton);
		t = (TextView) findViewById(R.id.tossText);
		b.setOnClickListener(this);
		t.setOnClickListener(this);
		
	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.tossButton:
			counter--;
			t.setText("Great toss!\n " + counter + " tries remaining");
			t.setTextSize(30);
			t.setTextColor(Color.GREEN);
			
			break;					
			

		}
		
	}
	
	
	
	

}
