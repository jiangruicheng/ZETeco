package com.zkteco.bigboss.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
    private TextView selectstatrttime, selectfinishtime;
    private EditText reason;

    @Override
    public void onResume() {
        super.onResume();

        // callBack.SetVisable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_apply_leave, container, false);
        button = (Button) view.findViewById(R.id.makesure);
        selectapprovaler = (Button) view.findViewById(R.id.select_approvaler);
        back = view.findViewById(R.id.back);
        leavetypes = view.findViewById(R.id.leave_types);
        leavestarttime = view.findViewById(R.id.leave_start_time);
        leavefinishtime = view.findViewById(R.id.leave_finish_time);
        reason = (EditText) view.findViewById(R.id.reason);
        selectstatrttime = (TextView) view.findViewById(R.id.select_leave_start_time);
        selectfinishtime = (TextView) view.findViewById(R.id.select_leave_finish_time);
        button.setOnClickListener(this);
        selectapprovaler.setOnClickListener(this);
        back.setOnClickListener(this);
        leavetypes.setOnClickListener(this);
        leavefinishtime.setOnClickListener(this);
        leavestarttime.setOnClickListener(this);

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                /*callBack.callback(FragmentCallBack.BACK);*/
                callBack.Back(ApplyLeaveFragment.this);
                break;
            case R.id.leave_types:
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
            case R.id.leave_start_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button, new PopWindowManager.PopviewTimeCallback() {
                    @Override
                    public void setTime(long time) {
                        paramsBean.setStartTime(time);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String d = format.format(time);
                        selectstatrttime.setText(d);

                    }
                });
                break;
            case R.id.leave_finish_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button, new PopWindowManager.PopviewTimeCallback() {
                    @Override
                    public void setTime(long time) {
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
                }), new QueryReviewersPresenterImpl());
                break;
            case R.id.makesure:
                paramsBean.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
                paramsBean.setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
                paramsBean.setReason(reason.getText().toString());
                presenter.appaly(paramsBean);
                break;
        }
    }

    @Override
    public void showList(ArrayList arrayList) {
        PopWindowManager.popListWindow(getActivity(), button, arrayList, new PopWindowManager.Popviewcallback() {
            @Override
            public void callback(int p) {
                paramsBean.setLeaveType(presenter.getTypeID(p));
            }
        }, "选择请假种类");
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
