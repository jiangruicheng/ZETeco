package com.zkteco.zkteco;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zkteco.zkteco.Utill.FragmentCallBack;
import com.zkteco.zkteco.Utill.PopWindowManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyLeaveFragment extends Fragment implements View.OnClickListener {

    private FragmentCallBack callBack;

    public ApplyLeaveFragment() {
        // Required empty public constructor
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    private Button button;
    private View back, leavetypes, leavestarttime, leavefinishtime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_apply_leave, container, false);
        button = (Button) view.findViewById(R.id.makesure);
        back = view.findViewById(R.id.back);
        leavetypes = view.findViewById(R.id.leave_types);
        leavestarttime = view.findViewById(R.id.leave_start_time);
        leavefinishtime = view.findViewById(R.id.leave_finish_time);
        back.setOnClickListener(this);
        leavetypes.setOnClickListener(this);
        leavefinishtime.setOnClickListener(this);
        leavestarttime.setOnClickListener(this);

        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                callBack.callback(FragmentCallBack.BACK);
                break;
            case R.id.leave_types:
                /*popwindow();*/
                ArrayList<String> items = new ArrayList<>();
                items.add("事假");
                items.add("病假");
                items.add("婚假");
                items.add("产假");
                items.add("丧假");
                items.add("陪产假");
                PopWindowManager.popListWindow(getActivity(), button, items);
                break;
            case R.id.leave_start_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button);
                break;
            case R.id.leave_finish_time:
                /*poptimewindow();*/
                PopWindowManager.poptimewindow(getActivity(), button);
                break;
        }
    }

}
