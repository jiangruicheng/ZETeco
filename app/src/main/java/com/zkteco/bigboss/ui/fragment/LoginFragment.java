package com.zkteco.bigboss.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.presenter.Impl.RegisPresentImpl;
import com.zkteco.bigboss.mvp.presenter.LoginPresenter;
import com.zkteco.bigboss.mvp.view.LoginView;
import com.zkteco.bigboss.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

/**
 * Created by jiang_ruicheng on 16/10/26.
 */

public class LoginFragment extends BaseFragment implements LoginView {
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.account)
    EditText account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.register)
    TextView register;

    @OnTextChanged(R.id.account)
    void ontextchanged() {

    }

    @OnClick(R.id.login)
    void onclick() {
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));

        // presenter.login(getActivity(), account.getText().toString(), password.getText().toString());

    }

    @OnClick(R.id.forget_password)
    void onclick_forgetpassword() {
        replaceFragment(new FindPasswordFragment(), null);
    }


    @OnClick(R.id.register)
    void onclick_register() {
        replaceFragment(new RegisFragment(), new RegisPresentImpl());
    }

    private Unbinder mUnbinder;
    private LoginPresenter presenter;

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


    @Override
    public void showprogs() {

    }

    @Override
    public void postmesg(String msg) {

    }

    @Override
    public void displayprogs() {

    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }
}

