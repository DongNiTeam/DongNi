package com.hagk.dongni;

import android.app.Application;
import android.content.Context;

/**
 * 描述 : 全局application
 * 作者 : geaosu
 */

public class DnApplication extends Application {
    private static Context application;

    @Override
    public void onCreate() {
        application = getApplicationContext();
        super.onCreate();
    }

    //获取application的context对象
    public static Context getApplication() {
        return application;
    }


}
