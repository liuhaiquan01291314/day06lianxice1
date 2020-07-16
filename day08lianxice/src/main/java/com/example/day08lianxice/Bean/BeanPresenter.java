package com.example.day08lianxice.Bean;

import com.example.day08lianxice.Molde.MainMolde;

import java.util.ArrayList;

public abstract class BeanPresenter<V extends BeanView> {
    public V Mview;
    public  ArrayList<MainMolde> mainMoldes= new ArrayList<MainMolde>();
      public BeanPresenter(){
        initMolde();
    }
    public void addMolde(MainMolde molde){
          mainMoldes.add(molde);
    }
    protected abstract void initMolde();

    public void beanView(V mview) {
        this.Mview = mview;
    }
}
