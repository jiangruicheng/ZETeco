package com.zkteco.zkteco;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.zkteco.zkteco.Utill.FragmentCallBack;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyFragment extends Fragment {

    public ApplyFragment() {
        // Required empty public constructor

    }

    private FragmentCallBack callBack;

/*
    @SuppressLint("ValidFragment")
    public ApplyFragment(Activity activity) {
        // Required empty public constructor
        if (activity instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) activity;
        }
    }
*/

    private ImageView back, signcard, leave;
    private Button myapply;

    @Override
    public void onResume() {
        super.onResume();
        callBack.SetVisable(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_apply, container, false);
        myapply = (Button) view.findViewById(R.id.myapply);
        back = (ImageView) view.findViewById(R.id.back);
        signcard = (ImageView) view.findViewById(R.id.signcard);
        leave = (ImageView) view.findViewById(R.id.leave);
        myapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new LeaveListFragment(false));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Back(ApplyFragment.this);
            }
        });
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.GoTo(new ApplyLeaveFragment());
                /*callBack.callback(FragmentCallBack.GOTO_ApplyLeaveFragment);*/
            }
        });
        signcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*callBack.callback(FragmentCallBack.GOTO_SignCardFragment);*/
                callBack.GoTo(new SignCardFragment());
            }
        });
        return view;
    }

}
