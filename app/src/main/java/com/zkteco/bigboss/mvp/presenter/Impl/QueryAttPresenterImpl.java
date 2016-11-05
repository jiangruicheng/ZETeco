package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.QueryAttRequest;
import com.zkteco.bigboss.bean.json.QueryAttResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.QueryAttPresenter;
import com.zkteco.bigboss.mvp.view.QueryAttView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class QueryAttPresenterImpl implements QueryAttPresenter {
    QueryAttView view;

    @Override
    public void queryatt(long start, long end) {
        QueryAttRequest request = new QueryAttRequest();
        request.getPayload().getParams().setStartTime(start);
        request.getPayload().getParams().setEndTime(end);
        if (UserMesg.getInstance().getResponse() != null) {
            request.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            request.getPayload().getParams().setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
            request.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        }

        Subscription subscription = ZKTecoRequest.getAPI().
                queryatt(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<QueryAttResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(QueryAttResponse queryAttResponse) {
                        if (queryAttResponse.getCode().equals("00000000")) {
                            for (QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean pu : queryAttResponse.getPayload().getResults().getPunchEventList()) {
                                switch (pu.getSubType()) {
                                    case 0:
                                        view.showtype0(pu.getName(), pu.getValue());
                                        break;
                                    case 1:
                                        view.showtype1(pu.getName(), pu.getValue());
                                        break;
                                    case 3:
                                        view.showtype3(pu.getName(), pu.getValue());
                                        break;
                                }
                            }
                        }
                    }
                });
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (QueryAttView) view;
    }
}
