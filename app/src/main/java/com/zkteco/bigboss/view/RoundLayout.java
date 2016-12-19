package com.zkteco.bigboss.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by jiang_ruicheng on 16/12/9.
 */
public class RoundLayout extends LinearLayout {
    /*private float roundLayoutRadius;
    private Path roundPath;
    private RectF rectF;

    public RoundLayout(Context context) {
        this(context, null);
    }

    public RoundLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setWillNotDraw(false);//如果你继承的是ViewGroup,注意此行,否则draw方法是不会回调的;
        roundPath = new Path();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        roundLayoutRadius = 20 * metrics.densityDpi;
        rectF = new RectF();
    }

    private void setRoundPath() {
        //添加一个圆角矩形到path中, 如果要实现任意形状的View, 只需要手动添加path就行
        roundPath.addRoundRect(rectF, roundLayoutRadius, roundLayoutRadius, Path.Direction.CW);
    }


    public void setRoundLayoutRadius(float roundLayoutRadius) {
        this.roundLayoutRadius = roundLayoutRadius;
        setRoundPath();
        postInvalidate();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);


    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (roundLayoutRadius > 0) {
            rectF.set(0f, 0f, getMeasuredWidth(), getMeasuredHeight());
            setRoundPath();
            canvas.clipPath(roundPath);
        }

    }*/
   private RectF rect = new RectF();
    private Path path = new Path();
    private Paint mPaint = new Paint();

    public RoundLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
       // mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect, mPaint);
        path.moveTo(0, 0);
        path.addRoundRect(rect, 40, 40, Path.Direction.CW);
        path.close();
        canvas.clipPath(path);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect, mPaint);
        super.onDraw(canvas);
    }
}

