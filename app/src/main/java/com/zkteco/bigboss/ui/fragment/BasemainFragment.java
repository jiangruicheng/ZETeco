package com.zkteco.bigboss.ui.fragment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
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

    private ProgressDialog progressDialog;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void showprog(String mesg) {
        progressDialog = new ProgressDialog(getActivity(), android.R.style.Theme_Material_Light_Dialog);
        if (mesg != null) {
            progressDialog.setMessage("loading");
            progressDialog.show();
        }
        progressDialog.show();
    }

    protected void displayprog() {
        progressDialog.dismiss();
    }
}
