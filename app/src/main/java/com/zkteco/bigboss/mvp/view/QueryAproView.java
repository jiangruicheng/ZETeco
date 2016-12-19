package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.bean.json.QueryAproResponse;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.QueryAproPresentrer;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/4.
 */
public interface QueryAproView extends BaseView<QueryAproPresentrer> {
    void showlist(List<QueryAproResponse.PayloadBean.ResultsBean> list);

    void showprogs(String mesg);

    void displayprogs();
}
