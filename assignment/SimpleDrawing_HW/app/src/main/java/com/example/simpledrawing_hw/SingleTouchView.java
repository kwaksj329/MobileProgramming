package com.example.simpledrawing_hw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SingleTouchView extends View {
    private Paint paint = new Paint();
    private Path path;
    private ArrayList<Integer> colors = new ArrayList<>();
    private ArrayList<Path> paths = new ArrayList<>();
    private int nowColor = Color.BLACK;

    public SingleTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStrokeWidth(10.0f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setAntiAlias(true);
    }

    public void setColor(int c){
        nowColor = c;
    }

    public void clearPath() {
        paths.clear();
        colors.clear();
        invalidate();
    }
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < paths.size(); i++){
            paint.setColor(colors.get(i));
            canvas.drawPath(paths.get(i), paint);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                paths.add(path);
                colors.add(nowColor);
                path.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        path.moveTo(eventX, eventY);
        path.lineTo(eventX, eventY);

        invalidate();;
        return true;
    }
}
