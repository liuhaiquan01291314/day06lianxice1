package com.example.day06lianxice1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day06lianxice1.Bean.BeanActivity;
import com.example.day06lianxice1.Bean.BeanData;
import com.example.day06lianxice1.Presenter.MainPresenter;
import com.example.day06lianxice1.View.MainView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BeanActivity<MainPresenter> implements MainView {

    @BindView(R.id.lie)
    TextView mLie;
    @BindView(R.id.Recy)
    RecyclerView mRecy;
    @BindView(R.id.Tool)
    Toolbar mTool;
    private ArrayList<BeanData.T1348647909107Bean> lists;
    private RecyAdapter adapter;
    private SmartRefreshLayout mSmarl;
    int pas=1;

    @Override
    public void setData(List<BeanData.T1348647909107Bean> list) {
        lists.addAll(list);
     adapter.notifyDataSetChanged();
     mSmarl.finishLoadMore();
     mSmarl.finishRefresh();
    }

    @Override
    public void shouToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.setdata();
    }

    @Override
    protected void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        mRecy.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        lists = new ArrayList<>();
        adapter = new RecyAdapter(lists, this);
        adapter.setA(new RecyAdapter.A() {
            @Override
            public void orcreate(int send) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        mRecy.setAdapter(adapter);
        mSmarl = (SmartRefreshLayout) findViewById(R.id.Smarl);
        mSmarl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                 pas=1;
                 mPresenter.setdata();
                 lists.clear();
            }
        });
        mSmarl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                  pas++;
                  mPresenter.setdata();
            }
        });
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

}
