package com.zkteco.bigboss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.ui.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_fragment, new LoginFragment()).commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
