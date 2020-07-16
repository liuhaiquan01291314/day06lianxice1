package com.example.day06lianxice1.Bean;

import com.example.day06lianxice1.Modle.MainMolde;

import java.util.ArrayList;

public abstract class BeanPresenter<V extends BeanView> {
    public V Mview;
    public ArrayList<MainMolde> mModels = new ArrayList<MainMolde>();
    public BeanPresenter(){
        initModel();//处理model
    }

    public void addModel(MainMolde model){
        mModels.add(model);//收集model，便于管理
    }
    protected abstract void initModel();

    public void bindView(V view){//绑定view
        this.Mview = view;
    }

}
