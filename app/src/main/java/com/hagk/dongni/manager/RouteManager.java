package com.hagk.dongni.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hagk.dongni.HomeActivity;
import com.hagk.dongni.activity.EmotionInfoActivity;
import com.hagk.dongni.activity.LoginActivity;
import com.hagk.dongni.activity.RegisterActivity;

/**
 * 描述 : 管理activity的类
 * 作者 : geaosu
 */

public class RouteManager {
    private RouteManager() {
    }

    public static RouteManager getInstance() {
        return Holder.routeManager;
    }

    private static class Holder {
        public static RouteManager routeManager = new RouteManager();
    }


    private void startActivity(Context context, Class<?> cls) {
        startActivity(context, cls, -1, null, -1);
    }

    private void startActivity(Context context, Class<?> cls, int flags) {
        startActivity(context, cls, -1, null, flags);
    }

    private void startActivity(Context context, Class<?> cls, Bundle data) {
        startActivity(context, cls, -1, data, -1);
    }

    private void startActivity(Context context, Class<?> cls, int requestCode, Bundle data) {
        startActivity(context, cls, requestCode, data, -1);
    }

    private void startActivity(Context context, Class<?> cls, Bundle data, int flags) {
        startActivity(context, cls, -1, data, flags);
    }

    private void startActivity(Context context, Class<?> cls, int requestCode, Bundle data, int flags) {
        Intent intent = new Intent(context, cls);
        if (data != null) {
            intent.putExtras(data);
        }
        if (flags != -1) {
            intent.addFlags(flags);
        }
        if (context instanceof Activity) {
            if (requestCode == 0) {
                context.startActivity(intent);
            } else {
                ((Activity) context).startActivityForResult(intent, requestCode);
            }
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            context.startActivity(intent);
        }
    }

    /**
     * 去主界面
     *
     * @param act 当前所在activity
     */
    public void toMainActivity(Activity act) {
        this.startActivity(act, HomeActivity.class);
    }

    /**
     * 去主界面
     *
     * @param act 当前所在activity
     */
    public void toMainActivity(Activity act, String jsonStr) {
        Bundle bundle = new Bundle();
        bundle.putString("jsonStr", jsonStr);
        this.startActivity(act, HomeActivity.class, bundle);
    }


    /**
     * 去注册界面
     *
     * @param act 当前所在activity
     */
    public void toRegisterActivity(Activity act) {
        this.startActivity(act, RegisterActivity.class);
    }

    /**
     * 去登录界面
     *
     * @param act 当前所在activity
     */
    public void toLoginActivity(Activity act) {
        this.startActivity(act, LoginActivity.class);
    }


    /**
     * 去情绪详情界面
     * 作者：马阔
     *
     *   
     * @param act 当前所在activity
     */
    public void toEmotionInfoActivity(Activity act) {
        this.startActivity(act, EmotionInfoActivity.class);
    }


}
