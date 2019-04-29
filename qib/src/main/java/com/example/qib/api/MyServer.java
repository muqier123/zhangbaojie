package com.example.qib.api;

import com.example.qib.bean.BeanTui;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String Tui="https://www.apiopen.top/";
    @GET("novelInfoApi?name=盗墓笔记")
    Observable<BeanTui> getData1();
}
