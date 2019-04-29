package com.example.qib.persenter;

import com.example.qib.bean.BeanTui;
import com.example.qib.callback.CallBack;
import com.example.qib.mainview.MainView;
import com.example.qib.model.Mainmodel;

public class Mainpersentermpl implements Mainpersenter,CallBack {
    private Mainmodel mainmodel;
    private MainView mainView;

    public Mainpersentermpl(Mainmodel mainmodel, MainView mainView) {
        this.mainmodel = mainmodel;
        this.mainView = mainView;
    }

    @Override
    public void onSuccess(BeanTui beanTui) {
        mainView.onSuccess(beanTui);
    }

    @Override
    public void onFeil(String str) {
        mainView.onFeil(str);
    }

    @Override
    public void getData1() {
        mainmodel.getData1(this);
    }
}
