package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.adpater.MesgListAdapter;
import com.zkteco.bigboss.bean.json.QueryAproResponse;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryAproPresenterImpl;
import com.zkteco.bigboss.mvp.presenter.QueryAproPresentrer;
import com.zkteco.bigboss.mvp.view.QueryAproView;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.view.Lift2Right;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LeaveListFragment extends BasemainFragment implements QueryAproView {

    @BindView(R.id.back)
    ImageView back;

    @OnClick(R.id.back)
    void setBack() {
        callBack.Back(this);
    }

    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.approval_switch)
    Lift2Right approvalSwitch;
    @BindView(R.id.approval_list)
    ListView approvalList;
    @BindView(R.id.title_txt)
    TextView titleTxt;
    private QueryAproPresentrer presentrer;
    private FragmentCallBack callBack;

    private boolean isapproval;

    public LeaveListFragment(boolean isapproval) {
        // Required empty public constructor
        this.isapproval = isapproval;
        setIsshownavg(true);
    }


    @Override
    public void onResume() {
        super.onResume();

        //callBack.SetVisable(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    private MesgListAdapter mesgListAdapter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_leave_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        mesgListAdapter = new MesgListAdapter(getActivity());
        if (isapproval) {
            titleTxt.setText("审批");
            approvalSwitch.setLiftText("待审批");
            approvalSwitch.setRightText("已审批");
        } else {
            titleTxt.setText("我的申请");
            approvalSwitch.setLiftText("待处理");
            approvalSwitch.setRightText("已处理");

        }

        approvalSwitch.setOnButtonClick(new Lift2Right.OnButtonClick() {
            @Override
            public void onClick(boolean IsCheckLift) {
                if (presentrer != null) {
                    if (isapproval) {
                        if (IsCheckLift) {
                            presentrer.queryApro(QueryAproPresenterImpl.APPROVAL, QueryAproPresenterImpl.NOT);
                        } else {
                            presentrer.queryApro(QueryAproPresenterImpl.APPROVAL, QueryAproPresenterImpl.NOT);
                        }
                    } else {
                        if (IsCheckLift) {
                            presentrer.queryApro(QueryAproPresenterImpl.APPLY, QueryAproPresenterImpl.NOT);
                        } else {
                            presentrer.queryApro(QueryAproPresenterImpl.APPLY, QueryAproPresenterImpl.NOT);

                        }
                    }
                }
            }
        });
        approvalList.setAdapter(mesgListAdapter);
        approvalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callBack.GoTo(new LeaveMesegFragment(isapproval));
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showlist(List<QueryAproResponse.PayloadBean.ResultsBean> list) {
        mesgListAdapter.setList(list);
        mesgListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(QueryAproPresentrer presenter) {
        this.presentrer = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
