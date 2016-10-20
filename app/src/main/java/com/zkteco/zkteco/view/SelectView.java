package com.zkteco.zkteco.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jiang_ruicheng on 16/10/20.
 */
public class SelectView extends View {
    private Paint paint;
    private DisplayMetrics mDisplayMetrics;
    private boolean IsSelect = false;
    private OnClickListen onClickListen;

    public SelectView(Context context) {
        super(context);
    }

    public SelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        mDisplayMetrics = getResources().getDisplayMetrics();
    }

    public SelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawCircle(width / 2, height / 2, width / 2 - 5, paint);
        /*for (int i = 0; i < 4; i++) {
            canvas.drawLine(width / 2, 0, width / 2, height / 4, paint);
            canvas.rotate(30, width / 2, height / 2);
        }*/
        if (IsSelect) {
            canvas.drawLine(width / 2, height / 2 + height / 4, width / 6, height / 2, paint);
            canvas.drawLine(width / 2, height / 2 + height / 4, width, height / 4, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (IsSelect) {
            IsSelect = false;
        } else {
            IsSelect = true;
        }
        if (onClickListen != null) {
            onClickListen.onClick(IsSelect);
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    public void setSelect(boolean select) {
        this.IsSelect = select;
        postInvalidate();
    }

    public boolean isSelect() {
        return IsSelect;
    }

    public void setOnClickListen(OnClickListen onClickListen) {
        this.onClickListen = onClickListen;
    }

    public interface OnClickListen {
        void onClick(boolean Select);
    }
}
