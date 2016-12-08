package com.zkteco.bigboss.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.zkteco.bigboss.R;


/**
 * Created by jiang_ruicheng on 16/10/19.
 */
public class Lift2Right extends View {
    private String lift = "周";
    private String right = "月";
    private int textsize = 48;
    private boolean isCheckLift = false;
    int unclickbackgroundcolor = Color.WHITE;
    int clickbackgroundcolor = Color.RED;
    int unclicktextcolor = Color.RED;
    int clicktextcolor = Color.WHITE;
    private Paint paint;
    private DisplayMetrics mDisplayMetrics;

    public void setTextsize(int textsize) {
        this.textsize = textsize;
    }

    public Lift2Right(Context context) {
        super(context);
    }

    public Lift2Right(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        mDisplayMetrics = getResources().getDisplayMetrics();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Lift2Right);
        lift = array.getString(R.styleable.Lift2Right_lifttext);
        right = array.getString(R.styleable.Lift2Right_righttext);
        unclickbackgroundcolor = array.getColor(R.styleable.Lift2Right_uncheckbackgroundcolor, Color.WHITE);
        clickbackgroundcolor = array.getColor(R.styleable.Lift2Right_checkbackgroundcolor, Color.RED);
        unclicktextcolor = array.getColor(R.styleable.Lift2Right_unchecktextcolor, Color.RED);
        clicktextcolor = array.getColor(R.styleable.Lift2Right_checktextcolor, Color.WHITE);
        textsize = (int) array.getDimension(R.styleable.Lift2Right_textsize, 48);
        array.recycle();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Lift2Right(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Lift2Right(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLiftText(String lift) {
        this.lift = lift;
    }

    public void setRightText(String right) {
        this.right = right;
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
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextSize(textsize);
        paint.setColor(clickbackgroundcolor);
        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rect, 20, 20, paint);
        //画整个圆矩形
        int width = getWidth();
        int height = getHeight();
        int weekwidth = width / 2;
        int monthwidth = width / 2;
        int fontWidth = (int) paint.measureText(lift);
        int startX = (weekwidth - fontWidth) / 2;
        int startY = (int) (height / 2 - (paint.ascent() + paint.descent()) / 2);
        if (isCheckLift) {
            paint.setColor(unclickbackgroundcolor);
            RectF monthrect = new RectF(weekwidth - 1, 1, width - 1, height - 1);
            canvas.drawRoundRect(monthrect, 20, 20, paint);
            canvas.drawRect(weekwidth - 1, 1, width - width / 4, height - 1, paint);
            paint.setColor(clicktextcolor);
            canvas.drawText(lift, startX, startY, paint);
            paint.setColor(unclicktextcolor);
            canvas.drawText(right, weekwidth + startX, startY, paint);
        } else {
            paint.setColor(unclickbackgroundcolor);
            RectF weekrect = new RectF(1, 1, weekwidth - 1, height - 1);
            canvas.drawRoundRect(weekrect, 20, 20, paint);
            canvas.drawRect(weekwidth / 2, 1, weekwidth, height - 1, paint);
            paint.setColor(unclicktextcolor);
            canvas.drawText(lift, startX, startY, paint);
            paint.setColor(clicktextcolor);
            canvas.drawText(right, weekwidth + startX, startY, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getX() > 0 && event.getX() < getWidth() / 2) {
            isCheckLift = true;
            postInvalidate();
            if (onButtonClick != null) {
                onButtonClick.onClick(isCheckLift);
            }
        } else if (event.getX() > getWidth() / 2 && event.getX() < getWidth()) {
            isCheckLift = false;
            postInvalidate();
            if (onButtonClick != null) {
                onButtonClick.onClick(isCheckLift);
            }
        }
        return super.onTouchEvent(event);
    }

    public interface OnButtonClick {
        public void onClick(boolean IsCheckLift);
    }

    private OnButtonClick onButtonClick;

    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    public void setCheckLift(boolean checkLift) {
        isCheckLift = checkLift;
        invalidate();
    }

    public boolean isCheckLift() {
        return isCheckLift;
    }
}
