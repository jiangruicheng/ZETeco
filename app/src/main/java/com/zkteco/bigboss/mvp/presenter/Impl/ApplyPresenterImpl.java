package com.zkteco.bigboss.mvp.presenter.Impl;

import com.zkteco.bigboss.bean.json.AskForLeaveRequest;
import com.zkteco.bigboss.bean.json.AskForLeaveResponse;
import com.zkteco.bigboss.bean.json.QueSubTypeRequest;
import com.zkteco.bigboss.bean.json.QueSubTypeResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.ApplysPresenter;
import com.zkteco.bigboss.mvp.view.ApplyView;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/12.
 */
public class ApplyPresenterImpl implements ApplysPresenter {
    ApplyView view;

    @Override
    public void appaly(AskForLeaveRequest.PayloadBean.ParamsBean paramsBean) {
        AskForLeaveRequest request = new AskForLeaveRequest();
        request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        request.getPayload().setParams(paramsBean);
        Subscription subscription = ZKTecoRequest.getATTPAI().
                askforleave(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<AskForLeaveResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(AskForLeaveResponse askForLeaveResponse) {
                        if (askForLeaveResponse.getCode().equals("00000000")) {
                            view.postmesg("申请成功");
                            view.backup();
                        } else {
                            view.postmesg(askForLeaveResponse.getMessage());
                            //view.backup();
                        }
                    }
                });
    }

    @Override
    public void querytype() {
        final QueSubTypeRequest request = new QueSubTypeRequest();
        request.setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        request.setSessionId(UserMesg.getInstance().getResponse().getSessionId());
        request.getPayload().getParams().setCmpId(UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId() == null ? "" : UserMesg.getInstance().getResponse().getPayload().getResults().getCmpId());
        Subscription subscription = ZKTecoRequest.getATTPAI().
                quesubtype(request).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Func1<QueSubTypeResponse, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> call(QueSubTypeResponse queSubTypeResponse) {
                        response = queSubTypeResponse;
                        ArrayList<String> arrayList = new ArrayList<String>();
                        for (int i = 0; i < queSubTypeResponse.getPayload().getResults().size(); i++) {
                            arrayList.add(queSubTypeResponse.getPayload().getResults().get(i).getTitle());
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

                        view.showList(arrayList);
                    }
                });
    }

    private QueSubTypeResponse response;

    @Override
    public String getTypeID(int id) {
        if (response != null)
            return response.getPayload().getResults().get(id).getSubType();
        return null;
    }

    @Override
    public String getTypeName(int id) {
        if (response != null)
            return response.getPayload().getResults().get(id).getTitle();
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (ApplyView) view;
    }
}
