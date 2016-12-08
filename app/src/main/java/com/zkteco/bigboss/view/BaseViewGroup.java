package com.zkteco.bigboss.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by jiang_ruicheng on 16/11/28.
 */
public class BaseViewGroup extends FrameLayout {
    public BaseViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public interface OntouchEvent {
        void ontouchu();
    }

    private OntouchEvent ontouchEvent;

    public void setOntouchEvent(OntouchEvent o) {
        ontouchEvent = o;
    }

    public BaseViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }

            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null) {
                    state.startTracking(event, this);
                }
                return true;
            } else if (event.getAction() == KeyEvent.ACTION_UP) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null && state.isTracking(event) && !event.isCanceled()) {
                    //dismiss();
                    if (ontouchEvent != null)
                        ontouchEvent.ontouchu();
                    return true;
                }
            }
            return super.dispatchKeyEvent(event);
        } else {
            return super.dispatchKeyEvent(event);
        }
    }

    private OnTouchListener mTouchInterceptor;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mTouchInterceptor != null && mTouchInterceptor.onTouch(this, ev)) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();

        if ((event.getAction() == MotionEvent.ACTION_DOWN)
                && ((x < 0) || (x >= getWidth()) || (y < 0) || (y >= getHeight()))) {
            if (ontouchEvent != null)
                ontouchEvent.ontouchu();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            if (ontouchEvent != null)
                ontouchEvent.ontouchu();
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }
}
