package com.zkteco.bigboss.mvp.mode;

import com.zkteco.bigboss.mvp.api.ZKTecoApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jiang_ruicheng on 16/10/29.
 */
public class ZKTecoRequest {
    private ZKTecoRequest() {
    }

    private static String ATTURL = "http://218.17.43.228:28081/m/";
    private static String listURL = "http://218.17.43.228:28081/";
    private static String ACCOUNTURL = "http://218.17.43.228:28082/m/";

    /*private static ZKTecoRequest zkTecoRequest;

    public static ZKTecoRequest getInstance() {
        if (zkTecoRequest == null) {
            zkTecoRequest = new ZKTecoRequest();
        }
        return zkTecoRequest;
    }*/
    public static ZKTecoApi getAccountAPI() {
        return new Retrofit.Builder().
                baseUrl(ACCOUNTURL).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(ZKTecoApi.class);
    }

    public static ZKTecoApi getListApi() {
        return new Retrofit.Builder().
                baseUrl(listURL).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(ZKTecoApi.class);
    }

    public static ZKTecoApi getATTPAI() {
        return new Retrofit.Builder().
                baseUrl(ATTURL).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(ZKTecoApi.class);
    }


}
