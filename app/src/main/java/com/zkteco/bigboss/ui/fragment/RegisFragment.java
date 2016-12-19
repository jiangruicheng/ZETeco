package com.zkteco.bigboss.ui.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.presenter.RegisPresenter;
import com.zkteco.bigboss.mvp.view.RegisView;
import com.zkteco.bigboss.util.StringUtil;
import com.zkteco.bigboss.view.MyDialog;

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
        if (StringUtil.isMobile(phonenumb.getText().toString())) {
            regisPresenter.sendsmscaptcha(phonenumb.getText().toString());
        } else {
            postmesg("请输入正确的手机号");
        }
    }

    @OnClick(R.id.back)
    void onback() {
        popbackFragment();
    }

    @OnClick(R.id.next)
    void onnext() {
        // replaceFragment();
        if (StringUtil.isMobile(phonenumb.getText().toString())) {
            regisPresenter.nextstep(phonenumb.getText().toString(), IDcode.getText().toString(), new RegisPresenter.NextDO() {
                @Override
                public void nextdothing() {
                    isbreak = true;
                }
            });
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
        isStop = false;
        return view;
    }

    private boolean isbreak;

    @Override
    public void onStart() {
        super.onStart();
        isbreak = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        isbreak = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        isStop = true;
    }

    @Override
    public void postmesg(String msg) {
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
    public void replaceFragment() {
        replaceFragment(new RegisStingFragment(), null);
    }

    @Override
    public void recount() {
        count();
    }

    @Override
    public void backFragment() {
        popbackFragment();
    }

    @Override
    public void setPresenter(Object presenter) {
        regisPresenter = (RegisPresenter) presenter;
    }

    private static String counttime;
    private boolean isStop;

    private void count() {
        new Thread() {
            @Override
            public void run() {
                getIDcode.setClickable(false);
                for (int i = 0; i < 60; i++) {
                    if (isStop) {
                        break;
                    }
                    if (!isbreak) {
                        Message message = handler.obtainMessage();
                        message.what = 0x01;
                        message.arg1 = i;
                        handler.sendMessage(message);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 59) {
                        if (!isbreak) {
                            Message messages = handler.obtainMessage();
                            messages.what = 0x02;
                            handler.sendMessage(messages);
                        }
                    }
                }
            }
        }.start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x01) {
                getIDcode.setText("重新获取" + "(" + (60 - msg.arg1) + ")");
            } else if (msg.what == 0x02) {
                getIDcode.setText("获取验证码");
                getIDcode.setClickable(true);
            }
        }
    };
}
