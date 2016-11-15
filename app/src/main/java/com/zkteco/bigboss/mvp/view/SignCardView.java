package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.SignCardPresenter;

import java.util.ArrayList;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public interface SignCardView extends BaseView<SignCardPresenter> {
    void showlist(ArrayList list);
}
