package com.zkteco.bigboss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.CmpIndusResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StartActivity extends AppCompatActivity {
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
        getaddressjson();
        mhandler.sendEmptyMessageDelayed(0x00, 1000);
    }

    private void getaddressjson() {
        Gson gson = new Gson();
        InputStream inputStream = getResources().openRawResource(R.raw.response);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Reader reader = new BufferedReader(inputStreamReader);
        JsonReader jsonreader = new JsonReader(reader);
        CmpIndusResponse addresses = gson.fromJson(jsonreader, CmpIndusResponse.class);
        Log.i("json", "getaddressjson: " + addresses.getPayload().getResults().get(1).getName());
    }

}
