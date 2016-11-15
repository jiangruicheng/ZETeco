package com.zkteco.bigboss.adpater;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.view.DatePick;
import com.zkteco.bigboss.view.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jiang_ruicheng on 16/10/21.
 */
public class PopWindowManager {
    public interface Popviewcallback {
        void callback(int p);
    }

    public interface PopviewTimeCallback {
        void setTime(long time);
    }

    public static void popListWindow(Context context, View view, ArrayList list, final Popviewcallback popviewcallback, String title) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.popview_leave,
                null);
        ListView listView = (ListView) relativeLayout.findViewById(R.id.leavetype_list);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.title_listview);
        ImageView cancel = (ImageView) relativeLayout.findViewById(R.id.cancel);
        Button makesure = (Button) relativeLayout.findViewById(R.id.makesure);

        textView.setText(title);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popviewcallback.callback(position);
            }
        });
        MListViewAdapter adpater = new MListViewAdapter(context.getApplicationContext());
        adpater.setItemText(list);
        listView.setAdapter(adpater);
        WindowManager wg = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final PopupWindow popupWindow = new PopupWindow(relativeLayout, -1, wg.getDefaultDisplay().getHeight() / 5 * 3);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                MListViewAdapter.setUnbinder();
            }
        });
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
        makesure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    public static void poptimewindow(final Context context, View Popview, final PopviewTimeCallback callback) {
        final int currentHour;
        final int currentMinute;
        final int currentDay;
        final int[] selectHour = new int[1];
        final int[] selectMinute = new int[1];
        final int[] selectDay = new int[1];
        final int[] selectmonth = new int[1];
        final int[] selectyear = new int[1];
        final String[] selectDate = new String[1];
        final String[] selectTime = new String[1];
        final Calendar calendar = Calendar.getInstance();
        final TextView tv_ok, tv_cancel;
        DatePick dp_test;
        TimePicker tp_test;
        final PopupWindow pw;
        final DatePick.OnChangeListener dp_onchanghelistener = new DatePick.OnChangeListener() {
            @Override
            public void onChange(int year, int month, int day, int day_of_week) {
                selectDay[0] = day;
                selectyear[0] = year;
                selectmonth[0] = month;
                selectDate[0] = year + "年" + month + "月" + day + "日" + DatePick.getDayOfWeekCN(day_of_week);
            }
        };
        final TimePicker.OnChangeListener tp_onchanghelistener = new TimePicker.OnChangeListener() {
            @Override
            public void onChange(int hour, int minute) {
                selectTime[0] = hour + "点" + ((minute < 10) ? ("0" + minute) : minute) + "分";
                selectHour[0] = hour;
                selectMinute[0] = minute;
            }
        };
        View view = View.inflate(context, R.layout.dialog_select_time, null);
        selectDate[0] = calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月"
                + calendar.get(Calendar.DAY_OF_MONTH) + "日"
                + DatePick.getDayOfWeekCN(calendar.get(Calendar.DAY_OF_WEEK));
        //选择时间与当前时间的初始化，用于判断用户选择的是否是以前的时间，如果是，弹出toss提示不能选择过去的时间
        selectDay[0] = currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        selectMinute[0] = currentMinute = calendar.get(Calendar.MINUTE);
        selectHour[0] = currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        selectyear[0] = calendar.get(Calendar.YEAR);
        selectmonth[0] = calendar.get(Calendar.MONTH);
        selectTime[0] = currentHour + "点" + ((currentMinute < 10) ? ("0" + currentMinute) : currentMinute) + "分";
        dp_test = (DatePick) view.findViewById(R.id.dp_test);
        tp_test = (TimePicker) view.findViewById(R.id.tp_test);
        tv_ok = (TextView) view.findViewById(R.id.tv_ok);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        //设置滑动改变监听器
        dp_test.setOnChangeListener(dp_onchanghelistener);
        tp_test.setOnChangeListener(tp_onchanghelistener);
        WindowManager wg = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        pw = new PopupWindow(view, -1, wg.getDefaultDisplay().getHeight() / 10 * 3);
//				//设置这2个使得点击pop以外区域可以去除pop
//				pw.setOutsideTouchable(true);
//				pw.setBackgroundDrawable(new BitmapDrawable());

        //出现在布局底端
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(Popview, 0, 0, Gravity.END);

        //点击确定
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date date = null;

                try {
                    date = simpleDateFormat.parse(selectyear[0] + "-" + selectmonth[0] + "-" + selectDay[0] + " " + selectHour[0] + ":" + selectMinute[0]);
                    long time = date.getTime();
                    callback.setTime(time);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pw.dismiss();

            }

        });

        //点击取消
        tv_cancel.setOnClickListener(new View.OnClickListener()

                                     {
                                         @Override
                                         public void onClick(View arg0) {
                                             pw.dismiss();
                                         }
                                     }

        );

    }
}
