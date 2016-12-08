package com.zkteco.bigboss;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by jiang_ruicheng on 16/12/8.
 */
public class ZKTecoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "4730630e3a", true);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
