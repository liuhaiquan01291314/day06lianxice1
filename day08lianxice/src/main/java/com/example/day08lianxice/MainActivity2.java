package com.example.day08lianxice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day08lianxice.Fragment.JieFragment;
import com.example.day08lianxice.Fragment.KeFragment;
import com.example.day08lianxice.Fragment.ZhuanFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    private ImageView mImg;
    private TextView mZuo;
    private TabLayout mTab;
    private FragmentManager manager;
    private JieFragment jieFragment;
    private KeFragment keFragment;
    private ZhuanFragment zhuanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mZuo = (TextView) findViewById(R.id.zuo);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String title = intent.getStringExtra("title");
        String pic = intent.getStringExtra("pic");
        int id = intent.getIntExtra("id", 0);
        mZuo.setText(name);
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(this).load(pic).apply(options).into(mImg);
        manager = getSupportFragmentManager();
        jieFragment = new JieFragment();
        keFragment = new KeFragment();
        zhuanFragment = new ZhuanFragment();
        mTab = (TabLayout) findViewById(R.id.tab);
        mTab.addTab(mTab.newTab().setText("介绍"));
        mTab.addTab(mTab.newTab().setText("课程"));
        mTab.addTab(mTab.newTab().setText("专题"));
        manager.beginTransaction().add(R.id.frame,jieFragment).add(R.id.frame,keFragment).add(R.id.frame,zhuanFragment).hide(keFragment).hide(zhuanFragment).commit();
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0:
                     manager.beginTransaction().show(jieFragment).hide(keFragment).hide(zhuanFragment).commit();
                     break;
                     case 1:
                         manager.beginTransaction().show(keFragment).hide(jieFragment).hide(zhuanFragment).commit();
                         break;
                     case 2:
                         manager.beginTransaction().show(zhuanFragment).hide(jieFragment).hide(keFragment).commit();
                 }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
