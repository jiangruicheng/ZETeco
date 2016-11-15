package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.presenter.RegisPresenter;
import com.zkteco.bigboss.mvp.view.RegisView;
import com.zkteco.bigboss.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisFragment extends BaseFragment implements RegisView {


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

    @OnClick(R.id.phonenumb)
    void clickphoenumb() {
        phonenumb.setFocusable(true);
    }

    @OnClick(R.id.getIDcode)
    void setGetIDcode() {
        if (phonenumb.getText() != null) {
            regisPresenter.sendsmscaptcha(phonenumb.getText().toString());
        }
    }

    @OnClick(R.id.back)
    void onback() {
        popbackFragment();
    }

    @OnClick(R.id.next)
    void onnext() {
        //replaceFragment();
        if (StringUtil.isMobile(phonenumb.getText().toString())) {
            regisPresenter.nextstep(phonenumb.getText().toString(), IDcode.getText().toString());
        } else {
            postmesg("请输入正确的手机号");
        }
    }

    public RegisFragment() {
        // Required empty public constructor
    }

    private Unbinder mUnbinder;
    private RegisPresenter regisPresenter;

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

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void replaceFragment() {
        replaceFragment(new RegisStingFragment(), null);
    }

    @Override
    public void backFragment() {
        popbackFragment();
    }

    @Override
    public void setPresenter(Object presenter) {
        regisPresenter = (RegisPresenter) presenter;
    }
}
