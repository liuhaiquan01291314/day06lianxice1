package com.example.day06lianxice1;

import com.example.day06lianxice1.Bean.BeanData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<BeanData> send();
}
