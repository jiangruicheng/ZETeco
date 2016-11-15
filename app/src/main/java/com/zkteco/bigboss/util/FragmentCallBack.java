package com.zkteco.bigboss.util;

import com.zkteco.bigboss.mvp.BasePresenter;
import com.zkteco.bigboss.ui.fragment.BasemainFragment;

/**
 * Created by jiang_ruicheng on 16/10/21.
 */
public interface FragmentCallBack {
    /*int GOTO_ApplyFragment = 0;
    int GOTO_ApplyLeaveFragment = 1;
    int GOTO_LeaveListFragment = 2;
    int GOTO_LeaveMesgFragment = 3;
    int GOTO_CheckOnWorkFragment = 4;
    int GOTO_SignCardFragment = 5;
    int BACK = 6;
    int GOTO_ApprovalFragment = 7;
    int GOTO_ApprovalMesgFragment = 8;
    int GOTO_ApprovalerListFragment = 9;*/

    public void GoTo(BasemainFragment fragment, BasePresenter presenter);

    public void Back(BasemainFragment fragment);

    public void SetVisable(boolean Visable);
}
