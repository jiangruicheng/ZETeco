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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.adpater.AttListAdapter;
import com.zkteco.bigboss.bean.json.QueryAttResponse;
import com.zkteco.bigboss.bean.json.bean.AttMesg;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryAproPresenterImpl;
import com.zkteco.bigboss.mvp.presenter.QueryAttPresenter;
import com.zkteco.bigboss.mvp.view.QueryAttView;
import com.zkteco.bigboss.util.DateUtils;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.util.ScreenUtil;
import com.zkteco.bigboss.view.Lift2Right;
import com.zkteco.bigboss.view.MothDataView;
import com.zkteco.bigboss.view.WeekView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CheckOnWorkFragment extends BasemainFragment implements QueryAttView {
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
    @BindView(R.id.attlist)
    ListView attlist;


    @OnClick(R.id.prvmonth)
    void setPrvmonth() {
        // ViewGroup.LayoutParams layoutParams = mothData.getLayoutParams();
        /*layoutParams.height = ScreenUtil.dip2px(getActivity(), 210);
        mothData.setLayoutParams(layoutParams);*/
        mothData.onLeftClick();
        if (!swichWeektoMonth.isCheckLift()){
            currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date date = null;
            try {
                date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + 1 + " 00:00");
                long start = date.getTime();
                date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + DateUtils.getMonthDays(mothData.getmSelYear(), mothData.getmSelMonth()) + " 23:59");
                long end = date.getTime();
                presenter.queryatt(start, end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @BindView(R.id.currdatatext)
    TextView currdatatext;
    @BindView(R.id.nextmonth)
    ImageButton nextmonth;

    @OnClick(R.id.nextmonth)
    void setNextmonth() {
        /*ViewGroup.LayoutParams layoutParams = mothData.getLayoutParams();
        layoutParams.height = ScreenUtil.dip2px(getActivity(), 210);
        mothData.setLayoutParams(layoutParams);*/
        mothData.onRightClick();
        if (!swichWeektoMonth.isCheckLift()){
            currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date date = null;
            try {
                date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + 1 + " 00:00");
                long start = date.getTime();
                date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + DateUtils.getMonthDays(mothData.getmSelYear(), mothData.getmSelMonth()) + " 23:59");
                long end = date.getTime();
                presenter.queryatt(start, end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    @BindView(R.id.weekview)
    WeekView weekview;
    @BindView(R.id.mothData)
    MothDataView mothData;
    private ImageView apply;
    private ImageView approval;
    private FragmentCallBack callBack;
    private QueryAttPresenter presenter;

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
        adapter = new AttListAdapter();
        attlist.setAdapter(adapter);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Calendar.getInstance().get(Calendar.MONTH) + 1 + "月" + (Calendar.getInstance().get(Calendar.DATE) < 10 ? "0" + Calendar.getInstance().get(Calendar.DATE) : Calendar.getInstance().get(Calendar.DATE)) + "日" + " " + "星期" + DateUtils.getDay2Week(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1) + "\n");
        stringBuilder.append(UserMesg.getInstance().getResponse().getPayload().getResults().getName());
        textInfo.setText(stringBuilder);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" + 1 + " 00:00");
            long start = date.getTime();
            date = simpleDateFormat.parse(Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" + Calendar.getInstance().get(Calendar.DATE) + " 23:59");
            long end = date.getTime();
            presenter.queryatt(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
        weekview.setLineColor(Color.BLACK);
        swichWeektoMonth.setOnButtonClick(new Lift2Right.OnButtonClick() {
            @Override
            public void onClick(boolean IsCheckLift) {
                mothData.swichMonthorWeek(IsCheckLift);
                ViewGroup.LayoutParams layoutParams = mothData.getLayoutParams();
                if (IsCheckLift) {
                    layoutParams.height = ScreenUtil.dip2px(getActivity(), 210 / 6);
                    mothData.setLayoutParams(layoutParams);

                } else {
                    layoutParams.height = ScreenUtil.dip2px(getActivity(), 210);
                    mothData.setLayoutParams(layoutParams);

                }
            }
        });
        imagApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                startActivity(new Intent(getActivity(), ApplyActivity.class));
*/

                callBack.GoTo(new ApplyFragment(), null);
            }
        });
        imagApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new LeaveListFragment(true), new QueryAproPresenterImpl());
            }
        });
        mothData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mothData.getMesgs() != null)
                    if (mothData.getMesgs()[mothData.getmSelDay() - 1] == null) {
                        showlist(null);
                    } else {
                        showlist(mothData.getMesgs()[mothData.getmSelDay() - 1].getPunchEventList());
                    }

                /*if (presenter != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + mothData.getmSelDay() + " 00:00");
                        long start = date.getTime();
                        date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + mothData.getmSelDay() + " 23:59");
                        long end = date.getTime();

                        presenter.queryatt(start, end);
                        Log.i("time", "onClick: " + start + "\n" + end);
                        Log.i("time", "onClick: " + mothData.getmSelYear() + "-" + (mothData.getmSelMonth() + 1) + "-" + mothData.getmSelDay() + " 00:00");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        Log.i("time", "onClick: " + e.getMessage());
                    }

                }*/
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


    @Override
    public void setPresenter(QueryAttPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    private AttListAdapter adapter;

    @Override
    public void showlist(List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> list) {
        adapter.setList(list);
    }

    @Override
    public void setmonthatt(AttMesg[] attMesgs) {
        mothData.setMesgs(attMesgs);
    }
}
