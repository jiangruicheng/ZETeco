package com.zkteco.bigboss.mvp.presenter;

import com.zkteco.bigboss.bean.json.AskForLeaveRequest;
import com.zkteco.bigboss.mvp.BasePresenter;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public interface ApplysPresenter extends BasePresenter {
    void appaly(AskForLeaveRequest.PayloadBean.ParamsBean paramsBean);

    void querytype();

    String getTypeName(int id);

    String getTypeID(int id);
}
