package com.example.day06lianxice1.Modle;

import com.example.day06lianxice1.ApiService;
import com.example.day06lianxice1.Bean.BeanData;
import com.example.day06lianxice1.Bean.BeanMolde;
import com.example.day06lianxice1.CallBack;
import com.example.day06lianxice1.Presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMolde extends BeanMolde {

    public void getdata(CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = build.create(ApiService.class);
        Observable<BeanData> send = service.send();
        send.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanData beanData) {
                      callBack.Send(beanData.getT1348647909107());
                    }

                    @Override
                    public void onError(Throwable e) {
                   callBack.Onfile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
