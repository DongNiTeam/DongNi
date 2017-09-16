package com.hagk.dongni;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hagk.dongni.activity.BaseActivity;
import com.hagk.dongni.constant.Constants;

/**
 * 描述 : app主界面
 * 作者 : geaosu
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private Toast mToast;
    private int mType = Constants.home_layout_you;

    private ImageView leftMenu;
    private RelativeLayout rightDevice;

    private RelativeLayout emotionsInfo;
    private TextView heartRate;

    //心情指数
    private TextView moodIndex;
    private ImageView iceLeft;
    private ImageView iceRight;
    private ImageView temperture;

    private RelativeLayout questions;

    //底部的三个按钮
    private RelativeLayout trajectory;
    private RelativeLayout call;
    private RelativeLayout location;
    private Handler handler;
    private Dialog mDialog;


    @Override
    protected int getContentView() {
        return getHomelayout(mType); //默认加载布局优
    }

    /**
     * 加载不同布局
     *
     * @param type
     * @return
     */
    private int getHomelayout(int type) {
        if (type == 1) {
            mType = Constants.home_layout_cha;
            return R.layout.layout_home_cha;
        } else if (type == 2) {
            mType = Constants.home_layout_zhong;
            return R.layout.layout_home_zhong;
        } else if (type == 3) {
            mType = Constants.home_layout_liang;
            return R.layout.layout_home_liang;
        } else {
            mType = Constants.home_layout_you;
            return R.layout.layout_home_you;
        }
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initListener();
    }

    @Override
    protected void initView() {
        leftMenu = (ImageView) findViewById(R.id.im_left_menu);
        rightDevice = (RelativeLayout) findViewById(R.id.rl_right_device);
        emotionsInfo = (RelativeLayout) findViewById(R.id.rl_emotions_info);
        heartRate = (TextView) findViewById(R.id.tv_heart_rate);
        moodIndex = (TextView) findViewById(R.id.tv_mood_index);//心情指数
        iceLeft = (ImageView) findViewById(R.id.im_ice_left);
        iceRight = (ImageView) findViewById(R.id.im_ice_right);
        temperture = (ImageView) findViewById(R.id.im_temperture);//水平
        questions = (RelativeLayout) findViewById(R.id.rl_ask_questions);
        trajectory = (RelativeLayout) findViewById(R.id.rl_growth_trajectory);
        call = (RelativeLayout) findViewById(R.id.rl_call);
        location = (RelativeLayout) findViewById(R.id.rl_location);
    }

    @Override
    protected void initListener() {
        leftMenu.setOnClickListener(this);
        rightDevice.setOnClickListener(this);
        emotionsInfo.setOnClickListener(this);
        questions.setOnClickListener(this);
        trajectory.setOnClickListener(this);
        call.setOnClickListener(this);
        location.setOnClickListener(this);
    }

    /**
     * 主界面动画
     */
    private void initAnimation() {
    }

    @Override
    public void onClick(View v) {
        String msg = "菜单";
        switch (v.getId()) {
            case R.id.im_left_menu:
                showToast(msg);
                mType = Constants.home_layout_you;
                getHomelayout(mType);
                break;
            case R.id.rl_right_device:
                showToast(msg);
                break;
            case R.id.rl_emotions_info:
                showToast(msg);
                break;
            case R.id.rl_ask_questions:
                showToast(msg);
                break;
            case R.id.rl_growth_trajectory:
                showToast(msg);
                break;
            case R.id.rl_call:
                //显示对话框
                showToast("显示对话框");
                mDialog = new Dialog(HomeActivity.this, R.style.dialog_transparent);
                View view = View.inflate(HomeActivity.this, R.layout.layout_home_call_dialog, null);
                Button cancel = (Button) view.findViewById(R.id.btn_cancel);
                Button confirm = (Button) view.findViewById(R.id.btn_confirm);

                cancel.setOnClickListener(this);
                confirm.setOnClickListener(this);

                mDialog.setCancelable(false);
                mDialog.setContentView(view);
                mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss();
                            finish();
                        }
                        return false;
                    }
                });


                break;
            case R.id.rl_location:
                showToast(msg);
                break;
            case R.id.btn_cancel: //取消拨打电话
                showToast("取消拨打电话");
                mDialog.dismiss();
                break;
            case R.id.btn_confirm: //确认拨打电话
                showToast("确认拨打电话");
                mDialog.dismiss();
                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
