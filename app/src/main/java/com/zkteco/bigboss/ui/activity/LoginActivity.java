package com.zkteco.bigboss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.presenter.Impl.LoginPresenterImpl;
import com.zkteco.bigboss.ui.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        LoginFragment loginFragment = new LoginFragment();
        LoginPresenterImpl loginPresenter = new LoginPresenterImpl();
        loginPresenter.setview(loginFragment);
        loginFragment.setPresenter(loginPresenter);
        fragmentManager.beginTransaction().add(R.id.frame_fragment, loginFragment).commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }

    public interface Setbackcallback {
        void backcallback();
    }

    private Setbackcallback setbackcallback;

    public void setBack(Setbackcallback setbackcallback) {
        this.setbackcallback = setbackcallback;
    }

    public void dissetback() {
        this.setbackcallback = null;
    }

    @Override
    public void onBackPressed() {
        if (setbackcallback != null) {
            setbackcallback.backcallback();
        } else {
            super.onBackPressed();
        }
    }
}
