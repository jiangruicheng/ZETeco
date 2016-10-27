package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zkteco.bigboss.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisSuccesFragment extends BaseFragment {


    @BindView(R.id.setupcompany)
    Button setupcompany;
    @BindView(R.id.applyjoincompany)
    Button applayjoincompany;

    @OnClick(R.id.setupcompany)
    void onsetup() {
        replaceFragment(new SetupCompanyFragment());
    }

    @OnClick(R.id.applyjoincompany)
    void onapplayjoin() {
        replaceFragment(new ApplyJoinCompanyFragment());
    }

    public RegisSuccesFragment() {
        // Required empty public constructor
    }

    private Unbinder mUnbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regis_succes, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
