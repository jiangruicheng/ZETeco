package com.zkteco.bigboss.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.QueryStatiRequest;
import com.zkteco.bigboss.bean.json.QueryStatiResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.Impl.ApplyPresenterImpl;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryAproPresenterImpl;
import com.zkteco.bigboss.mvp.presenter.Impl.SignCardPresenterImpl;
import com.zkteco.bigboss.util.FragmentCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyFragment extends BasemainFragment {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.myapply)
    Button myapply;
    @BindView(R.id.stati)
    TextView stati;
    @BindView(R.id.leave)
    ImageView leave;
    @BindView(R.id.signcard)
    ImageView signcard;

    public ApplyFragment() {
        // Required empty public constructor
        setIsshownavg(true);
    }

    private FragmentCallBack callBack;

/*
    @SuppressLint("ValidFragment")
    public ApplyFragment(Activity activity) {
        // Required empty public constructor
        if (activity instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) activity;
        }
    }
*/


    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_apply, container, false);
        unbinder = ButterKnife.bind(this, view);
        setStati();
        myapply = (Button) view.findViewById(R.id.myapply);
        back = (ImageView) view.findViewById(R.id.back);
        signcard = (ImageView) view.findViewById(R.id.signcard);
        leave = (ImageView) view.findViewById(R.id.leave);
        myapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new LeaveListFragment(false), new QueryAproPresenterImpl());
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Back(ApplyFragment.this);
            }
        });
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new ApplyLeaveFragment(), new ApplyPresenterImpl());
                /*callBack.callback(FragmentCallBack.GOTO_ApplyLeaveFragment);*/
            }
        });
        signcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*callBack.callback(FragmentCallBack.GOTO_SignCardFragment);*/
                callBack.GoTo(new SignCardFragment(), new SignCardPresenterImpl());
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setStati() {
        QueryStatiRequest request = new QueryStatiRequest();
        if (UserMesg.getInstance().getResponse() != null) {
            request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
            request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            request.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            request.getPayload().getParams().setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
        }
        Subscription subscription = ZKTecoRequest.getAPI().
                querystati(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<QueryStatiResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(QueryStatiResponse queryStatiResponse) {
                if (queryStatiResponse.getCode().equals("00000000")) {
                    stati.setText("当月请假: " + queryStatiResponse.getPayload().getResults().getMyStatistics().getTotalLeaveMins() + "分钟");
                }
            }
        });
    }
}
