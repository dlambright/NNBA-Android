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
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Path path = new Path();
        path.moveTo(0, canvas.getHeight());
        path.lineTo(canvas.getWidth()-110, 0);
        path.lineTo(canvas.getWidth(), 0);
        path.lineTo(canvas.getWidth(),canvas.getHeight());
        path.lineTo(0,canvas.getHeight());

        canvas.drawPath(path,paint);



    }
}

