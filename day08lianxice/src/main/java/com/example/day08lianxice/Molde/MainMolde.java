package com.example.day08lianxice.Molde;

import com.example.day08lianxice.ApiService;
import com.example.day08lianxice.Bean.BeanData;
import com.example.day08lianxice.CallBack;
import com.example.day08lianxice.Presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMolde {
    public void getData(CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<BeanData> data = apiService.data();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanData beanData) {
                      callBack.Send(beanData.getBody().getResult());
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
