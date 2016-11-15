package com.zkteco.bigboss.mvp.presenter;

import android.content.Context;

import com.zkteco.bigboss.bean.json.SetupCmpRequest;
import com.zkteco.bigboss.mvp.BasePresenter;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public interface SetupCompanyPresenter extends BasePresenter {
    void checkoutindu();

    void setup(SetupCmpRequest.PayloadBean.ParamsBean paramsBean, Context context);

    String getIndID(int id);
}
