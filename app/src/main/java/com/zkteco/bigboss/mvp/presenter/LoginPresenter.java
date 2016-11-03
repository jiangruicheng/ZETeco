package com.zkteco.bigboss.mvp.presenter;

import android.content.Context;

import com.zkteco.bigboss.mvp.BasePresenter;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public interface LoginPresenter extends BasePresenter {
    void login(Context context,String user,String password);
}
