package com.zkteco.bigboss.mvp.presenter.Impl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zkteco.bigboss.bean.json.LoginRequest;
import com.zkteco.bigboss.bean.json.LoginResponse;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.LoginPresenter;
import com.zkteco.bigboss.mvp.view.LoginView;
import com.zkteco.bigboss.ui.activity.MainActivity;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginRequest loginRequest;
    LoginRequest.PayloadBean payloadBean;
    LoginRequest.PayloadBean.ParamsBean paramsBean;
    private LoginView loginView;

    @Override
    public void login(final Context context, String user, String password) {
        loginRequest = new LoginRequest();
        payloadBean = new LoginRequest.PayloadBean();
        paramsBean = new LoginRequest.PayloadBean.ParamsBean();
        /*paramsBean.setUsername(user);
        try {
            paramsBean.setPassword(MD5.getMD5(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/
        payloadBean.setParams(paramsBean);
        loginRequest.setPayload(payloadBean);
        Subscription subscription = ZKTecoRequest.getAPI().
                login(loginRequest).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        if (loginResponse.getCode().equals("00000000")) {
                            context.startActivity(new Intent(context, MainActivity.class));
                        }
                    }
                });

    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        loginView = (LoginView) view;
    }
}
