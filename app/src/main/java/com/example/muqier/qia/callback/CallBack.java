package com.example.muqier.qia.callback;

import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;

public interface CallBack {
    void onSuccess(BeanNew beanNew);
    void onFeil(String str);

    void onSuccesss(BeanTui beanTui);
    void onFeill(String str);

}
