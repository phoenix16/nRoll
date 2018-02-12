package com.fingerprint.nroll;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GfxSurface extends Activity implements OnTouchListener {
	// public class GfxSurface extends Activity implements OnClickListener{

	MySurface ourSurfaceView;
	float x, y, startX, startY, finishX, finishY;
	float xVelocity, yVelocity;
	float dx, dy, animatex, animatey, scaledx, scaledy;
	Bitmap rawball, ball, background;

	 Paint pointColor = new Paint();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		ourSurfaceView = new MySurface(this);
		ourSurfaceView.setOnTouchListener(this);
		// ourSurfaceView.setOnClickListener(this);
		
		x = 0;
		y = 0;	
		startX = 0;
		startY = 0;
		finishX = 0;
		finishY = 0;
		xVelocity = 20;
		yVelocity = 15;		
		dx = 0; dy = 0;
		animatex = 0; animatey = 0;
		scaledx = 0; scaledy = 0;		
		
		// Set up background bitmap
		background = BitmapFactory.decodeResource(getResources(), R.drawable.papertoss_small);
		
		// Set up ball bitmap
		rawball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		ball = getResizedBitmap(rawball, 30, 30);
		
		
		// Set up point color
		 pointColor.setColor(Color.BLUE);		 
		 
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		  
		x = event.getX();
		y = event.getY();
		
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//			startX = event.getX();
//			startY = event.getY();
			
			
//			  Random randomNum = new Random();
//			  startX = randomNum.nextInt(600);
//			  startY = 1000 + randomNum.nextInt(50);	
			
		
			
			  
			  
			  
			finishX = 0;
			finishY = 0;
			dx = 0;
			dy = 0;
			animatex = 0;
			animatey = 0;
			scaledx = 0;
			scaledy = 0;	
			break;
		case MotionEvent.ACTION_UP:
//			finishX = event.getX();
//			finishY = event.getY();
			
			finishX = 550;
			finishY = 1500;
			
			dx = finishX - startX;
			dy = finishY - startY;
			scaledx = dx / 30;
			scaledy = dy / 30;
			x = 0;
			y = 0;
			break;
		}
		
		
		
		return true; // lets you touch and drag
//		return false; // cannot drag ball
	}
	
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {

		int width = bm.getWidth();
		int height = bm.getHeight();

		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// create a matrix for the manipulation
		Matrix matrix = new Matrix();

		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);

		return resizedBitmap;
	}

	
	// MySurface Class definition
	public class MySurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MySurface(Context context) {
			super(context);

			// Set up holder
			ourHolder = getHolder();

		}

		
		protected void myBallDraw(Canvas canvas, float x, float y) {

			// Draws ball when mouse is dragged
			if (x != 0 && y!= 0){
//				canvas.drawBitmap(ball, x, y, null);
//				canvas.drawBitmap(ball, x-(ball.getWidth()/2), y-(ball.getHeight()/2), null);
				
				// Draw circle				
				 canvas.drawCircle(x, y, 3, pointColor);
			}
			
			// Draws ball on mouse click position
			if (startX != 0 && startY!= 0){
//				canvas.drawBitmap(ball, x, y, null);
//				canvas.drawBitmap(ball, startX-(ball.getWidth()/2), startY-(ball.getHeight()/2), null);
				
			
				// Draw circle				
				 canvas.drawCircle(x, y, 3, pointColor);
			}
			
			if (finishX != 0 && finishY!= 0){
				canvas.drawBitmap(ball, finishX-(ball.getWidth()/2)-animatex, finishY-(ball.getHeight()/2)-animatey, null);
//				canvas.drawBitmap(ball, finishX-(ball.getWidth()/2), finishY-(ball.getHeight()/2), null);
			}
			animatex += scaledx; 
			animatey += scaledy;
			
			
			// Change position of ball
//			if (x < 0 && y < 0) {
//				x = this.getWidth() / 2;
//				y = this.getHeight() / 2;
//			} else {
//				x += xVelocity;
//				y += yVelocity;
//				if ((x > this.getWidth() - ball.getWidth()) || (x < 0)) {
//					xVelocity = xVelocity * -1;
//				}
//				if ((y > this.getHeight() - ball.getHeight()) || (y < 0)) {
//					yVelocity = yVelocity * -1;
//				}
//			}
			
			
//			invalidate();
			
			
		}
		

		@Override
		public void run() {
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;

				Canvas canvas = ourHolder.lockCanvas();
				// Set background
				// canvas.drawRGB(2, 34, 150);
				canvas.drawBitmap(background, 0, 0, null);
				
				myBallDraw(canvas, x, y);
				
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
		
		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}
		


	}

}
