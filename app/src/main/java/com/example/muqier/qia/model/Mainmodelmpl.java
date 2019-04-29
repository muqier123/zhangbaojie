package com.example.muqier.qia.model;

import com.example.muqier.qia.api.MyServer;
import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;
import com.example.muqier.qia.callback.CallBack;

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
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.Url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<BeanNew> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanNew>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanNew beanNew) {
                        if (beanNew!=null){
                            callBack.onSuccess(beanNew);

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
                            callBack.onSuccesss(beanTui);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                            callBack.onFeill(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
