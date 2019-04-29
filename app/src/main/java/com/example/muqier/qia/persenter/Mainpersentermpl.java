package com.example.muqier.qia.persenter;

import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;
import com.example.muqier.qia.callback.CallBack;
import com.example.muqier.qia.mainview.MainView;
import com.example.muqier.qia.model.Mainmodel;

public class Mainpersentermpl implements Mainpersenter,CallBack {
    private Mainmodel mainmodel;
    private MainView mainView;

    public Mainpersentermpl(Mainmodel mainmodel, MainView mainView) {
        this.mainmodel = mainmodel;
        this.mainView = mainView;
    }

    @Override
    public void onSuccess(BeanNew beanNew) {
        mainView.onSuccess(beanNew);
    }

    @Override
    public void onFeil(String str) {
        mainView.onFeil(str);
    }

    @Override
    public void onSuccesss(BeanTui beanTui) {
        mainView.onSuccesss(beanTui);
    }

    @Override
    public void onFeill(String str) {
        mainView.onFeill(str);
    }

    @Override
    public void getData() {
        mainmodel.getData(this);
    }

    @Override
    public void getData1() {
        mainmodel.getData1(this);
    }
}
