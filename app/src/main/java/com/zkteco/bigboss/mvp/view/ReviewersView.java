package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.bean.json.QueryReviewersResponse;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.QueryReviewersPresenter;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public interface ReviewersView extends BaseView<QueryReviewersPresenter> {
    void showList(List<QueryReviewersResponse.PayloadBean.ResultsBean> resultsBeen);
}
