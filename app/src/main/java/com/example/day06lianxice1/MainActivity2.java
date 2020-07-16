package com.example.day06lianxice1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar mTool;
    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.Tool);
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mTool.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mTool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
////                startActivity(intent);
                finish();
            }
        });
        mWeb = (WebView) findViewById(R.id.web);
        mWeb.loadUrl("https://www.baidu.com/");
        mWeb.setWebViewClient(new WebViewClient());
    }
}
