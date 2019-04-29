package com.example.qib.mainview;

import com.example.qib.bean.BeanTui;

public interface MainView {
    void onSuccess(BeanTui beanTui);
    void onFeil(String str);

}
