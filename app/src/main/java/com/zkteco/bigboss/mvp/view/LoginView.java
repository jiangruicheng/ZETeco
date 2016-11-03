package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.LoginPresenter;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public interface LoginView extends BaseView<LoginPresenter> {
    void showprogs();

    void displayprogs();
}
