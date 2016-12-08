package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.QueryAttRequest;
import com.zkteco.bigboss.bean.json.QueryAttResponse;
import com.zkteco.bigboss.bean.json.bean.AttMesg;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.QueryAttPresenter;
import com.zkteco.bigboss.mvp.view.QueryAttView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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

        Subscription subscription = ZKTecoRequest.getATTPAI().
                queryatt(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Func1<QueryAttResponse, AttMesg[]>() {
                    @Override
                    public AttMesg[] call(QueryAttResponse queryAttResponse) {
                        AttMesg[] attMesgs = new AttMesg[31];
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        if (queryAttResponse.getPayload().getResults().getPunchEventList() != null && !queryAttResponse.getPayload().getResults().getPunchEventList().isEmpty()) {
                            for (QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean punch : queryAttResponse.getPayload().getResults().getPunchEventList()) {
                                try {
                                    Date date = simpleDateFormat.parse(punch.getAttDate());
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(date);
                                    int index = c.get(Calendar.DAY_OF_MONTH) - 1;
                                    if (attMesgs[index] != null) {
                                        attMesgs[index].getPunchEventList().add(punch);
                                    } else {
                                        attMesgs[index] = new AttMesg();
                                        attMesgs[index].getPunchEventList().add(punch);
                                    }
                                    if (punch.getSubType() != 0 && punch.getSubType() != 1) {
                                        attMesgs[index].setIserro(true);
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        return attMesgs;
                    }
                }).
                subscribe(new Observer<AttMesg[]>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(AttMesg[] attMesgs) {
                        view.setmonthatt(attMesgs);
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
