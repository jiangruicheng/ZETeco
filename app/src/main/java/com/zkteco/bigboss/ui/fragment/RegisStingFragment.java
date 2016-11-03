package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisStingFragment extends BaseFragment {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.next)
    TextView next;
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.setpassword)
    EditText setpassword;
    @BindView(R.id.makesurepassword)
    EditText makesurepassword;

    @OnClick(R.id.user)
    void onclick() {
        user.setFocusable(true);
    }

    @OnClick(R.id.back)
    void onbackclick() {
        popbackFragment();
    }

    @OnClick(R.id.next)
    void onnextclick() {
        Log.i("user", "onnextclick: " + user.getText().toString());
        if (StringUtil.isEmptyIgnoreBlank(user.getText().toString())) {
            Toast.makeText(getActivity(), "昵称不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (setpassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            if (setpassword.getText().toString().equals(makesurepassword.getText().toString())) {
                UserMesg.getInstance().setUsername(user.getText().toString());
                UserMesg.getInstance().setPassword(setpassword.getText().toString());
                replaceFragment(new RegisSuccesFragment(), null);
            } else {
                Toast.makeText(getActivity(), "密码不一致", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public RegisStingFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regis_sting, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
