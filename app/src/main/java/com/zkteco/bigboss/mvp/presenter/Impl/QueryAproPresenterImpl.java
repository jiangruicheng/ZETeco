package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.QueryAproResponse;
import com.zkteco.bigboss.bean.json.QueryAprolistRquest;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.QueryAproPresentrer;
import com.zkteco.bigboss.mvp.view.QueryAproView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/4.
 */
public class QueryAproPresenterImpl implements QueryAproPresentrer {
    public final static int NOT = 0;
    public final static int YES = 3;
    public final static int APPLY = 4;
    public final static int APPROVAL = 5;

    private QueryAproView view;

    @Override
    public void queryApro(int applyorapproval, int statu) {
        QueryAprolistRquest rquest = new QueryAprolistRquest();
        if (UserMesg.getInstance().getResponse() != null) {
            if (applyorapproval == APPLY) {
                rquest.getPayload().getParams().setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
            }
            if (applyorapproval == APPROVAL) {
                rquest.getPayload().getParams().setApproveManId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
            }
            rquest.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            rquest.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
            rquest.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
            rquest.getPayload().getParams().setCurPage(1);
            rquest.getPayload().getParams().setPageSize(20);
            rquest.getPayload().getParams().setApprovalRet(statu);
        }
        view.showprogs("");
        Subscription subscription = ZKTecoRequest.getATTPAI().
                queryaprolist(rquest).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<QueryAproResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(QueryAproResponse queryAproResponse) {
                        view.showlist(queryAproResponse.getPayload().getResults());
                        view.displayprogs();
                    }
                });
    }


    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (QueryAproView) view;
    }
}
