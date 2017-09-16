package com.hagk.dongni.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述 : 判断手机号码是否合法
 * 作者 : geaosu
 */

public class PhoneNumUtils {
    /**
     * 检测手机号码是否合法
     * true 合法
     * false 不合法
     */
    public static boolean checkMobileNO(String value) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(14[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
