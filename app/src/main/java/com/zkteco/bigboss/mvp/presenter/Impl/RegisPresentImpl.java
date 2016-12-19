package com.zkteco.bigboss.mvp.presenter.Impl;

import android.util.Log;

import com.zkteco.bigboss.bean.json.SendSmsCaptchaRequest;
import com.zkteco.bigboss.bean.json.SendSmsCaptchaResponse;
import com.zkteco.bigboss.bean.json.VerifyCaptchaRequest;
import com.zkteco.bigboss.bean.json.VerifyCaptchaResponse;
import com.zkteco.bigboss.bean.json.VerifyRequest;
import com.zkteco.bigboss.bean.json.VerifyResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.RegisPresenter;
import com.zkteco.bigboss.mvp.view.RegisView;
import com.zkteco.bigboss.util.MD5;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/10/29.
 */
public class RegisPresentImpl implements RegisPresenter {
    private RegisView regisView;


    @Override
    public void sendsmscaptcha(String user) {
        final SendSmsCaptchaRequest sendSmsCaptchaRequest = new SendSmsCaptchaRequest();
        sendSmsCaptchaRequest.getPayload().getParams().setUsername(user);
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.getPayload().getParams().setUsername(user);
        Subscription subscription = ZKTecoRequest.getAccountAPI().verify(verifyRequest).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                map(new Func1<VerifyResponse, Boolean>() {
                    @Override
                    public Boolean call(VerifyResponse verifyResponse) {
                        if (verifyResponse.getCode().equals("00000000")) {
                            ZKTecoRequest.getAccountAPI().
                                    sendsmscaptcha(sendSmsCaptchaRequest).
                                    subscribeOn(Schedulers.io()).
                                    observeOn(AndroidSchedulers.mainThread()).
                                    subscribe(new Observer<SendSmsCaptchaResponse>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            regisView.postmesg(e.getMessage());
                                        }

                                        @Override
                                        public void onNext(SendSmsCaptchaResponse sendSmsCaptchaResponse) {

                                        }
                                    });
                            return true;
                        } else {
                            return false;
                        }
                    }
                }).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        regisView.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                        if (aBoolean) {
                            regisView.recount();
                            regisView.postmesg("验证码已发送");
                        } else {
                            regisView.postmesg("手机号已经注册");
                        }
                    }
                });
    }

    @Override
    public void nextstep(final String user, String captcha, final NextDO nextDO) {
        final String url = "http://218.17.43.228:28082/m/apiv1/account/verifycaptcha/";//+ MD5.GetMD5Code(user) + "/" + MD5.GetMD5Code(captcha)
        Log.i("MD5", "nextstep: " + "http://218.17.43.228:28080/apiv1/account/verifycaptcha/" + MD5.GetMD5Code(user) + "/" + MD5.GetMD5Code(captcha));
        VerifyCaptchaRequest r = new VerifyCaptchaRequest();
        r.getPayload().getParams().setUsername(user);
        r.getPayload().getParams().setCaptchaValue(MD5.GetMD5Code(captcha));
        Subscription subscription = ZKTecoRequest.getAccountAPI().
                verifycaptcha(url, r).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<VerifyCaptchaResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        regisView.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(VerifyCaptchaResponse verifyCaptchaResponse) {
                        if (verifyCaptchaResponse.getCode().equals("00000000")) {
                            nextDO.nextdothing();
                            regisView.replaceFragment();
                            UserMesg.getInstance().setAccount(user);
                            // regisView.postmesg(verifyCaptchaResponse.getMessage());
                        } else {
                            regisView.postmesg(verifyCaptchaResponse.getMessage());
                        }
                    }
                });
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.regisView = (RegisView) view;
    }
}
