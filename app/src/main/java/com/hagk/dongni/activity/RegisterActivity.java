package com.hagk.dongni.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hagk.dongni.R;
import com.hagk.dongni.utils.PhoneNumUtils;

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
                if (phone.isEmpty()) {
                    showToast("手机号码不能为空");
                    return;
                } else {
                    if (!checkIsPhoneNum()) {
                        return;
                    }
                }

                //网络请求
                showToast("获取验证码");
                break;
            case R.id.btn_register:
                //注册
                showToast("注册");
                String num = phontNum.getText().toString().trim();
                if(PhoneNumUtils.checkMobileNO(num)){
                    showToast("手机号码合法!!!");
                }else{
                    showToast("手机号码不合法, 请输入正确的手机号码...");
                }
                break;
        }
    }

    /**
     * 检测手机号码是否合法
     * true 合法
     * false 不合法
     */
    private boolean checkIsPhoneNum() {
        // TODO: 2017/9/14 0014 待写
        return false;
    }
}
