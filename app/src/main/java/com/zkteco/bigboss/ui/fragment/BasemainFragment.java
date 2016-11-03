package com.zkteco.bigboss.ui.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class BasemainFragment extends Fragment {
    boolean isshownavg = true;

    public void setIsshownavg(boolean isshownavg) {
        this.isshownavg = isshownavg;
    }

    public boolean isIsshownavg() {
        return isshownavg;
    }
}
