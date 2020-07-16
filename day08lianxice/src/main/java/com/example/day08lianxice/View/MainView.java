package com.example.day08lianxice.View;

import com.example.day08lianxice.Bean.BeanData;
import com.example.day08lianxice.Bean.BeanView;

import java.util.List;

public interface MainView extends BeanView {
    void send(List<BeanData.BodyBean.ResultBean> beans);
}
