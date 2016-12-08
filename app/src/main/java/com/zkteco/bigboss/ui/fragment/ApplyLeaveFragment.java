package com.zkteco.bigboss.ui.fragment;


import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.adpater.PopWindowManager;
import com.zkteco.bigboss.bean.json.AskForLeaveRequest;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.presenter.ApplysPresenter;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryReviewersPresenterImpl;
import com.zkteco.bigboss.mvp.view.ApplyView;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.view.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyLeaveFragment extends BasemainFragment implements View.OnClickListener, ApplyView {

    private FragmentCallBack callBack;
    private AskForLeaveRequest.PayloadBean.ParamsBean paramsBean;

    public ApplyLeaveFragment() {
        // Required empty public constructor
        setIsshownavg(false);
        paramsBean = new AskForLeaveRequest.PayloadBean.ParamsBean();
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    private Button button, selectapprovaler;
    private View back, leavetypes, leavestarttime, leavefinishtime;
    private TextView selectstatrttime, selectfinishtime, leavetype, approvalname;
    private EditText reason;
    private LinearLayout typelayout, startlayout, finishlayout;
    private RelativeLayout content;

    @Override
    public void onResume() {
        super.onResume();

        // callBack.SetVisable(false);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_apply_leave, container, false);
        button = (Button) view.findViewById(R.id.makesure);
        content = (RelativeLayout) view.findViewById(R.id.content);
        /*Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.content_background_leave);
        Display display = ((WindowManager) (getActivity().getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay();
        BitmapDrawable drawable = new BitmapDrawable(ImageCompressUtil.compressBySize(bitmap, display.getWidth(), display.getHeight()));*/
/*
        content.setBackgroundResource(R.drawable.content_background_leave);
*/
        selectapprovaler = (Button) view.findViewById(R.id.select_approvaler);
        back = view.findViewById(R.id.back);
        typelayout = (LinearLayout) view.findViewById(R.id.typelayout);
        startlayout = (LinearLayout) view.findViewById(R.id.starttiemlayout);
        finishlayout = (LinearLayout) view.findViewById(R.id.finishtimelayout);
        typelayout.setOnClickListener(this);
        startlayout.setOnClickListener(this);
        finishlayout.setOnClickListener(this);
        approvalname = (TextView) view.findViewById(R.id.approvalname);
        leavetype = (TextView) view.findViewById(R.id.leave_type);
        leavetypes = view.findViewById(R.id.leave_types);
        leavestarttime = view.findViewById(R.id.leave_start_time);
        leavefinishtime = view.findViewById(R.id.leave_finish_time);
        reason = (EditText) view.findViewById(R.id.reason);
        selectstatrttime = (TextView) view.findViewById(R.id.select_leave_start_time);
        selectfinishtime = (TextView) view.findViewById(R.id.select_leave_finish_time);
        button.setOnClickListener(this);
        selectapprovaler.setOnClickListener(this);
        back.setOnClickListener(this);
        leavetype.setOnClickListener(this);
        selectfinishtime.setOnClickListener(this);
        selectstatrttime.setOnClickListener(this);

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                /*callBack.callback(FragmentCallBack.BACK);*/
                callBack.Back(ApplyLeaveFragment.this);
                break;
            case R.id.typelayout:
            case R.id.leave_type:
                /*popwindow();*/
                /*ArrayList<String> items = new ArrayList<>();
                items.add("事假");
                items.add("病假");
                items.add("婚假");
                items.add("产假");
                items.add("丧假");
                items.add("陪产假");*/
                presenter.querytype();
                break;
            case R.id.starttiemlayout:
            case R.id.select_leave_start_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button, TimePicker.MINUTE_TYPE_FIVE, new PopWindowManager.PopviewTimeCallback() {
                    @Override
                    public void setTime(long time, String week) {
                        paramsBean.setStartTime(time);
                        Log.e("TIME", "" + time);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String d = format.format(time);
                        selectstatrttime.setText(d);

                    }
                });
                break;
            case R.id.finishtimelayout:
            case R.id.select_leave_finish_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button, TimePicker.MINUTE_TYPE_FIVE, new PopWindowManager.PopviewTimeCallback() {
                    @Override
                    public void setTime(long time, String week) {
                        paramsBean.setEndTime(time);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String d = format.format(time);
                        selectfinishtime.setText(d);

                    }
                });
                break;
            case R.id.select_approvaler:
                callBack.GoTo(new ApprovalerSelectFragment(new ApprovalerSelectFragment.SetID() {
                    @Override
                    public void setID(String ID) {
                        paramsBean.setApproveManId(ID);
                    }

                    @Override
                    public void setName(String name) {
                        approvalname.setText(name);
                    }
                }), new QueryReviewersPresenterImpl());
                break;
            case R.id.makesure:
                paramsBean.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
                paramsBean.setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
                paramsBean.setReason(reason.getText().toString());
                if (paramsBean.getLeaveType() == null || paramsBean.getLeaveType().equals("")) {
                    postmesg("请选择请假类型");
                    return;

                }
                if (paramsBean.getStartTime() == -1 || paramsBean.getEndTime() == -1) {
                    postmesg("请选择时间");
                    return;
                }
                Calendar start = Calendar.getInstance();
                Calendar end = Calendar.getInstance();
                Date date = new Date();
                date.setTime(paramsBean.getStartTime());
                start.setTime(date);
                date.setTime(paramsBean.getEndTime());
                end.setTime(date);
                if (start.compareTo(end) >= 0) {
                    postmesg("时间选择错误");
                    return;
                }
                if (paramsBean.getApproveManId() == null) {
                    postmesg("请选择审批人");
                } else {
                    presenter.appaly(paramsBean);
                }
                break;
        }

    }

    @Override
    public void showList(ArrayList arrayList) {
        PopWindowManager.popListWindow(getActivity(), button, arrayList, new PopWindowManager.Popviewcallback() {
            @Override
            public void callback(int p) {
                paramsBean.setLeaveType(presenter.getTypeID(p));
                leavetype.setText(presenter.getTypeName(p));
            }
        }, "选择请假种类");
    }

    @Override
    public void backup() {
        callBack.Back(ApplyLeaveFragment.this);
    }

    private ApplysPresenter presenter;

    @Override
    public void setPresenter(ApplysPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
