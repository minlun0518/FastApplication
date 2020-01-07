package com.tom.fastapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private Monday monday;
    private Bitmap bitmapMonday;
    private Bitmap bitmapMondayNG;
    private Paint paint = new Paint();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (monday == null) {
            monday = new Monday(this);
            bitmapMonday = BitmapFactory.decodeResource(getResources(), R.drawable.monday);
            bitmapMondayNG = BitmapFactory.decodeResource(getResources(), R.drawable.lnalanfire);
        }
        Log.d("Game", "onDraw: " + getWidth() + "," + getHeight());
        if (monday.getDirection() == Monday.DIRECTION_NG) {
            bitmapMonday = bitmapMondayNG;
        }
        canvas.drawBitmap(bitmapMonday, monday.getX(), monday.getY(), paint);
    }

    public void moveDown() {
        if (monday.getY() < getHeight()-150) {
            monday.setDirection(Monday.DIRECTION_DOWN);
            invalidate();
        }
    }
    public void moveUp() {
        if (monday.getY() > 50) {
            monday.setDirection(Monday.DIRECTION_UP);
            invalidate();
        }
    }
    public void moveRight() {
        if (monday.getX() < getWidth()-150) {
            monday.setDirection(Monday.DIRECTION_RIGHT);
            invalidate();
        }
    }

    public void moveLeft() {
        if (monday.getX() > 50) {
            monday.setDirection(Monday.DIRECTION_LEFT);
            invalidate();
        }
    }
}
