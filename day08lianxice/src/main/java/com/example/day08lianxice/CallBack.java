package com.example.day08lianxice;


import com.example.day08lianxice.Bean.BeanData;

import java.util.List;

public interface CallBack {
    void Send(List<BeanData.BodyBean.ResultBean> beans);
    void Onfile(String str);
}
