package com.hagk.dongni.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hagk.dongni.R;
import com.hagk.dongni.constant.Constants;

/**
 * 描述 : 登录界面
 * 作者 : geaosu
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView userIcon;
    private TextView errorPwd;
    private EditText phoneNum;
    private EditText pwd;
    private ImageView showPwd;
    private Button login;
    private TextView goRegister;
    private TextView forgetPwd;
    private RelativeLayout showPwdClick;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initListener();
        showPwd.setBackground(getResources().getDrawable(R.drawable.in_visible));
        login.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    protected void initView() {
        userIcon = (ImageView) findViewById(R.id.login_user_icon);
        errorPwd = (TextView) findViewById(R.id.tv_error_pwd);
        phoneNum = (EditText) findViewById(R.id.ed_phone_num);
        pwd = (EditText) findViewById(R.id.ed_pwd);
        showPwdClick = (RelativeLayout) findViewById(R.id.rl_show_pwd_click);
        showPwd = (ImageView) findViewById(R.id.im_show_pwd);
        login = (Button) findViewById(R.id.btn_login);
        goRegister = (TextView) findViewById(R.id.tv_go_register);
        forgetPwd = (TextView) findViewById(R.id.tv_go_forget_pwd);
    }

    @Override
    protected void initListener() {
        login.setOnClickListener(this);
        goRegister.setOnClickListener(this);
        forgetPwd.setOnClickListener(this);
        showPwdClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_show_pwd_click:
                choiceShowPwc();
                break;
            case R.id.btn_login:
                showToast("点了");
                break;
            case R.id.tv_go_register:
                showToast("点了");
                break;
            case R.id.tv_go_forget_pwd:
                showToast("点了");
                break;
        }
    }

    private void choiceShowPwc() {
        if (Constants.isShowPwd) {
            //将密码设置为不可见
            //将isShowPwd的值变为false
            Constants.isShowPwd = false;
            //showPwd.setBackgroundResource(R.drawable.in_visible);
            showPwd.setBackground(getResources().getDrawable(R.drawable.in_visible));
        } else {
            //将密码设置为可见

            //将isShowPwd的值变为true
            Constants.isShowPwd = true;
            //showPwd.setBackgroundResource(R.drawable.visible);
            showPwd.setBackground(getResources().getDrawable(R.drawable.visible));
        }
    }
}