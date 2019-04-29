package com.example.qib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qib.adpter.TuiAdapter;
import com.example.qib.bean.BeanTui;
import com.example.qib.mainview.MainView;
import com.example.qib.model.Mainmodelmpl;
import com.example.qib.persenter.Mainpersenter;
import com.example.qib.persenter.Mainpersentermpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    //牧其尔  1808D
    private RecyclerView mRl;
    private ArrayList<BeanTui.DataBeanX.DataBean>list;
    private TuiAdapter tuiAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Mainpersenter mainpersenter=new Mainpersentermpl(new Mainmodelmpl(),this);
        mainpersenter.getData1();
    }

    private void initView() {
        mRl = (RecyclerView) findViewById(R.id.rl);
        list=new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRl.setLayoutManager(linearLayoutManager);

        tuiAdapter = new TuiAdapter(list, this);
        mRl.setAdapter(tuiAdapter);
        tuiAdapter.setOnClick(new TuiAdapter.onClick() {
            @Override
            public void onClickl(int position, BeanTui.DataBeanX.DataBean bean) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("tv1",list.get(position).getAuthor());
                intent.putExtra("tv2",list.get(position).getDesc());
                intent.putExtra("tv3",list.get(position).getTags());
                intent.putExtra("tv4",list.get(position).getTitle());
                intent.putExtra("tv5",list.get(position).getDesc());
                intent.putExtra("im1",list.get(position).getCover());
                startActivity(intent);

            }
        });
    }

    @Override
    public void onSuccess(BeanTui beanTui) {
        List<BeanTui.DataBeanX.DataBean> data = beanTui.getData().getData();
        list.addAll(data);
        tuiAdapter.setList(list);
        tuiAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeil(String str) {

    }
}
