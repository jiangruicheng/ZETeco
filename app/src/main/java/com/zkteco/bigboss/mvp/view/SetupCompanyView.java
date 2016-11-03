package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.SetupCompanyPresenter;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public interface SetupCompanyView extends BaseView<SetupCompanyPresenter> {
    void showindus(List<String> cmpIndusResponse);
}
