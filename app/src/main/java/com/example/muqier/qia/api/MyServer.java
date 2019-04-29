package com.example.muqier.qia.api;

import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
 public String Url="http://www.wanandroid.com/project/list/";
@GET("1/json?cid=294")
 Observable<BeanNew>getData();


 public String Tui="https://www.apiopen.top/";
 @GET("novelInfoApi?name=盗墓笔记")
 Observable<BeanTui>getData1();







}
