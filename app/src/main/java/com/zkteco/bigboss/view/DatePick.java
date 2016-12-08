package com.zkteco.bigboss.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.zkteco.bigboss.util.DateUtils;
import com.zkteco.bigboss.view.kankan.wheel.widget.DateObject;
import com.zkteco.bigboss.view.kankan.wheel.widget.OnWheelChangedListener;
import com.zkteco.bigboss.view.kankan.wheel.widget.StringWheelAdapter;
import com.zkteco.bigboss.view.kankan.wheel.widget.WheelView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 自定义的日期选择器
 *
 * @author sxzhang
 */
public class DatePick extends LinearLayout {

    private Calendar calendar = Calendar.getInstance(); //������
    private WheelView newDays;
    private WheelView newYear;
    private WheelView newMonth;
    private ArrayList<DateObject> dateList;
    private ArrayList<DateObject> yearList;
    private ArrayList<DateObject> monthList;
    private OnChangeListener onChangeListener; //onChangeListener
    private final int MARGIN_RIGHT = 1;
    private DateObject dateObject;        //日期数据对象

    //Constructors
    public DatePick(Context context) {
        super(context);
        init(context);
    }

    public DatePick(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int currday = 0;
        yearList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            yearList.add(new DateObject(year - 1 + i));
        }
        monthList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            monthList.add(new DateObject(0, 1 + i));
        }
        dateList = new ArrayList<DateObject>();
        for (int i = 0; i < DateUtils.getMonthDays(year, month); i++) {
            calendar.set(year, month, i + 1);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            dateObject = new DateObject(year, month + 1, i + 1, week);
            dateList.add(dateObject);
            if (i + 1 == day) {
                currday = i;
            }
        }
        /*for (int i = 0; i < 7; i++) {
            //calendar.set(year, month, i + 1);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            dateObject = new DateObject(year, month + 1, day+i, week);
            dateList.add(dateObject);

        }
*/
        newDays = new WheelView(context);
        newYear = new WheelView(context);
        newMonth = new WheelView(context);
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth() / 3 * 2;
        LayoutParams newDays_param = new LayoutParams(width / 2, LayoutParams.WRAP_CONTENT);
        LayoutParams newYear_param = new LayoutParams(width / 4, LayoutParams.WRAP_CONTENT);
        newDays_param.setMargins(0, 0, MARGIN_RIGHT, 0);
        newYear_param.setMargins(0, 0, MARGIN_RIGHT, 0);
        newYear.setLayoutParams(newYear_param);
        newMonth.setLayoutParams(newYear_param);
        newDays.setLayoutParams(newDays_param);
        newDays.setAdapter(new StringWheelAdapter(dateList, dateList.size()));
        newYear.setAdapter(new StringWheelAdapter(yearList, yearList.size()));
        newMonth.setAdapter(new StringWheelAdapter(monthList, monthList.size()));
        newDays.setVisibleItems(3);
        newYear.setVisibleItems(3);
        newMonth.setVisibleItems(3);
        newDays.setCyclic(true);
        newYear.setCyclic(false);
        newMonth.setCyclic(true);
        newDays.setCurrentItem(currday);
        newYear.setCurrentItem(1);
        newMonth.setCurrentItem(month);
        newDays.addChangingListener(onDaysChangedListener);
        newMonth.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                dateList = new ArrayList<DateObject>();
                int myear, mmonth;
                myear = yearList.get(newYear.getCurrentItem()).getYear();
                mmonth = monthList.get(wheel.getCurrentItem()).getMonth();
                for (int i = 0; i < DateUtils.getMonthDays(myear, mmonth - 1); i++) {
                    calendar.set(myear, mmonth - 1, i + 1);
                    int week = calendar.get(Calendar.DAY_OF_WEEK);
                    dateObject = new DateObject(myear, mmonth, i + 1, week);
                    dateList.add(dateObject);
                }
                newDays.setAdapter(new StringWheelAdapter(dateList, dateList.size()));
                newDays.setCurrentItem(0);
                change();
            }

        });
        newYear.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                dateList = new ArrayList<DateObject>();
                int myear, mmonth;
                myear = yearList.get(wheel.getCurrentItem()).getYear();
                mmonth = monthList.get(newMonth.getCurrentItem()).getMonth();
                for (int i = 0; i < DateUtils.getMonthDays(myear, mmonth - 1); i++) {
                    calendar.set(myear, mmonth - 1, i + 1);
                    int week = calendar.get(Calendar.DAY_OF_WEEK);
                    dateObject = new DateObject(myear, mmonth + 1, i + 1, week);
                    dateList.add(dateObject);
                }
                newDays.setAdapter(new StringWheelAdapter(dateList, dateList.size()));
                newDays.setCurrentItem(0);
                change();
            }
        });
        addView(newYear);
        addView(newMonth);
        addView(newDays);
    }

    /**
     * 滑动改变监听器
     */
    private OnWheelChangedListener onDaysChangedListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView mins, int oldValue, int newValue) {
            calendar.set(Calendar.DAY_OF_MONTH, newValue + 1);
            change();
        }
    };

    /**
     * 滑动改变监听器回调的接口
     */
    public interface OnChangeListener {
        void onChange(int year, int month, int day, int day_of_week);
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
            onChangeListener.onChange(
                    yearList.get(newYear.getCurrentItem()).getYear(),
                    monthList.get(newMonth.getCurrentItem()).getMonth(),
                    dateList.get(newDays.getCurrentItem()).getDay(),
                    dateList.get(newDays.getCurrentItem()).getWeek());
        }
    }


    /**
     * 根据day_of_week得到汉字星期
     *
     * @return
     */
    public static String getDayOfWeekCN(int day_of_week) {
        String result = null;
        switch (day_of_week) {
            case 1:
                result = "星期日";
                break;
            case 2:
                result = "星期一";
                break;
            case 3:
                result = "星期二";
                break;
            case 4:
                result = "星期三";
                break;
            case 5:
                result = "星期四";
                break;
            case 6:
                result = "星期五";
                break;
            case 7:
                result = "星期六";
                break;
            default:
                break;
        }
        return result;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
