package com.example.shangchuan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * retrofit
     */
    private Button mBtn;
    /**
     * ok
     */
    private Button mBrn;
    private File file;
    private ImageView mIm;
    private TextView mTv;
    private File file1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBrn = (Button) findViewById(R.id.brn);
        mBrn.setOnClickListener(this);
        mIm = (ImageView) findViewById(R.id.im);
        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.brn:
               /* ok();*/
                break;
            case R.id.btn:
                retrofit();
                break;
        }
    }

    private void retrofit() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_CHECKIN_PROPERTIES) == PackageManager.PERMISSION_GRANTED) {
            Lodede();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_CHECKIN_PROPERTIES}, 1);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1&&grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Lodede();

        }    }

    private void Lodede() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                  Environment.getDownloadCacheDirectory();

            file1 = new File("/storage/sdcard0/alien.png");

                }
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.Url)
                .build();

        MyServer myServer = build.create(MyServer.class);
        Retrofit retrofit = new Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(MyServer.Url)
                        .build();
                MyServer server = retrofit.create(MyServer.class);

                MediaType parse = MediaType.parse("application/octet-stream");
                RequestBody requestBody = RequestBody.create(parse, "1808c");

                RequestBody body = RequestBody.create(MediaType.parse("image/png"), file);

                MultipartBody.Part formData = MultipartBody.Part.
                        createFormData("file", this.file.getName(), body);
        Observable<Lopulde> data = myServer.getData(requestBody, formData);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Lopulde>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Lopulde lopulde) {
                        if (lopulde!=null){
                            if (lopulde.getCode()==200){
                                mTv.setText(lopulde.getRes());
                                Glide.with(MainActivity.this).load(lopulde.getData().getUrl()).apply(new RequestOptions().circleCrop()).into(mIm);

                            }else {
                                mTv.setText(lopulde.getRes());

                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /*private void ok() {
       if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_CHECKIN_PROPERTIES) == PackageManager.PERMISSION_GRANTED) {
            uplode();


        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_CHECKIN_PROPERTIES}, 1);
       }


   }*/

  /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1&&grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
           uplode();
        }

    }

   private void uplode() {
       if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Environment.getDownloadCacheDirectory();

           file = new File("/storage/emulated/legacy/Pictures/alien.png");

        }
       OkHttpClient client = new OkHttpClient.Builder()
                .build();
        //设置文件以及文件上传类型操作
       RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
       //文件上传的请求体封装
       MultipartBody body = new MultipartBody.Builder()
               .setType(MultipartBody.FORM)
             .addFormDataPart("key", "H1808C")
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        Request request = new Request.Builder()
              .url("http://yun918.cn/study/public/file_upload.php")
               .post(body)
                .build();
       Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
           public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final Lopulde lopulde = gson.fromJson(string, Lopulde.class);
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       if (lopulde != null) {
                           if (lopulde.getCode() == 200) {
                                mTv.setText(lopulde.getRes());
                               Glide.with(MainActivity.this).load(lopulde.getData().getUrl()).apply(new RequestOptions().circleCrop()).into(mIm);

                            } else {
                                mTv.setText(lopulde.getRes());


                          }

                        }
                   }
                });


            }
    });
   } */
}
