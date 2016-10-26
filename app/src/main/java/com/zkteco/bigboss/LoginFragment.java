/*
package com.zkteco.zkteco;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import MainActivity;
import BaseFragment;
import FindPasswordFragment;
import RegisFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


*/
/**
 * A simple {@link Fragment} subclass.
 *//*

public class LoginFragment extends BaseFragment {
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.account)
    View account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.register)
    TextView register;

    @OnClick(R.id.login)
    void onclick() {
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @OnClick(R.id.forget_password)
    void onclick_forgetpassword() {
        replaceFragment(new FindPasswordFragment());
    }


    @OnClick(R.id.register)
    void onclick_register() {
        replaceFragment(new RegisFragment());
    }

    private Unbinder mUnbinder;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }



}
*/
