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

    private static String baseURL = "http://218.17.43.228:28080/";
    private static ZKTecoRequest zkTecoRequest;

    public static ZKTecoRequest getInstance() {
        if (zkTecoRequest == null) {
            zkTecoRequest = new ZKTecoRequest();
        }
        return zkTecoRequest;
    }

    public static ZKTecoApi getAPI() {
        return new Retrofit.Builder().
                baseUrl(baseURL).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(ZKTecoApi.class);
    }

}
