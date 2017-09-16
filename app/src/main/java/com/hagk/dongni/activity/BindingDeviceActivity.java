package com.hagk.dongni.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hagk.dongni.R;

/**
 * 描述 : 绑定设备界面
 * 作者 : geaosu
 */
public class BindingDeviceActivity extends BaseActivity implements View.OnClickListener {


    private TextView bind;
    private ImageView bindDeviceBg;
    private EditText inputImeiNum;
    private ImageView scanInput;
    private ImageView deleteImeiNum;
    private EditText inputChildName;
    private ImageView deleteChildName;
    private EditText inputDevicePhoneNum;
    private ImageView deleteDevicePhoneNum;

    @Override
    protected int getContentView() {
        return R.layout.activity_binding_device;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitle(R.drawable.back_bg, getString(R.string.tv_binding_device));
        initView();
        initListener();
    }

    @Override
    protected void initView() {
        bind = (TextView) findViewById(R.id.tv_bind);
        bindDeviceBg = (ImageView) findViewById(R.id.bind_device_bg);

        inputImeiNum = (EditText) findViewById(R.id.input_device_imei_num);
        scanInput = (ImageView) findViewById(R.id.scan_input);
        deleteImeiNum = (ImageView) findViewById(R.id.delete_device_imei_num);

        inputChildName = (EditText) findViewById(R.id.input_child_name);
        deleteChildName = (ImageView) findViewById(R.id.delete_child_name);

        inputDevicePhoneNum = (EditText) findViewById(R.id.input_device_phone_num);
        deleteDevicePhoneNum = (ImageView) findViewById(R.id.delete_device_phone_input);

    }

    @Override
    protected void initListener() {

        bind.setOnClickListener(this);
        scanInput.setOnClickListener(this);
        deleteImeiNum.setOnClickListener(this);
        deleteChildName.setOnClickListener(this);
        deleteDevicePhoneNum.setOnClickListener(this);


        //输入框的状态监听
        // TODO: 2017/9/14 0014 待写
        //inputImeiNum.
        //inputImeiNum
        //inputDevicePhoneNum

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_bind:
                showToast("点了");
                break;
            case R.id.scan_input:
                showToast("点了");
                break;
            case R.id.delete_device_imei_num:
                showToast("点了");
                break;
            case R.id.delete_child_name:
                showToast("点了");
                break;
            case R.id.delete_device_phone_input:
                showToast("点了");
                break;
        }
    }
}
