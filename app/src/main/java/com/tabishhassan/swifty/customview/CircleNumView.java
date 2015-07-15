package com.tabishhassan.swifty.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.example.tabishhassan.swifty.R;

/**
 * Created by tabishhassan on 7/14/15.
 */
public class CircleNumView extends View {

    private String circleText;;
    private Boolean Is_learned;
    private Paint circlePaint;
    private int checkfirstandlast;

    public CircleNumView(Context context,AttributeSet attr) {
        super(context, attr);
        circlePaint = new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attr,
                R.styleable.CircleNumView, 0, 0);
        try {
            Is_learned = a.getBoolean(R.styleable.CircleNumView_IsLearned,false);
            circleText = a.getString(R.styleable.CircleNumView_CircleText);
        }
        finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
        int radius = 0, radius2 = 0;
        if (viewWidthHalf > viewHeightHalf) {
            radius = viewHeightHalf - 40;
        } else{
            radius=viewWidthHalf-40;
        }
        if(!Is_learned) {
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setAntiAlias(true);
            circlePaint.setStrokeWidth(5);
            circlePaint.setColor(Color.BLACK);
            canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
            circlePaint.setColor(Color.BLACK);
            circlePaint.setTextAlign(Paint.Align.CENTER);
            circlePaint.setTextSize(50);
            canvas.drawText(circleText, viewWidthHalf, 115*viewHeightHalf/100, circlePaint);
        }
        else
        {
            circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
            circlePaint.setAntiAlias(true);
            circlePaint.setStrokeWidth(5);
            circlePaint.setColor(Color.parseColor("#ffff5458"));
            canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
            circlePaint.setColor(Color.WHITE);
            circlePaint.setTextAlign(Paint.Align.CENTER);
            circlePaint.setTextSize(50);
            canvas.drawText(circleText, viewWidthHalf,115*viewHeightHalf/100, circlePaint);
        }
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(3);
        circlePaint.setColor(Color.BLACK);
        Path path = new Path();
        if(checkfirstandlast!=1) {
            path.moveTo(viewWidthHalf, 0);
            path.lineTo(viewWidthHalf, viewHeightHalf - radius);
        }
        if(checkfirstandlast!=2) {
            path.moveTo(viewWidthHalf, viewHeightHalf + radius);
            path.lineTo(viewWidthHalf, this.getMeasuredHeight());
        }
        canvas.drawPath(path,circlePaint);
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
    }

    public void setIs_learned(Boolean is_learned) {
        Is_learned = is_learned;
        invalidate();
    }
    public void setCheckfirstandlast(int i){
        checkfirstandlast = i;
        invalidate();
    }
}
