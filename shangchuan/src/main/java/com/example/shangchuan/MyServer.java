package com.example.shangchuan;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MyServer {
    public String Url="http://yun918.cn/study/public/";
    @POST("file_upload.php")
    @Multipart
   /* Observable<Lopulde>getData(@Part("key") RequestBody body, @Part MultipartBody.Part file);*/
    Observable<Lopulde>getData(@Part("key")RequestBody body, @Part MultipartBody.Part file);

}
