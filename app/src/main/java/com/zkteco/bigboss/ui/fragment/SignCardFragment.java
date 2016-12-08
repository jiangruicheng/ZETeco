package com.zkteco.bigboss.ui.fragment;


import android.content.Context;
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
import com.zkteco.bigboss.bean.json.SignCardRequest;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryReviewersPresenterImpl;
import com.zkteco.bigboss.mvp.presenter.SignCardPresenter;
import com.zkteco.bigboss.mvp.view.SignCardView;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.view.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignCardFragment extends BasemainFragment implements SignCardView {
    private FragmentCallBack callBack;

    public SignCardFragment() {
        // Required empty public constructor
        setIsshownavg(false);
        paramsBean = new SignCardRequest.PayloadBean.ParamsBean();
    }

    private TextView selectTime, selectstarttime, approvalname, type;
    private EditText reason;
    private Button button, selectapprovaler;
    private View back;
    private SignCardRequest.PayloadBean.ParamsBean paramsBean;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FragmentCallBack) {
            callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //callBack.SetVisable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signcard, container, false);
        back = view.findViewById(R.id.back);
        approvalname = (TextView) view.findViewById(R.id.approvalname);
        reason = (EditText) view.findViewById(R.id.reason);
        selectapprovaler = (Button) view.findViewById(R.id.select_approvaler);
        type = (TextView) view.findViewById(R.id.sign_card_type);
        selectTime = (TextView) view.findViewById(R.id.signcard_start_time);
        button = (Button) view.findViewById(R.id.makesure);
        selectstarttime = (TextView) view.findViewById(R.id.select_start_time);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramsBean.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
                paramsBean.setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
                paramsBean.setReason(reason.getText().toString());
                if (paramsBean.getPunchType() == -1) {
                    postmesg("请选择签卡类型");
                    return;
                }
                if (paramsBean.getPunchTime() == -1) {
                    postmesg("请选择时间");
                    return;
                }
                if (paramsBean.getApproveManId() == null) {
                    postmesg("请选择审批人");
                } else {
                    presenter.signcard(paramsBean);
                }
            }
        });
        selectapprovaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Back(SignCardFragment.this);
            }
        });
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.quedic();
               /* ArrayList<String> item = new ArrayList<String>();
                item.add("上班签到");
                item.add("下班签退");
                PopWindowManager.popListWindow(getActivity(), button, item, new PopWindowManager.Popviewcallback() {
                    @Override
                    public void callback(int p) {

                    }
                }, "选择签卡种类");*/
            }
        });
        selectstarttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopWindowManager.poptimewindow(getActivity(), button, TimePicker.MINUTE_TYPE_ALL, new PopWindowManager.PopviewTimeCallback() {
                    @Override
                    public void setTime(long time, String week) {
                        paramsBean.setPunchTime(time);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String d = format.format(time);
                        selectstarttime.setText(d);

                    }
                });
            }
        });
        return view;
    }


    @Override
    public void showlist(ArrayList list) {
        PopWindowManager.popListWindow(getActivity(), button, list, new PopWindowManager.Popviewcallback() {
            @Override
            public void callback(int p) {
                paramsBean.setPunchType(Integer.valueOf(presenter.getTypeID(p)));
                type.setText(presenter.getTypeName(p));
            }
        }, "选择签卡种类");
    }

    @Override
    public void backup() {
        callBack.Back(SignCardFragment.this);
    }

    private SignCardPresenter presenter;

    @Override
    public void setPresenter(SignCardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
