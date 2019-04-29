package com.example.muqier.qia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.muqier.qia.adapter.Adapetrlist;
import com.example.muqier.qia.bean.BeanList;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//牧其尔  1808D
public class MainActivity extends AppCompatActivity {

    /**
     * qia
     */
    private TextView mTv1;
    /**
     * qia
     */
    private TextView mTv2;
    private RecyclerView mRl;
    private ArrayList<BeanList.DataBean.DatasBean>list;
    private Adapetrlist adapetrlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mRl = (RecyclerView) findViewById(R.id.rl);
        list=new ArrayList<>();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRl.setLayoutManager(linearLayoutManager);

        adapetrlist = new Adapetrlist(list, this);
        mRl.setAdapter(adapetrlist);
        adapetrlist.setOnClick(new Adapetrlist.onClick() {
            @Override
            public void onclick(int position, BeanList.DataBean.DatasBean bean) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        OkHttpClient build = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .url("http://www.wanandroid.com/project/list/1/json?cid=294")
                .get()
                .build();
        Call call = build.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final BeanList beanList = gson.fromJson(string, BeanList.class);
                final List<BeanList.DataBean.DatasBean> datas = beanList.getData().getDatas();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.addAll(datas);
                        adapetrlist.setList(list);
                        adapetrlist.notifyDataSetChanged();
                    }
                });

            }
        });


    }
}
