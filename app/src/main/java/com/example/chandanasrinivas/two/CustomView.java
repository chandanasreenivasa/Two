package com.example.chandanasrinivas.two;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{
    Rect r;
    public static final int SS=200;
    Paint p;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    void swapColor()
    {
        p.setColor(p.getColor()== Color.GREEN? Color.RED:Color.GREEN);
        postInvalidate();
    }
    void init(@Nullable AttributeSet attrs)
    {
        r=new Rect();
        p=new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.GREEN);
    }
    protected void onDraw(Canvas canvas)
    {
        Rect rect=new Rect();
        r.left=50;
        r.top=50;
        r.bottom=r.top+SS;
        r.right=r.left+SS;
        canvas.drawRect(r,p);
    }

}
