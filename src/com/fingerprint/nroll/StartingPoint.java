package com.fingerprint.nroll;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity implements View.OnClickListener {
	int counter;
	Button add, subtract;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.starting_point);
		initialize();
		counter = 0;
		add.setOnClickListener(this);
		subtract.setOnClickListener(this);

		// add.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// counter++;
		// display.setText("Your total is " + counter);
		// display.setTextSize(30);
		// display.setTextColor(Color.RED);
		// // Random randomNum = new Random();
		// // display.setTextSize(randomNum.nextInt(15));
		// // display.setTextColor(Color.rgb(randomNum.nextInt(255), 250, 0));
		// }
		// });
		//
		// subtract.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// counter--;
		// display.setText("Your total is " + counter);
		// display.setTextSize(25);
		// display.setTextColor(Color.MAGENTA);
		// }
		// });
	}

	private void initialize() {
		// TODO Auto-generated method stub
		add = (Button) findViewById(R.id.bAdd);
		subtract = (Button) findViewById(R.id.bSubtract);
		display = (TextView) findViewById(R.id.display);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.bAdd:
			counter++;
			display.setText("Your total is " + counter);
			display.setTextSize(30);
			display.setTextColor(Color.RED);
			// Random randomNum = new Random();
			// display.setTextSize(randomNum.nextInt(15));
			// display.setTextColor(Color.rgb(randomNum.nextInt(255), 250, 0));
			break;
		case R.id.bSubtract:
			counter--;
			display.setText("Your total is " + counter);
			display.setTextSize(25);
			display.setTextColor(Color.MAGENTA);
			break;
		}
	}
}
