package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.QueryAproResponse;
import com.zkteco.bigboss.bean.json.ReviewRequireRequest;
import com.zkteco.bigboss.bean.json.ReviewRequireResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.util.DateUtils;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.view.kankan.wheel.widget.DateObject;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LeaveMesegFragment extends BasemainFragment {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.leave_types)
    TextView leaveTypes;
    @BindView(R.id.leave_type)
    TextView leaveType;
    @BindView(R.id.applayimag)
    ImageView applayimag;
    @BindView(R.id.select_leave_start_time)
    TextView selectLeaveStartTime;
    @BindView(R.id.leave_finish_time)
    TextView leaveFinishTime;
    @BindView(R.id.select_leave_finish_time)
    TextView selectLeaveFinishTime;
    @BindView(R.id.approvalimag)
    ImageView approvalimag;
    @BindView(R.id.content_leave)
    RelativeLayout contentLeave;
    @BindView(R.id.imag_approvaler)
    ImageView imagApprovaler;
    @BindView(R.id.returnoff)
    Button returnoff;
    @BindView(R.id.makesure)
    Button makesure;
    @BindView(R.id.bottom_button)
    LinearLayout bottomButton;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.reason)
    TextView reason;

    @OnClick(R.id.back)
    void setBack() {
        callBack.Back(this);
    }

    @OnClick(R.id.makesure)
    void makesure() {
        reviewRequire(1);
    }

    @OnClick(R.id.returnoff)
    void returnoff() {
        reviewRequire(2);
    }

    private boolean ButtonVisable;
    private FragmentCallBack callBack;
    private QueryAproResponse.PayloadBean.ResultsBean bean;

    public interface callback {
        void callback();
    }

    private callback c;

    public void setCallBack(callback c) {
        this.c = c;
    }

    public void setBean(QueryAproResponse.PayloadBean.ResultsBean bean) {
        this.bean = bean;
    }

    public LeaveMesegFragment() {
    }

    public LeaveMesegFragment(boolean b) {
        // Required empty public constructor
        ButtonVisable = b;
        setIsshownavg(false);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //callBack.SetVisable(false);
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_meseg, container, false);
        unbinder = ButterKnife.bind(this, view);
        reason.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (ButtonVisable && bean != null) {
            switch (bean.getType()) {
                case 5:
                    titleText.setText("签卡");
                    break;
                case 1:
                    titleText.setText("请假");
                    break;
            }
            approvalimag.setVisibility(View.VISIBLE);
            switch (bean.getApproveStatus()) {
                case 2:
                    bottomButton.setVisibility(View.GONE);
                    approvalimag.setBackgroundResource(R.drawable.unpass);
                    break;
                case 1:
                    bottomButton.setVisibility(View.GONE);
                    approvalimag.setBackgroundResource(R.drawable.pass);
                    break;
                case 0:
                    bottomButton.setVisibility(View.VISIBLE);
                    approvalimag.setVisibility(View.GONE);
                    break;
            }


        } else {
            int i = bean.getType();
            switch (bean.getType()) {
                case 5:
                    titleText.setText("我的签卡单");
                    break;
                case 1:
                    titleText.setText("我的请假单");
                    break;

            }
            approvalimag.setVisibility(View.VISIBLE);
            switch (bean.getApproveStatus()) {
                case 2:
                    approvalimag.setBackgroundResource(R.drawable.unpass);
                    break;
                case 1:
                    approvalimag.setBackgroundResource(R.drawable.pass);
                    break;
                case 0:
                    approvalimag.setVisibility(View.GONE);
                    break;
            }
            bottomButton.setVisibility(View.GONE);

        }
        name.setText(bean.getName());
        if (bean.getType() == 5) {
            Date date = new Date(bean.getPunchTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int startweek = calendar.get(Calendar.DAY_OF_WEEK);

            startweek = startweek % 7 == 0 ? 7 : startweek % 7;
            selectLeaveStartTime.setText(DateUtils.parseDataYMDHM(bean.getPunchTime()) + " " + DateObject.getDayOfWeekCN(startweek));
        } else {
            Date date = new Date(bean.getStartTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int startweek = calendar.get(Calendar.DAY_OF_WEEK);
            date.setTime(bean.getEndTime());
            calendar.setTime(date);
            int endweek = calendar.get(Calendar.DAY_OF_WEEK);
            startweek = startweek % 7 == 0 ? 7 : startweek % 7;
            endweek = endweek % 7 == 0 ? 7 : endweek % 7;
            selectLeaveStartTime.setText(DateUtils.parseDataYMDHM(bean.getStartTime()) + " " + DateObject.getDayOfWeekCN(startweek));
            selectLeaveFinishTime.setText(DateUtils.parseDataYMDHM(bean.getEndTime()) + " " + DateObject.getDayOfWeekCN(endweek));
        }
        reason.setText(bean.getReason());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void reviewRequire(int statu) {
        ReviewRequireRequest reviewRequireRequest = new ReviewRequireRequest();
        reviewRequireRequest.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        reviewRequireRequest.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        reviewRequireRequest.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        reviewRequireRequest.getPayload().getParams().setType(bean.getType());
        reviewRequireRequest.getPayload().getParams().setApproveStatus(statu);
        reviewRequireRequest.getPayload().getParams().setUid(bean.getUid());


        Subscription subscription = ZKTecoRequest.getATTPAI().reviewrequire(reviewRequireRequest).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Observer<ReviewRequireResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ReviewRequireResponse reviewRequireResponse) {
                        if (reviewRequireResponse.getCode().equals("00000000")) {
                            Toast.makeText(getActivity(), "审批成功", Toast.LENGTH_SHORT).show();
                            callBack.Back(LeaveMesegFragment.this);
                            if (c != null) {
                                c.callback();
                            }
                        }
                    }
                });
    }
}
