package com.fingerprint.nroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MyAnimation extends ImageView {

	Bitmap rawball, ball, background;
	float x = -1;
	float y = -1;
	float t = 1;
	float g = 9.8f;  // gravity
	private float xVelocity = 20;
	private float yVelocity = 15;
	private Handler h;
	private final int FRAME_RATE = 120;

	// Paint paint;

	// Constructor
	public MyAnimation(Context context) {
		super(context);

		rawball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		ball = getResizedBitmap(rawball, 30, 30);

		// Set background image
		background = BitmapFactory.decodeResource(getResources(), R.drawable.papertoss_small);
//		h = new Handler();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(background, 0, 0, null);

		// Change position of ball
		if (x < 0 && y < 0) {
			x = this.getWidth() / 2;
			y = this.getHeight() / 2;
		} else {
			x += xVelocity;
			y += yVelocity;
			if ((x > this.getWidth() - ball.getWidth()) || (x < 0)) {
				xVelocity = xVelocity * -1;
			}
			if ((y > this.getHeight() - ball.getHeight()) || (y < 0)) {
				yVelocity = yVelocity * -1;
			}
		}
		
		
		// Projectile motion of ball
//		if (x < 0 && y < 0) {
//			x = this.getWidth() / 2;
//			y = this.getHeight() / 2;
//		} else {
//			x += xVelocity * t;
//			y += (yVelocity * t) + (0.5f * g * t * t);
//			if ((x > this.getWidth() - ball.getWidth()) || (x < 0)) {
//				xVelocity = xVelocity * -1;
//			}
//			if ((y > this.getHeight() - ball.getHeight()) || (y < 0)) {
//				yVelocity = yVelocity * -1;
//			}
//		}
		
		canvas.drawBitmap(ball, x, y, null);

//		h.postDelayed(r, FRAME_RATE);

		// Create color
		// Paint rectBlue = new Paint();
		// rectBlue.setColor(Color.BLUE);

		// Draw rectangle
		// Rect middleRect = new Rect();
		// middleRect.set(0, canvas.getWidth(), 400, 550);
		// canvas.drawRect(middleRect, rectBlue);

		// Draw circle
		// canvas.drawCircle(45, 60, 10, rectBlue);

		invalidate();

	}

	private Runnable r = new Runnable() {
		@Override
		public void run() {
			invalidate();
		};

	};

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
}
