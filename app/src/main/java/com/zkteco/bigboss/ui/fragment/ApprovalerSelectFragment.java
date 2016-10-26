package com.zkteco.bigboss.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zkteco.bigboss.Utill.FragmentCallBack;
import com.zkteco.zkteco.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApprovalerSelectFragment extends Fragment {


    private FragmentCallBack callBack;

    public ApprovalerSelectFragment() {
        // Required empty public constructor
    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        callBack.SetVisable(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_approvaler_select, container, false);
    }

}
