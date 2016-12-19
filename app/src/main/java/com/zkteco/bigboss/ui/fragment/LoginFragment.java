package com.zkteco.bigboss.ui.fragment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
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
import com.zkteco.bigboss.view.MyDialog;

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
        // showprogs();
        // getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        presenter.login(getActivity(), account.getText().toString(), password.getText().toString());
        /*PopWindowManager.poptimewindow(getActivity(), login, TimePicker.MINUTE_TYPE_FIVE ,new PopWindowManager.PopviewTimeCallback() {
            @Override
            public void setTime(long time, String week) {

            }
        });*/
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

    private ProgressDialog progressDialog;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void showprogs() {
        /*progressDialog = new ProgressDialog(getActivity(), android.R.style.Theme_Material_Light_Dialog);
        progressDialog.setMessage("正在登陆");
        progressDialog.show();*/
        super.showprog("");
    }

    @Override
    public void postmesg(String msg) {
        /*Toast.makeText(getActivity(), "" + msg, Toast.LENGTH_SHORT).show();*/
        MyDialog.Builder mydialog = new MyDialog.Builder(getActivity());
        mydialog.setMessage(msg);
        mydialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mydialog.create().show();
    }

    @Override
    public void displayprogs() {
        /*if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }*/
        super.displayprog();

    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }
}

