package com.hagk.dongni.constant;

import android.webkit.WebView;

/**
 * 描述 : 常量类
 * 作者 : geaosu
 */
public class Constants {

    /**
     * 网络访问url
     */
    public static final String BASE_URL = "http://115.28.242.3:90";
    //public static final String ALBUM_PATH = Environment.getExternalStorageDirectory() + "/location/";
    public static final String CONTACT_ACTION = "android.intent.action.CONTACT_BROADCAST";
    public static final String SURVEY_ACTION = "android.intent.action.SURVEY_BROADCAST";
    public static final String LOGIN_ACTION = "android.intent.action.LOGIN_BROADCAST";
    public static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";
    public static final String FRAGMENT_CONTENT = "fragment_content";
    public static final int LEFT_MENU_WIDTH = 200;
    public static final String TXT_EMPTY = "输入值不能为空";
    public static final String SUCCESS_STATUS = "success";
    public static final String ERROR_STATUS = "error";
    public static final String PHONE_NUMBER_FORMAT_ERROR = "手机号输入格式不正确";
    // public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    //http://115.28.242.3:90/user/login
    public static final String loginUrl = BASE_URL + "/user/login";


    /**
     * 主界面显示不同布局
     */

    public static int home_layout_you = 4;
    public static int home_layout_liang = 3;
    public static int home_layout_zhong = 2;
    public static int home_layout_cha = 1;
    /**
     * 网络访问地址url
     */
    public static String startUrl = "";
    public static String url = "";

    /**
     * 登录界面
     */
    public static boolean isShowPwd = false;


}
