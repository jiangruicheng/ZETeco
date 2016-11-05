package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.util.FragmentCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


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

    @OnClick(R.id.back)
    void setBack() {
        callBack.Back(this);
    }

    private boolean ButtonVisable;
    private FragmentCallBack callBack;

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
        if (ButtonVisable) {
            bottomButton.setVisibility(View.VISIBLE);
        } else {
            bottomButton.setVisibility(View.GONE);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
