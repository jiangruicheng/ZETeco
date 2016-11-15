package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.QueDescRequest;
import com.zkteco.bigboss.bean.json.QueDescResponse;
import com.zkteco.bigboss.bean.json.SignCardRequest;
import com.zkteco.bigboss.bean.json.SignCardResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.SignCardPresenter;
import com.zkteco.bigboss.mvp.view.SignCardView;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public class SignCardPresenterImpl implements SignCardPresenter {
    private SignCardView view;

    @Override
    public void signcard(SignCardRequest.PayloadBean.ParamsBean paramsBean) {
        SignCardRequest request = new SignCardRequest();
        request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        request.getPayload().setParams(paramsBean);
        Subscription subscription = ZKTecoRequest.getAPI().
                signcard(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<SignCardResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(SignCardResponse signCardResponse) {
                        view.postmesg(signCardResponse.getMessage());
                    }
                });
    }

    @Override
    public void quedic() {
        QueDescRequest request = new QueDescRequest();
        request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        request.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        request.getPayload().getParams().setEmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getEmpId());
        Subscription subscription = ZKTecoRequest.getAPI().
                quedesc(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Func1<QueDescResponse, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> call(QueDescResponse queDescResponse) {
                        response = queDescResponse;
                        ArrayList<String> arrayList = new ArrayList<String>();
                        for (int i = 0; i < queDescResponse.getPayload().getResults().size(); i++) {
                            arrayList.add(queDescResponse.getPayload().getResults().get(i).getDesc());
                        }
                        return arrayList;
                    }
                }).
                subscribe(new Observer<ArrayList<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(ArrayList<String> arrayList) {

                        view.showlist(arrayList);
                    }
                });
    }

    private QueDescResponse response;

    @Override
    public String getTypeID(int id) {
        if (response != null) {
            return response.getPayload().getResults().get(id).getValue();
        }
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (SignCardView) view;
    }
}
