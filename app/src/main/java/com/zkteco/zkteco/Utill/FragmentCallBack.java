package com.zkteco.zkteco.Utill;

import android.support.v4.app.Fragment;

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

    public void GoTo(Fragment fragment);

    public void Back(Fragment fragment);

    public void SetVisable(boolean Visable);
}
