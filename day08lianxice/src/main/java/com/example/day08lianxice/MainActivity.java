package com.example.day08lianxice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08lianxice.Bean.BeanActivity;
import com.example.day08lianxice.Bean.BeanData;
import com.example.day08lianxice.Bean.BeanPresenter;
import com.example.day08lianxice.Bean.BeanView;
import com.example.day08lianxice.Presenter.MainPresenter;
import com.example.day08lianxice.View.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BeanActivity<MainPresenter> implements MainView {

    @BindView(R.id.meng)
    TextView mMeng;
    @BindView(R.id.Tool)
    Toolbar mTool;
    @BindView(R.id.Recy)
    RecyclerView mRecy;
    private ArrayList<BeanData.BodyBean.ResultBean> list;
    private RecyAdapter adapter;
    private String m="888888";


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
     mPresent.setData();
    }

    @Override
    protected void initView() {
        mTool.setTitle("");
        mTool.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(mTool);
      mRecy.setLayoutManager(new LinearLayoutManager(this));
      mRecy.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        adapter = new RecyAdapter(list, this);
        mRecy.setAdapter(adapter);
        adapter.setA(new RecyAdapter.send() {
            @Override
            public void Oncreate(int a) {
                int id = list.get(a).getID();
                String name = list.get(a).getTeacherName();
                String pic = list.get(a).getTeacherPic();
                String title = list.get(a).getTitle();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("title",title);
                intent.putExtra("pic",pic);
                 startActivity(intent);

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initpresenter() {
      mPresent=new MainPresenter();
    }

    @Override
    public void ShouToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void send(List<BeanData.BodyBean.ResultBean> beans) {
        list.addAll(beans);
        adapter.notifyDataSetChanged();
    }
}
