package com.hagk.dongni.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hagk.dongni.R;

/**
 * 描述 : 成长界面
 * 作者 : geaosu
 */
public class GrowUpActivity extends BaseActivity implements View.OnClickListener {

    private ViewPager group;
    private TextView emotionsInfo;
    private RecyclerView question;

    @Override
    protected int getContentView() {
        return R.layout.activity_grow_up;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitle(R.drawable.back_bg, getString(R.string.tv_group_up));
        initView();
        initListener();
    }

    @Override
    protected void initView() {
        group = (ViewPager) findViewById(R.id.vp_group);
        emotionsInfo = (TextView) findViewById(R.id.tv_emotions_info);
        question = (RecyclerView) findViewById(R.id.rv_question);
    }

    @Override
    protected void initListener() {
        emotionsInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
