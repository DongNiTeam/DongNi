package com.hagk.dongni.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.hagk.dongni.R;
import com.hagk.dongni.constant.Constants;
import com.hagk.dongni.utils.LogUtils;
import com.hagk.dongni.utils.PhoneNumUtils;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.JsonObjectRequest;
import com.yanzhenjie.nohttp.rest.Request;

import org.json.JSONObject;

import java.util.HashMap;

import javax.xml.transform.sax.TransformerHandler;

/**
 * 描述 : 账号注册界面
 * 作者 : geaosu
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView icon;
    private EditText phontNum;
    private EditText sms;
    private TextView getSms;
    private EditText pwd;
    private TextView register;
    private EditText rePwd;
    private int count = Constants.WAIT_TIME;
    private boolean isSent = false;

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitle(R.drawable.back_bg, getString(R.string.tv_login));
        initView();
        initListener();
    }

    @Override
    protected void initView() {
        icon = (ImageView) findViewById(R.id.user_icon);
        phontNum = (EditText) findViewById(R.id.phone_num);
        sms = (EditText) findViewById(R.id.input_sms);
        getSms = (TextView) findViewById(R.id.get_sms);
        pwd = (EditText) findViewById(R.id.pwd);
        rePwd = (EditText) findViewById(R.id.re_pwd);
        register = (TextView) findViewById(R.id.btn_register);
    }

    @Override
    protected void initListener() {
        getSms.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_sms:
                //获取验证码
                String phone = phontNum.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    LogUtils.i(Constants.TAG_REGISTERACTIVITY, "手机号码为空");
                    showToast("手机号码不能为空");
                } else {
                    if (PhoneNumUtils.checkMobileNO(phone)) {
                        LogUtils.i(Constants.TAG_REGISTERACTIVITY, "手机号码合法");
                        //判断短信是否发送
                        if (isSent) {
                            showToast("短信已发送, 请在等待时间结束后重新获取");
                            LogUtils.i(Constants.TAG_REGISTERACTIVITY, "短信已发送");
                        } else {
                            LogUtils.i(Constants.TAG_REGISTERACTIVITY, "手机号码正常, 准备发送短信");
                            /**
                             * 请求网络发送短信
                             * 根据服务器返回的结果判断短信是否发送成功
                             * http://115.28.242.3:90/api/user/sendCode?telephone=17629003561
                             * http://115.28.242.3:91/api/user/sendCode?telephone=17629003561
                             * http://115.28.242.3:90/api/user/sendCode?telephone=17629003561&name=hehe
                             */

                            HashMap<String,String> map = new HashMap();
                            map.put("telephone", phone);
                            String url = Constants.GET_SMS_URL;
                            Logger.i(url);
                            Request<JSONObject> request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
//                            Logger.i("短信验证码的返回数据的toString"+request.toString());
//                            Logger.i("短信验证码的返回数据的元数据"+request);
                            LogUtils.e(Constants.TAG_REGISTERACTIVITY,"短信验证码的返回数据的元数据 = "+request);

                            isSent = true;
                            //将背景图片变为灰色
                            getSms.setBackground(getResources().getDrawable(R.drawable.register_wait_time));
                            waitForSendSmsAgain();
                        }

                    } else {
                        showToast("请输入合法的手机号码");
                        LogUtils.i(Constants.TAG_REGISTERACTIVITY, "手机号码不合法");
                    }
                }
                break;
            case R.id.btn_register:
                //注册按钮
                break;
        }
    }

    /**
     * 等待再次发送短信
     */
    private void waitForSendSmsAgain() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1000);
                    count--;
                    if (count <= 1) {
                        Message msg = handler.obtainMessage();
                        msg.obj = Constants.TIME_OVER;
                        handler.sendMessage(msg);

                        return;
                    } else {
                        isSent = false;
                        Message msg = handler.obtainMessage();
                        msg.obj = Constants.CHANGE_TXT;
                        handler.sendMessage(msg);
                        waitForSendSmsAgain();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj == Constants.CHANGE_TXT) {
                String btnStartText = "获取验证码(";
                String btnEndText = ")";
                String txt = btnStartText + count + btnEndText;
                getSms.setText(txt);
                LogUtils.e(Constants.TAG_REGISTERACTIVITY, txt);
            } else if (msg.obj == Constants.TIME_OVER) {
                //恢复到以前
                isSent = false;
                getSms.setBackground(getResources().getDrawable(R.drawable.btn_sms_code));
                getSms.setText(getResources().getString(R.string.tv_get_sms));
                LogUtils.e(Constants.TAG_REGISTERACTIVITY, "等待时间到了, 可以重新发送消息了...");
            }


        }
    };


}
