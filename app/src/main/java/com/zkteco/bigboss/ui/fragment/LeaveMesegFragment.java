package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.util.FragmentCallBack;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LeaveMesegFragment extends BasemainFragment {

    private boolean ButtonVisable;
    private FragmentCallBack callBack;

    public LeaveMesegFragment(boolean b) {
        // Required empty public constructor
        ButtonVisable = b;
        setIsshownavg(false);
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

        //callBack.SetVisable(false);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_meseg, container, false);
        View view1 = view.findViewById(R.id.bottom_button);
        if (ButtonVisable){
            view1.setVisibility(View.VISIBLE);
        }else {
            view1.setVisibility(View.GONE);
        }
        return view;
    }

}
