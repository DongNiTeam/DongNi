package com.hagk.dongni.utils;

import android.util.Log;

/**
 * 描述 : 日志工具类
 * 作者 : geaosu
 */

public class LogUtils {
    //日志的开关，当项目上线是，关掉日志的开关
    public static boolean DEBUG = true;

    public static void i(String TAG, String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }
}
