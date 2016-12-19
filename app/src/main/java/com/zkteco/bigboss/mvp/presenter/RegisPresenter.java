package com.zkteco.bigboss.mvp.presenter;

import com.zkteco.bigboss.mvp.BasePresenter;

/**
 * Created by jiang_ruicheng on 16/10/29.
 */
public interface RegisPresenter extends BasePresenter {
    void sendsmscaptcha(String user);

    void nextstep(String user, String captcha, NextDO nextDO);

    interface NextDO {
        void nextdothing();
    }
}
