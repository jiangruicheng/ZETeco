package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.CheckoutCmpindusRequest;
import com.zkteco.bigboss.bean.json.CmpIndusResponse;
import com.zkteco.bigboss.bean.json.SetupCmpRequest;
import com.zkteco.bigboss.bean.json.SetupCmpResponse;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.SetupCompanyPresenter;
import com.zkteco.bigboss.mvp.view.SetupCompanyView;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class SetupCompanyPresenterImpl implements SetupCompanyPresenter {
    private SetupCompanyView view;
    private CheckoutCmpindusRequest checkoutCmpindusRequest;
    private CmpIndusResponse cmpIndus;

    @Override
    public void checkoutindu() {
        checkoutCmpindusRequest = new CheckoutCmpindusRequest();

        Subscription subscription = ZKTecoRequest.getAPI().
                checkoutindu(checkoutCmpindusRequest).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                map(new Func1<CmpIndusResponse, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> call(CmpIndusResponse cmpIndusResponse) {
                        ArrayList<String> item = new ArrayList<String>();
                        cmpIndus = cmpIndusResponse;
                        for (int i = 0; i < cmpIndusResponse.getPayload().getResults().size(); i++) {
                            item.add(cmpIndusResponse.getPayload().getResults().get(i).getName());
                        }
                        return item;
                    }
                }).subscribe(new Observer<ArrayList<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.postmesg(e.getMessage());
            }

            @Override
            public void onNext(ArrayList<String> strings) {
                view.showindus(strings);
            }
        });
    }

    SetupCmpRequest request;

    @Override
    public void setup(int id) {
        request = new SetupCmpRequest();
        request.getPayload().getParams().setIndustryId(cmpIndus.getPayload().getResults().get(id).getIndustryId() + "");
        Subscription subscription = ZKTecoRequest.getAPI().
                setupcmp(request).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Observer<SetupCmpResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SetupCmpResponse setupCmpResponse) {

                    }
                });
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (SetupCompanyView) view;
    }
}
