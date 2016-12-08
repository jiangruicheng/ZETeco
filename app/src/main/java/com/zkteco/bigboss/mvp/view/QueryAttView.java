package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.bean.json.QueryAttResponse;
import com.zkteco.bigboss.bean.json.bean.AttMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.QueryAttPresenter;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public interface QueryAttView extends BaseView<QueryAttPresenter> {
    void showlist(List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> list);

    void setmonthatt(AttMesg[] attMesgs);
}
