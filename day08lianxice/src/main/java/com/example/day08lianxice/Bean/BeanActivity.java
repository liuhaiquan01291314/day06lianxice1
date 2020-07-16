package com.example.day08lianxice.Bean;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day08lianxice.MainActivity;
import com.example.day08lianxice.R;

import butterknife.ButterKnife;

public abstract class BeanActivity<P extends BeanPresenter>extends AppCompatActivity implements BeanView {
    public P mPresent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(getLayout());
        ButterKnife.bind(this);
        initpresenter();
        if(mPresent!=null)
            mPresent.beanView(this);

        initView();//处理组件
        initData();//加载数据
        initListener();//设置一些监听

    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

    protected abstract void initpresenter();
}
