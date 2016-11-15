package com.zkteco.bigboss.mvp.presenter;

import com.zkteco.bigboss.bean.json.SignCardRequest;
import com.zkteco.bigboss.mvp.BasePresenter;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public interface SignCardPresenter extends BasePresenter {
    void signcard(SignCardRequest.PayloadBean.ParamsBean paramsBean);

    void quedic();

    String getTypeID(int id);
}
