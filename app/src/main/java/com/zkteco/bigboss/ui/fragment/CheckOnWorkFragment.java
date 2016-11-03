package com.zkteco.bigboss.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.view.Lift2Right;
import com.zkteco.bigboss.view.MothDataView;
import com.zkteco.bigboss.view.WeekView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CheckOnWorkFragment extends BasemainFragment {
    @BindView(R.id.main_title)
    RelativeLayout mainTitle;
    @BindView(R.id.account_imag)
    ImageView accountImag;
    @BindView(R.id.text_info)
    TextView textInfo;
    @BindView(R.id.imag_apply)
    ImageView imagApply;
    @BindView(R.id.layout_imag_apply)
    LinearLayout layoutImagApply;
    @BindView(R.id.imag_approval)
    ImageView imagApproval;
    @BindView(R.id.linear_approval)
    LinearLayout linearApproval;
    @BindView(R.id.swichWeektoMonth)
    Lift2Right swichWeektoMonth;
    @BindView(R.id.prvmonth)
    ImageButton prvmonth;

    @OnClick(R.id.prvmonth)
    void setPrvmonth() {
        mothData.onLeftClick();
        currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
    }

    @BindView(R.id.currdatatext)
    TextView currdatatext;
    @BindView(R.id.nextmonth)
    ImageButton nextmonth;

    @OnClick(R.id.nextmonth)
    void setNextmonth() {
        mothData.onRightClick();
        currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
    }

    @BindView(R.id.weekview)
    WeekView weekview;
    @BindView(R.id.mothData)
    MothDataView mothData;
    private ImageView apply;
    private ImageView approval;
    private FragmentCallBack callBack;

    public CheckOnWorkFragment() {
        setIsshownavg(true);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_on_work, container, false);
        unbinder = ButterKnife.bind(this, view);
        currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
        weekview.setLineColor(Color.BLACK);
        swichWeektoMonth.setOnButtonClick(new Lift2Right.OnButtonClick() {
            @Override
            public void onClick(boolean IsCheckLift) {
                mothData.swichMonthorWeek(IsCheckLift);
            }
        });
        imagApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                startActivity(new Intent(getActivity(), ApplyActivity.class));
*/

                callBack.GoTo(new ApplyFragment());
            }
        });
        imagApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new LeaveListFragment(true));
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
