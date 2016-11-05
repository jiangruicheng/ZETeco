package com.zkteco.bigboss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.bean.CounAddress;
import com.zkteco.bigboss.view.com.bigkoo.pickerview.OptionsPickerView;
import com.zkteco.bigboss.view.com.bigkoo.pickerview.model.IPickerViewData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
        /*counAddresses = getaddressjson();
        showaddress();*/
        mhandler.sendEmptyMessageDelayed(0x00, 2000);
    }

    List<CounAddress> counAddresses;
    private ArrayList<IPickerViewData> item0 = new ArrayList<>();
    private ArrayList<ArrayList<IPickerViewData>> item1 = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<IPickerViewData>>> item2 = new ArrayList<>();
    static int pub;

    class ItemString implements IPickerViewData {
        public ItemString(String s) {
            name = s;
        }

        private String name;

        @Override
        public String getPickerViewText() {
            return name;
        }
    }

    private void showaddress() {
        Observable.just(getaddressjson()).map(new Func1<List<CounAddress>, Object>() {
            @Override
            public Object call(final List<CounAddress> counAddresses) {
                for (int i = 0; i < counAddresses.size(); i++) {
                    item0.add(new ItemString(counAddresses.get(i).getName()));
                    ArrayList<IPickerViewData> item1_i = new ArrayList<IPickerViewData>();
                    ArrayList<ArrayList<IPickerViewData>> item2_i = new ArrayList<ArrayList<IPickerViewData>>();
                    for (int j = 0; j < counAddresses.get(i).getSubArea().size(); j++) {
                        item1_i.add(new ItemString(counAddresses.get(i).getSubArea().get(j).getName()));
                        ArrayList<IPickerViewData> item2_i_i = new ArrayList<IPickerViewData>();

                        for (int k = 0; k < counAddresses.get(i).getSubArea().get(j).getSubArea().size(); k++) {
                            item2_i_i.add(new ItemString(counAddresses.get(i).getSubArea().get(j).getSubArea().get(k).getName()));
                        }
                        item2_i.add(item2_i_i);
                    }
                    item1.add(item1_i);
                    item2.add(item2_i);
                }
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                OptionsPickerView optionsPickerView = new OptionsPickerView(StartActivity.this);
                optionsPickerView.setPicker(item0, item1, item2, true);
                optionsPickerView.setCyclic(false, false, false);
                //optionsPickerView.setSelectOptions(3,3,3);
                Log.i("TAG", "onNext: " + item1.size());
                optionsPickerView.show();
            }
        });
    }

    private List<CounAddress> getaddressjson() {
        Gson gson = new Gson();
        InputStream inputStream = getResources().openRawResource(R.raw.address);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Reader reader = new BufferedReader(inputStreamReader);
        JsonReader jsonreader = new JsonReader(reader);
        List<CounAddress> addresses = gson.fromJson(jsonreader, new TypeToken<List<CounAddress>>() {
        }.getType());
        /*Log.i("json", "getaddressjson: " + addresses.get(1).getSubArea().get(0).getSubArea().get(0).getName());*/
        return addresses;
    }

}
