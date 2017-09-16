package com.hagk.dongni;

import android.app.Application;
import android.content.Context;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.URLConnectionNetworkExecutor;
import com.yanzhenjie.nohttp.cache.DiskCacheStore;

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

        //初始化NoHttp
        NoHttp.initialize(this, new NoHttp.Config()
                .setConnectTimeout(30 * 1000) // 全局连接超时时间，单位毫秒。
                .setReadTimeout(30 * 1000) // 全局服务器响应超时时间，单位毫秒。
                //.setCacheStore(new DiskCacheStore(this))//缓存到sd卡中;
                .setNetworkExecutor(new URLConnectionNetworkExecutor()) // 使用HttpURLConnection做网络层。
        );

        //配置NoHttp的调试模式
        Logger.setDebug(true); // 开启NoHttp调试模式。
        Logger.setTag("NoHttpSample"); // 设置NoHttp打印Log的TAG。



    }

    //获取application的context对象
    public static Context getApplication() {
        return application;
    }


}
