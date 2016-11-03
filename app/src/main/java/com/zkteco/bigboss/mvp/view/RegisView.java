package com.zkteco.bigboss.mvp.view;

import com.zkteco.bigboss.mvp.BaseView;

/**
 * Created by jiang_ruicheng on 16/10/29.
 */
public interface RegisView extends BaseView {
    void postmesg(String msg);

    void replaceFragment();

    void backFragment();
}
