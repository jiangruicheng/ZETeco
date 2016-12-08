package com.zkteco.bigboss.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.zkteco.bigboss.view.kankan.wheel.widget.DateObject;
import com.zkteco.bigboss.view.kankan.wheel.widget.OnWheelChangedListener;
import com.zkteco.bigboss.view.kankan.wheel.widget.StringWheelAdapter;
import com.zkteco.bigboss.view.kankan.wheel.widget.WheelView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 自定义的时间选择器
 *
 * @author sxzhang
 */
public class TimePicker extends LinearLayout {

    private Calendar calendar = Calendar.getInstance();
    private WheelView hours, mins; //Wheel picker
    private OnChangeListener onChangeListener; //onChangeListener
    private final int MARGIN_RIGHT = 1;        //调整文字右端距离
    private ArrayList<DateObject> hourList, minuteList;
    private DateObject dateObject;        //时间数据对象
    public final static int MINUTE_TYPE_FIVE = 1;
    public final static int MINUTE_TYPE_ALL = 0;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        switch (type) {
            case MINUTE_TYPE_FIVE:
                for (int j = 0; j < 60 / 5; j++) {
                    dateObject = new DateObject(-1, 0 + j * 5, false);
                    minuteList.add(dateObject);
                }
                mins.setCurrentItem(0);
                break;
            case FOCUSABLES_ALL:
                for (int j = 0; j < 60; j++) {
                    dateObject = new DateObject(-1, minute + j, false);
                    minuteList.add(dateObject);
                }
                break;
        }
        mins.setAdapter(new StringWheelAdapter(minuteList, minuteList.size()));

    }

    //Constructors
    public TimePicker(Context context) {
        super(context);
        init(context);
    }

    public TimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        hourList = new ArrayList<DateObject>();
        minuteList = new ArrayList<DateObject>();

        for (int i = 0; i < 24; i++) {
            dateObject = new DateObject(hour + i, -1, true);
            hourList.add(dateObject);
        }

        /*for (int j = 0; j < 60; j++) {
            dateObject = new DateObject(-1, minute + j, false);
            minuteList.add(dateObject);
        }*/

        //小时选择器
        hours = new WheelView(context);
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth() / 3;
        LayoutParams lparams_hours = new LayoutParams(width / 2, LayoutParams.WRAP_CONTENT);
        /*DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();*/
        lparams_hours.setMargins(0, 0, MARGIN_RIGHT, 0);
        hours.setLayoutParams(lparams_hours);
        hours.setAdapter(new StringWheelAdapter(hourList, 24));
        hours.setVisibleItems(3);
        hours.setCyclic(true);
        hours.addChangingListener(onHoursChangedListener);
        addView(hours);

        //分钟选择器
        mins = new WheelView(context);
        mins.setLayoutParams(lparams_hours);
        //mins.setAdapter(new StringWheelAdapter(minuteList, 60));
        mins.setVisibleItems(3);
        mins.setCyclic(true);
        mins.addChangingListener(onMinsChangedListener);
        addView(mins);
    }


    //listeners
    private OnWheelChangedListener onHoursChangedListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView hours, int oldValue, int newValue) {
            calendar.set(Calendar.HOUR_OF_DAY, newValue);
            change();
        }
    };
    private OnWheelChangedListener onMinsChangedListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView mins, int oldValue, int newValue) {
            calendar.set(Calendar.MINUTE, newValue);
            change();
        }
    };

    /**
     * 滑动改变监听器回调的接口
     */
    public interface OnChangeListener {
        void onChange(int hour, int munite);
    }

    /**
     * 设置滑动改变监听器
     *
     * @param onChangeListener
     */
    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    /**
     * 滑动最终调用的方法
     */
    private void change() {
        if (onChangeListener != null) {
            onChangeListener.onChange(getHourOfDay(), getMinute());
        }
    }


    /**
     * 获取小时
     *
     * @return
     */
    public int getHourOfDay() {
        return hourList.get(hours.getCurrentItem()).getHour();
    }

    /**
     * 获取分钟
     *
     * @return
     */
    public int getMinute() {
        return minuteList.get(mins.getCurrentItem()).getMinute();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
