package com.hagk.dongni.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hagk.dongni.R;

/**
 * 描述 : activity的基类
 * 作者 : geaosu
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Dialog mDialog;
    private TextView tvLoading;
    private ImageView ivLoading;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EventBus.getDefault().register(this);
        setContentView(getContentView());
        init(savedInstanceState);

    }

    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }

    /**
     * 加载布局
     */
    @LayoutRes
    protected abstract int getContentView();

    /**
     * 初始化
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    protected void initTitle(String strContent) {
        this.initTitle(0, null, strContent, null, 0);
    }

    protected void initTitle(int resLeft, String strContent) {
        this.initTitle(resLeft, null, strContent, null, 0);
    }

    protected void initTitle(int resLeft, String strContent, String strRight) {
        this.initTitle(resLeft, null, strContent, strRight, 0);
    }

    protected void initTitle(int resLeft, String strContent, int resRight) {
        this.initTitle(resLeft, null, strContent, null, resRight);
    }

    protected void initTitle(int resLeft, String strContent, int resRight, String strRight) {
        this.initTitle(resLeft, null, strContent, strRight, resRight);
    }

    protected void initTitle(String strLeft, String strContent, String strRight) {
        this.initTitle(0, strLeft, strContent, strRight, 0);
    }

    /**
     * 初始化标题栏
     *
     * @param resLeft    左边的图片
     * @param strLeft    左边的文字
     * @param strContent 中间的文字
     * @param strRight   右边的文字
     * @param resRight   右边的图片
     */
    protected void initTitle(int resLeft, String strLeft, String strContent, String strRight, int resRight) {
        ImageView ivTitleLeft = (ImageView) findViewById(R.id.iv_title_left);
        ImageView ivTitleRight = (ImageView) findViewById(R.id.iv_title_right);
        TextView tvTitleLeft = (TextView) findViewById(R.id.tv_title_left);
        TextView tvTitleContent = (TextView) findViewById(R.id.tv_title_content);
        TextView tvTitleRight = (TextView) findViewById(R.id.tv_title_right);

        if (ivTitleLeft != null) {
            if (resLeft == 0) {
                ivTitleLeft.setVisibility(View.GONE);
            } else {
                ivTitleLeft.setVisibility(View.VISIBLE);
                ivTitleLeft.setImageResource(resLeft);
                ivTitleLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickTitleLeft(v);
                    }
                });
            }
        }

        if (ivTitleRight != null) {
            if (resRight == 0) {
                ivTitleRight.setVisibility(View.GONE);
            } else {
                ivTitleRight.setVisibility(View.VISIBLE);
                ivTitleRight.setImageResource(resRight);
                ivTitleRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickTitleRight(v);
                    }
                });
            }
        }

        if (tvTitleLeft != null) {
            if (strLeft == null) {
                tvTitleLeft.setVisibility(View.GONE);
            } else {
                tvTitleLeft.setVisibility(View.VISIBLE);
                tvTitleLeft.setText(strLeft);
                tvTitleLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickTitleLeft(v);
                    }
                });
            }
        }
        if (tvTitleContent != null) {
            if (strContent == null) {
                tvTitleContent.setVisibility(View.GONE);
            } else {
                tvTitleContent.setVisibility(View.VISIBLE);
                tvTitleContent.setText(strContent);
            }
        }
        if (tvTitleRight != null) {
            if (strRight == null) {
                tvTitleRight.setVisibility(View.GONE);
            } else {
                tvTitleRight.setVisibility(View.VISIBLE);
                tvTitleRight.setText(strRight);
                tvTitleRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickTitleRight(v);
                    }
                });
            }
        }
    }


    /**
     * 被迫下线
     */
    public void forcedOffLine() {
        finish();
        startActivity(new Intent(this, RegisterActivity.class));
    }

    /**
     * 左边按钮的点击事件
     */
    protected void onClickTitleLeft(View view) {
        finish();
    }

    /**
     * 右边的功能按钮的点击事件
     */
    protected void onClickTitleRight(View view) {
    }

    /**
     * 显示吐司
     */
    public void showToast(String msg) {
        cancelToast();
        if (toast == null) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.show();
    }

    /**
     * 取消吐司
     */
    public void cancelToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    /**
     * 显示加载动画
     *
     * @param msg
     */
    public void showLoading(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog == null || tvLoading == null || ivLoading == null) {
                    View view = LayoutInflater.from(BaseActivity.this).inflate(R.layout.layout_loading, null, false);
//                    tvLoading = (TextView) view.findViewById(R.id.tvContent);
//                    ivLoading = (ImageView) view.findViewById(R.id.ivLoading);
//                    mDialog = new Dialog(BaseActivity.this, R.style.dialog_transparent);
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
                }
                if (msg == null) {
                    tvLoading.setVisibility(View.GONE);
                } else {
                    tvLoading.setVisibility(View.VISIBLE);
                    tvLoading.setText(msg);
                }
                Animation animation = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setRepeatCount(-1);
                animation.setInterpolator(new LinearInterpolator());
                ivLoading.startAnimation(animation);
                if (!mDialog.isShowing()) {
                    mDialog.show();
                }
            }
        });
    }

    /**
     * 隐藏加载动画
     */
    public void cancelLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isShowing()) {
                    if (ivLoading != null) {
                        ivLoading.clearAnimation();
                    }
                    mDialog.dismiss();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Glide.with(this).resumeRequests();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Glide.with(this).pauseRequests();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelToast();
        cancelLoading();
    }
}