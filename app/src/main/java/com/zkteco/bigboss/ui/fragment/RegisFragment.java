package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkteco.zkteco.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisFragment extends BaseFragment {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.next)
    TextView next;
    @BindView(R.id.phonenumb)
    EditText phonenumb;
    @BindView(R.id.IDcode)
    EditText IDcode;
    @BindView(R.id.getIDcode)
    TextView getIDcode;

    @OnClick(R.id.back)
    void onback() {
        popbackFragment();
    }

    @OnClick(R.id.next)
    void onnext() {
        replaceFragment(new RegisSuccesFragment());
    }

    public RegisFragment() {
        // Required empty public constructor
    }

    private Unbinder mUnbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regis, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
