package com.zkteco.bigboss.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zkteco.bigboss.R;
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
    @BindView(R.id.statu0)
    TextView statu0;
    @BindView(R.id.name0)
    TextView name0;
    @BindView(R.id.value0)
    TextView value0;
    @BindView(R.id.type0)
    LinearLayout type0;
    @BindView(R.id.statu1)
    TextView statu1;
    @BindView(R.id.name1)
    TextView name1;
    @BindView(R.id.value1)
    TextView value1;
    @BindView(R.id.type1)
    LinearLayout type1;
    @BindView(R.id.statu3)
    TextView statu3;
    @BindView(R.id.name3)
    TextView name3;
    @BindView(R.id.value3)
    TextView value3;
    @BindView(R.id.type3)
    LinearLayout type3;

    @OnClick(R.id.prvmonth)
    void setPrvmonth() {
        swichWeektoMonth.setCheckLift(false);
        mothData.swichMonthorWeek(false);
        ViewGroup.LayoutParams layoutParams = mothData.getLayoutParams();
        layoutParams.height = ScreenUtil.dip2px(getActivity(), 210);
        mothData.setLayoutParams(layoutParams);
        mothData.onLeftClick();
        currdatatext.setText(mothData.getmSelYear() + "年" + (mothData.getmSelMonth() + 1) + "月");
    }

    @BindView(R.id.currdatatext)
    TextView currdatatext;
    @BindView(R.id.nextmonth)
    ImageButton nextmonth;

    @OnClick(R.id.nextmonth)
    void setNextmonth() {
        swichWeektoMonth.setCheckLift(false);
        mothData.swichMonthorWeek(false);
        ViewGroup.LayoutParams layoutParams = mothData.getLayoutParams();
        layoutParams.height = ScreenUtil.dip2px(getActivity(), 210);
        mothData.setLayoutParams(layoutParams);
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Calendar.getInstance().get(Calendar.MONTH) + 1 + "月" + (Calendar.getInstance().get(Calendar.DATE) < 10 ? "0" + Calendar.getInstance().get(Calendar.DATE) : Calendar.getInstance().get(Calendar.DATE)) + "日" + " " + "星期" + DateUtils.getDay2Week(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1) + "\n");
        stringBuilder.append(UserMesg.getInstance().getResponse().getPayload().getResults().getName());
        textInfo.setText(stringBuilder);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(Calendar.getInstance().get(Calendar.YEAR) + "-" + Calendar.getInstance().get(Calendar.MONTH) + "-" + Calendar.getInstance().get(Calendar.DATE) + " 00:00");
            long start = date.getTime();
            date = simpleDateFormat.parse(Calendar.getInstance().get(Calendar.YEAR) + "-" + Calendar.getInstance().get(Calendar.MONTH) + "-" + Calendar.getInstance().get(Calendar.DATE) + " 23:59");
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
                if (presenter != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + mothData.getmSelMonth() + "-" + mothData.getmSelDay() + " 00:00");
                        long start = date.getTime();
                        date = simpleDateFormat.parse(mothData.getmSelYear() + "-" + mothData.getmSelMonth() + "-" + mothData.getmSelDay() + " 23:59");
                        long end = date.getTime();
                        presenter.queryatt(start, end);
                        Log.i("time", "onClick: " + start + "\n" + end);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        Log.i("time", "onClick: " + e.getMessage());
                    }

                }
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
    public void showtype0(String name, String value) {
        name0.setText(name);
        value0.setText(value);
    }

    @Override
    public void showtype1(String name, String value) {
        name1.setText(name);
        value1.setText(value);
    }

    @Override
    public void showtype3(String name, String value) {
        statu3.setText(name);
        name3.setText(name);
        value3.setText(value);
    }

    @Override
    public void setPresenter(QueryAttPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {

    }
}
