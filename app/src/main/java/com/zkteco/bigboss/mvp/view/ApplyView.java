package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.ApplysPresenter;

import java.util.ArrayList;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public interface ApplyView extends BaseView<ApplysPresenter> {
    void showList(ArrayList arrayList);


}
