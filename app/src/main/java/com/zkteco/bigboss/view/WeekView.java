package com.zkteco.bigboss.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.util.DateUtils;

/**
 * Created by jiang_ruicheng on 16/10/19.
 */
public class WeekView extends View {
    private Paint paint;
    private DisplayMetrics mDisplayMetrics;
    private int textsize;
    private int currWeekColor;
    String[] week = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

    public WeekView(Context context) {
        super(context);

    }

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Lift2Right);
        mDisplayMetrics = getResources().getDisplayMetrics();
        int mDaySize = 15;
        textsize = (int) array.getDimension(R.styleable.Lift2Right_textsize, mDaySize * mDisplayMetrics.scaledDensity);
        currWeekColor = array.getColor(R.styleable.Lift2Right_checkbackgroundcolor, Color.RED);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WeekView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = mDisplayMetrics.densityDpi * 30;
        }
        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = mDisplayMetrics.densityDpi * 300;
        }
        setMeasuredDimension(widthSize, heightSize);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
       /* paint.setStyle(Paint.Style.FILL);
        paint.setColor(LineColor);
        canvas.drawLine(0, 0, width, 0, paint);
        canvas.drawLine(0, height - 1, width, height - 1, paint);*/
        paint.setTextSize(textsize);
        int columnWidth = width / 7;
        for (int i = 0; i < week.length; i++) {
            if (i == DateUtils.getDay2Week() - 1) {
                paint.setColor(currWeekColor);
                Log.i("week", "onDraw: " + DateUtils.getDay2Week());
            } else {
                paint.setColor(Color.BLACK);
            }
            int fontWidth = (int) paint.measureText(week[i]);
            int startX = columnWidth * i + (columnWidth - fontWidth) / 2;
            int startY = (int) (height / 2 - (paint.ascent() + paint.descent()) / 2);
            canvas.drawText(week[i], startX, startY, paint);
        }
    }

    private int LineColor;

    public void setLineColor(int color) {
        this.LineColor = color;
    }
}
