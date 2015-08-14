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


    private Paint paint;
    String homeTeamName;
    private Path path;
    private int bottomCanvasWidth;
    private int canvasWidth;
    private int canvasHeight;



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
    }

    public String getColor(){
        return Integer.toHexString(paint.getColor());

    }

    private void init(){
        paint = new Paint();

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        bottomCanvasWidth = (int) (canvas.getWidth()*(.55f));
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        path = new Path();
        path.moveTo(0,0);
        path.lineTo(canvasWidth, 0);
        path.lineTo(bottomCanvasWidth, canvasHeight);
        path.lineTo(0,canvasHeight);
        path.lineTo(0,0);
        canvas.drawPath(path, paint);
    }
}
