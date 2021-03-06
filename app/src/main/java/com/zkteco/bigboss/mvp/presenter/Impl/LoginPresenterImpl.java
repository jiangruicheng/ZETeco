package com.zkteco.bigboss.mvp.presenter.Impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zkteco.bigboss.bean.json.LoginRequest;
import com.zkteco.bigboss.bean.json.LoginResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.LoginPresenter;
import com.zkteco.bigboss.mvp.view.LoginView;
import com.zkteco.bigboss.ui.activity.MainActivity;
import com.zkteco.bigboss.util.MD5;

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
        paramsBean.setUsername(user);
        paramsBean.setPassword(MD5.GetMD5Code(password));
        payloadBean.setParams(paramsBean);
        loginRequest.setPayload(payloadBean);
        if (loginView != null) {
            loginView.showprogs();
        }
        Subscription subscription = ZKTecoRequest.getATTPAI().
                login(loginRequest).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (loginView != null) {
                            loginView.displayprogs();
                            loginView.postmesg(e.getMessage());
                        }
                        Log.e("error", "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        if (loginView != null) {
                            loginView.displayprogs();
                        }
                        if (loginResponse.getCode().equals("00000000")) {
                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity) context).finish();
                            UserMesg.getInstance().setResponse(loginResponse);
                            Log.e("onNext", "session: " + loginResponse.getSessionId());
                            Log.e("onNext", "cmp: " + loginResponse.getPayload().getResults().getCmpId());
                            Log.e("onNext", "emp: " + loginResponse.getPayload().getResults().getEmpId());
                        } else {
                            switch (loginResponse.getCode()) {
                                case "E1ASU201":
                                    if (loginView != null) {
                                        loginView.postmesg("对不起,用户名不能为空");
                                    }
                                    break;
                                case "E1ASU203":
                                    if (loginView != null) {
                                        loginView.postmesg("对不起,手机号未注册");
                                    }
                                    break;
                                case "E1ASU204":
                                    if (loginView != null) {
                                        loginView.postmesg("对不起,用户名格式不对");
                                    }
                                    break;
                                case "E1ASU205":
                                    if (loginView != null) {
                                        loginView.postmesg("对不起,密码错误");
                                    }
                                    break;
                                default:
                                    if (loginView != null) {
                                        loginView.postmesg(loginResponse.getMessage());
                                    }
                                    break;

                            }
                            Log.e("error", "onError: " + loginResponse.getMessage());
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
