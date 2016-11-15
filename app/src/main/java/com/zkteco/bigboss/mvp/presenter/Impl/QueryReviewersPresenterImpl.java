package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.QueryReviewersRequest;
import com.zkteco.bigboss.bean.json.QueryReviewersResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.QueryReviewersPresenter;
import com.zkteco.bigboss.mvp.view.ReviewersView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public class QueryReviewersPresenterImpl implements QueryReviewersPresenter {

    @Override
    public void queryreviewers() {
        /*QueryReviewersResponse.PayloadBean.ResultsBean p = new QueryReviewersResponse.PayloadBean.ResultsBean();
        p.setName("卢鹏琳");
        QueryReviewersResponse.PayloadBean.ResultsBean s = new QueryReviewersResponse.PayloadBean.ResultsBean();
        s.setName("姜睿丞");
        List<QueryReviewersResponse.PayloadBean.ResultsBean> list = new ArrayList<>();
        list.add(p);
        list.add(s);
        view.showList(list);
*/
        QueryReviewersRequest reviewersRequest = new QueryReviewersRequest();
        reviewersRequest.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        reviewersRequest.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        reviewersRequest.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        reviewersRequest.getPayload().getParams().setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
        Subscription subscription = ZKTecoRequest.getAPI().
                queryreviewers(reviewersRequest).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<QueryReviewersResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(QueryReviewersResponse queryReviewersResponse) {
                        view.showList(queryReviewersResponse.getPayload().getResults());
                    }
                });
    }

    @Override
    public void start() {

    }

    private ReviewersView view;

    @Override
    public void setview(BaseView view) {
        this.view = (ReviewersView) view;
    }
}
