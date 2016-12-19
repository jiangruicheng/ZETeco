package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.ApplyCmpResponse;
import com.zkteco.bigboss.bean.json.ApplyJoinCmpRequest;
import com.zkteco.bigboss.bean.json.SearchCompanyRequest;
import com.zkteco.bigboss.bean.json.SearchCompanyResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.ApplyJoinCompanyPresenter;
import com.zkteco.bigboss.mvp.view.ApplyJoinCompanyView;
import com.zkteco.bigboss.util.MD5;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class ApplyJoinCompanyPresenterImpl implements ApplyJoinCompanyPresenter {
    private ApplyJoinCompanyView view;
    private SearchCompanyResponse searchCompanyResponse;

    @Override
    public void search(String id) {
        SearchCompanyRequest request = new SearchCompanyRequest();
        request.getPayload().getParams().setCmpNumber(id);
        Subscription subscription = ZKTecoRequest.getATTPAI().
                searchcompany(request).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Observer<SearchCompanyResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null)
                            view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(SearchCompanyResponse searchCompanyRespose) {
                        if (view != null)
                            view.showList(searchCompanyRespose);
                        ApplyJoinCompanyPresenterImpl.this.searchCompanyResponse = searchCompanyRespose;
                    }
                });
    }


    @Override
    public void applyjoin() {
        ApplyJoinCmpRequest request = new ApplyJoinCmpRequest();
        request.getPayload().getParams().setUsername(UserMesg.getInstance().getAccount());
        request.getPayload().getParams().setFirstName(UserMesg.getInstance().getUsername());
        request.getPayload().getParams().setPassword(MD5.GetMD5Code(UserMesg.getInstance().getPassword()));
        request.getPayload().getParams().setIscompany(false);
        request.getPayload().getParams().setAgree(true);
        request.getPayload().getParams().setCmpId(searchCompanyResponse.getPayload().getResults().getCmpId());
        request.getPayload().getParams().setCmpName(searchCompanyResponse.getPayload().getResults().getCmpName());
        Subscription subscription = ZKTecoRequest.getAccountAPI().
                applyjoincompany(request).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Observer<ApplyCmpResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null)
                            view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(ApplyCmpResponse applyCmpResponse) {
                        if (applyCmpResponse.getCode().equals("00000000")) {
                            if (view != null)
                                view.postmesg(applyCmpResponse.getMessage());
                        }
                    }
                });

    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (ApplyJoinCompanyView) view;
    }
}
