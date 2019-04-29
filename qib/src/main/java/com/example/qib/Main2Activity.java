package com.example.qib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qib.adpter.lisAdapter;
import com.example.qib.bean.BeanTui;
import com.example.qib.mainview.MainView;
import com.example.qib.model.Mainmodelmpl;
import com.example.qib.persenter.Mainpersenter;
import com.example.qib.persenter.Mainpersentermpl;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, MainView {

    /**
     * 《
     */
    private Button mBtn;
    private Toolbar mTb;
    private ImageView mIv;
    /**
     * 123
     */
    private TextView mTv1;
    /**
     * 456
     */
    private TextView mTv2;
    /**
     * 789
     */
    private TextView mTv3;
    /**
     * 159
     */
    private TextView mTv4;
    /**
     * 159
     */
    private TextView mTv5;
    private RecyclerView mRecy;
    private ArrayList<BeanTui.DataBeanX.DataBean>list;
    private com.example.qib.adpter.lisAdapter lisAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String na = intent.getStringExtra("tv1");
        String author = intent.getStringExtra("tv2");
        String tag = intent.getStringExtra("tv3");
        String first = intent.getStringExtra("tv4");
        String desc = intent.getStringExtra("tv5");
        String url = intent.getStringExtra("im1");

        initView();
        initData();
        mTv1.setText(na);
        mTv2.setText(author);
        mTv3.setText(tag);
        mTv4.setText(first);
        mTv5.setText(desc);
        Glide.with(this).load(url).into(mIv);


    }

    private void initData() {
        Mainpersenter mainpersenter=new Mainpersentermpl(new Mainmodelmpl(),this);
        mainpersenter.getData1();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mTb = (Toolbar) findViewById(R.id.tb);
        mIv = (ImageView) findViewById(R.id.iv);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mTv4 = (TextView) findViewById(R.id.tv4);
        mTv5 = (TextView) findViewById(R.id.tv5);
        mRecy = (RecyclerView) findViewById(R.id.recy);

        list=new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(manager);

        lisAdapter = new lisAdapter(list, this);
        mRecy.setAdapter(lisAdapter);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
              finish();
                break;
        }
    }


    @Override
    public void onSuccess(BeanTui beanTui) {
        List<BeanTui.DataBeanX.DataBean> data = beanTui.getData().getData();
        list.addAll(data);
        lisAdapter.setList(list);
        lisAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeil(String str) {

    }
}
