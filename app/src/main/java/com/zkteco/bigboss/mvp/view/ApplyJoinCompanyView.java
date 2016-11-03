package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.bean.json.SearchCompanyResponse;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.ApplyJoinCompanyPresenter;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public interface ApplyJoinCompanyView extends BaseView<ApplyJoinCompanyPresenter> {
    void displayList();

    void showList(SearchCompanyResponse respose);
}
