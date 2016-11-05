package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.QueryAttPresenter;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public interface QueryAttView extends BaseView<QueryAttPresenter> {
    void showtype0(String name,String value);
    void showtype1(String name,String value);
    void showtype3(String name,String value);

}
