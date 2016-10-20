package com.zkteco.zkteco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
