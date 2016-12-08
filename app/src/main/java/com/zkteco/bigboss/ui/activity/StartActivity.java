package com.zkteco.bigboss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zkteco.bigboss.R;

public class StartActivity extends BaseActivity {
    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x00) {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /*counAddresses = getaddressjson();
        showaddress();*/
        mhandler.sendEmptyMessageDelayed(0x00, 2000);
    }


}
