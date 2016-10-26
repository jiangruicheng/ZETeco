/*
package com.zkteco.zkteco;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import PopWindowManager;

import java.util.ArrayList;

public class ApplyLeaveActivity extends AppCompatActivity {
    private Button button;

    private View back, leavetypes, leavestarttime, leavefinishtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);
        button = (Button) findViewById(R.id.makesure);
        back = findViewById(R.id.back);
        leavetypes = findViewById(R.id.leave_types);
        leavestarttime = findViewById(R.id.leave_start_time);
        leavefinishtime = findViewById(R.id.leave_finish_time);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.leave_types:
                */
/*popwindow();*//*

                ArrayList<String> items = new ArrayList<>();
                items.add("事假");
                items.add("病假");
                items.add("婚假");
                items.add("产假");
                items.add("丧假");
                items.add("陪产假");
                PopWindowManager.popListWindow(ApplyLeaveActivity.this, button, items);
                break;
            case R.id.leave_start_time:
                */
/*poptimewindow();*//*

                PopWindowManager.poptimewindow(ApplyLeaveActivity.this, button);
                break;
            case R.id.leave_finish_time:
                */
/*poptimewindow();*//*

                PopWindowManager.poptimewindow(ApplyLeaveActivity.this, button);
                break;
        }
    }

   */
/* private void popwindow() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getApplication()).inflate(R.layout.popview_leave,
                null);
        ListView listView = (ListView) relativeLayout.findViewById(R.id.leavetype_list);
        MListViewAdpater adpater = new MListViewAdpater(getApplication());
        ArrayList<String> items = new ArrayList<>();
        items.add("事假");
        items.add("病假");
        items.add("婚假");
        items.add("产假");
        items.add("丧假");
        items.add("陪产假");
        adpater.setItemText(items);
        listView.setAdapter(adpater);
        WindowManager wg = (WindowManager) ApplyLeaveActivity.this.getSystemService(Context.WINDOW_SERVICE);
        PopupWindow popupWindow = new PopupWindow(relativeLayout, -1, wg.getDefaultDisplay().getHeight() / 5 * 3);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        popupWindow.showAtLocation(button, Gravity.BOTTOM, 0, 0);

    }

    *//*
*/
/*private int currentHour, currentMinute, currentDay, selectHour, selectMinute, selectDay;
    private String selectDate, selectTime;
*//*
*/
/*

    public void poptimewindow() {
        final int currentHour;
        final int currentMinute;
        final int currentDay;
        final int[] selectHour = new int[1];
        final int[] selectMinute = new int[1];
        final int[] selectDay = new int[1];
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
        View view = View.inflate(ApplyLeaveActivity.this, R.layout.dialog_select_time, null);
        selectDate[0] = calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月"
                + calendar.get(Calendar.DAY_OF_MONTH) + "日"
                + DatePick.getDayOfWeekCN(calendar.get(Calendar.DAY_OF_WEEK));
        //选择时间与当前时间的初始化，用于判断用户选择的是否是以前的时间，如果是，弹出toss提示不能选择过去的时间
        selectDay[0] = currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        selectMinute[0] = currentMinute = calendar.get(Calendar.MINUTE);
        selectHour[0] = currentHour = calendar.get(Calendar.HOUR_OF_DAY);

        selectTime[0] = currentHour + "点" + ((currentMinute < 10) ? ("0" + currentMinute) : currentMinute) + "分";
        dp_test = (DatePick) view.findViewById(R.id.dp_test);
        tp_test = (TimePicker) view.findViewById(R.id.tp_test);
        tv_ok = (TextView) view.findViewById(R.id.tv_ok);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        //设置滑动改变监听器
        dp_test.setOnChangeListener(dp_onchanghelistener);
        tp_test.setOnChangeListener(tp_onchanghelistener);
        WindowManager wg = (WindowManager) ApplyLeaveActivity.this.getSystemService(Context.WINDOW_SERVICE);
        pw = new PopupWindow(view, -1, wg.getDefaultDisplay().getHeight() / 10 * 3);
//				//设置这2个使得点击pop以外区域可以去除pop
//				pw.setOutsideTouchable(true);
//				pw.setBackgroundDrawable(new BitmapDrawable());

        //出现在布局底端
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(button, 0, 0, Gravity.END);

        //点击确定
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (selectDay[0] == currentDay) {    //在当前日期情况下可能出现选中过去时间的情况
                    if (selectHour[0] < currentHour) {
                        Toast.makeText(getApplicationContext(), "不能选择过去的时间\n        请重新选择", 0).show();
                    } else if ((selectHour[0] == currentHour) && (selectMinute[0] < currentMinute)) {
                        Toast.makeText(getApplicationContext(), "不能选择过去的时间\n        请重新选择", 0).show();
                    } else {
                        Toast.makeText(getApplicationContext(), selectDate[0] + selectTime[0], 0).show();
                        pw.dismiss();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), selectDate[0] + selectTime[0], 0).show();
                    pw.dismiss();
                }
            }
        });

        //点击取消
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pw.dismiss();
            }
        });

    }*//*

}



*/
