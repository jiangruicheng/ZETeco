package com.zkteco.zkteco;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zkteco.zkteco.Utill.FragmentCallBack;
import com.zkteco.zkteco.Utill.PopWindowManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignCardFragment extends Fragment {
    private FragmentCallBack callBack;

    public SignCardFragment() {
        // Required empty public constructor

    }

    private TextView types, selectTime;
    private Button button, selectapprovaler;
    private View back;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FragmentCallBack) {
            callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        callBack.SetVisable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signcard, container, false);
        back = view.findViewById(R.id.back);
        selectapprovaler = (Button) view.findViewById(R.id.select_approvaler);
        types = (TextView) view.findViewById(R.id.signcard_types);
        selectTime = (TextView) view.findViewById(R.id.signcard_start_time);
        button = (Button) view.findViewById(R.id.makesure);
        selectapprovaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new ApprovalerSelectFragment());
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Back(SignCardFragment.this);
            }
        });
        types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> item = new ArrayList<String>();
                item.add("上班签到");
                item.add("下班签退");
                PopWindowManager.popListWindow(getActivity(), button, item);
            }
        });
        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopWindowManager.poptimewindow(getActivity(), button);
            }
        });
        return view;
    }

}
