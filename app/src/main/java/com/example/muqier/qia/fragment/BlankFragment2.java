package com.example.muqier.qia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muqier.qia.R;
import com.example.muqier.qia.adapter.TuiAdapter;
import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;
import com.example.muqier.qia.mainview.MainView;
import com.example.muqier.qia.model.Mainmodelmpl;
import com.example.muqier.qia.persenter.Mainpersenter;
import com.example.muqier.qia.persenter.Mainpersentermpl;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment2 extends Fragment implements MainView {


    private View view;
    private RecyclerView mRl;
    private ArrayList<BeanTui.DataBeanX.DataBean>list;
    private TuiAdapter tuiAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    private void initData() {
        Mainpersenter mainpersenter=new Mainpersentermpl(new Mainmodelmpl(),this);
        mainpersenter.getData1();
    }

    private void initView(View inflate) {
        mRl = (RecyclerView) inflate.findViewById(R.id.rl);
        list=new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRl.setLayoutManager(manager);

        tuiAdapter = new TuiAdapter(list, getActivity());
        mRl.setAdapter(tuiAdapter);

    }

    @Override
    public void onSuccess(BeanNew beanNew) {

    }

    @Override
    public void onFeil(String str) {

    }

    @Override
    public void onSuccesss(BeanTui beanTui) {
        List<BeanTui.DataBeanX.DataBean> data = beanTui.getData().getData();
        list.addAll(data);
        tuiAdapter.setList(list);
        tuiAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeill(String str) {

    }
}
