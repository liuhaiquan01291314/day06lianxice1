package com.example.day06lianxice1.Presenter;

import com.example.day06lianxice1.Bean.BeanData;
import com.example.day06lianxice1.Bean.BeanPresenter;
import com.example.day06lianxice1.CallBack;
import com.example.day06lianxice1.Modle.MainMolde;
import com.example.day06lianxice1.View.MainView;

import java.util.List;

public class MainPresenter extends BeanPresenter<MainView> implements CallBack {
    public MainMolde mainMolde;
    @Override
    protected void initModel() {
      mainMolde=new MainMolde();
      addModel(mainMolde);
    }

    @Override
    public void Send(List<BeanData.T1348647909107Bean> beans) {
          Mview.setData(beans);
    }

    @Override
    public void Onfile(String str) {
      Mview.shouToast(str);
    }

    public void setdata() {
      mainMolde.getdata(this);
    }
}
