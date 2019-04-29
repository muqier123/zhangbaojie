package com.example.qib.model;

import com.example.qib.api.MyServer;
import com.example.qib.bean.BeanTui;
import com.example.qib.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mainmodelmpl implements Mainmodel{
    @Override
    public void getData1(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.Tui)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<BeanTui> data1 = myServer.getData1();
        data1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanTui>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanTui beanTui) {
                    if (beanTui!=null){
                        callBack.onSuccess(beanTui);

                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFeil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
