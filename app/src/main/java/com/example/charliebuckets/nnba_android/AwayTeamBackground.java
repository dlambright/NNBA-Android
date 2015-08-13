package com.example.charliebuckets.nnba_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by charliebuckets on 8/12/15.
 */
public class AwayTeamBackground extends View {
    int color;
    private Paint paint;
    String awayTeamName;

    int topCanvasWidth;
    int canvasWidth;
    int canvasHeight;
    Path path;


    public AwayTeamBackground(Context context) {
        super(context);
        init();
    }

    public AwayTeamBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AwayTeamBackground(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setColor(int colorValue){
        paint.setColor(colorValue);
//        String hexValue = Integer.toHexString(colorValue);
//        color = Color.parseColor(hexValue);
    }


    private void init(){
        //paint.setAlpha(50);
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        path = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        topCanvasWidth = (int) (canvas.getWidth()*(.45f));
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        path.moveTo(0,canvasHeight);
        path.lineTo(topCanvasWidth, 0);
        path.lineTo(canvasWidth, 0);
        path.lineTo(canvasWidth,canvasHeight);
        path.lineTo(0,canvasHeight);

        canvas.drawPath(path, paint);
    }
}

