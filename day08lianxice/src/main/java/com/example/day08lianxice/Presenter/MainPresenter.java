package com.example.day08lianxice.Presenter;

import com.example.day08lianxice.Bean.BeanData;
import com.example.day08lianxice.Bean.BeanPresenter;
import com.example.day08lianxice.CallBack;
import com.example.day08lianxice.Molde.MainMolde;
import com.example.day08lianxice.View.MainView;

import java.util.List;

public class MainPresenter extends BeanPresenter<MainView> implements CallBack {
    private MainMolde mainMolde;
    @Override
    protected void initMolde() {
         mainMolde=new MainMolde();
         addMolde(mainMolde);
    }

    @Override
    public void Send(List<BeanData.BodyBean.ResultBean> beans) {
          Mview.send(beans);
    }

    @Override
    public void Onfile(String str) {
           Mview.ShouToast(str);
    }

    public void setData() {
        mainMolde.getData(this);
    }
}
