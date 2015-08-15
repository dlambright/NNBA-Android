package com.example.charliebuckets.nnba_android.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by charliebuckets on 8/15/15.
 */
public class StatsLine extends View{
    public StatsLine(Context context) {
        super(context);
        init(null, 0);
    }
    public StatsLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public StatsLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle){

    }
}
