package com.example.charliebuckets.nnba_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by charliebuckets on 8/11/15.
 */
public class HomeTeamBackground extends View {

    int color;
    private Paint paint;
    String homeTeamName;



    public HomeTeamBackground(Context context) {
        super(context);
        init();
    }

    public HomeTeamBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeTeamBackground(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setColor(int colorValue){
        paint.setColor(colorValue);
        //String hexValue = Integer.toHexString(colorValue);
        //color = Color.parseColor(hexValue);// 0xff000000 - Integer.parseInt(hexValue,16);
    }


    private void init(){
        color = Color.GREEN;
        paint = new Paint();
        paint.setColor(color);
//        paint.setAlpha(5);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(canvas.getWidth(), 0);
        path.lineTo(canvas.getWidth()-(canvas.getWidth()-110), canvas.getHeight());
        path.lineTo(0,canvas.getHeight());
        path.lineTo(0,0);

        canvas.drawPath(path,paint);



    }
}
