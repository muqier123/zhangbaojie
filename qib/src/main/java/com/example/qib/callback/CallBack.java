package com.example.qib.callback;

import com.example.qib.bean.BeanTui;

public interface CallBack {
    void onSuccess(BeanTui beanTui);
    void onFeil(String str);
}
