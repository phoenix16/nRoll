package com.fingerprint.nroll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ball extends Activity {
	
	MyAnimation a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		

		setContentView(R.layout.ball);	
				
		a = new MyAnimation(this);
		setContentView(a);	

	
	}
	
	

}
