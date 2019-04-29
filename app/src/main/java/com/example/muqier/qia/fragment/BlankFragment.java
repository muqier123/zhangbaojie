package com.example.muqier.qia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muqier.qia.R;
import com.example.muqier.qia.adapter.NewAdapter;
import com.example.muqier.qia.bean.BeanNew;
import com.example.muqier.qia.bean.BeanTui;
import com.example.muqier.qia.mainview.MainView;
import com.example.muqier.qia.model.Mainmodelmpl;
import com.example.muqier.qia.persenter.Mainpersenter;
import com.example.muqier.qia.persenter.Mainpersentermpl;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment implements MainView {


    private View inflate;
    private View view;
    private RecyclerView mRll;
    private ArrayList<BeanNew.DataBean.DatasBean>list;
    private NewAdapter newAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        initData();
        return inflate;


    }

    private void initData() {
        Mainpersenter mainpersenter=new Mainpersentermpl(new Mainmodelmpl(),this);
        mainpersenter.getData();
    }

    private void initView(View inflate) {
        list =  new ArrayList<>();
        mRll = (RecyclerView) inflate.findViewById(R.id.rll);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRll.setLayoutManager(linearLayoutManager);
        newAdapter = new NewAdapter(list, getActivity());
        mRll.setAdapter(newAdapter);

    }

    @Override
    public void onSuccess(BeanNew beanNew) {
        List<BeanNew.DataBean.DatasBean> datas = beanNew.getData().getDatas();
        list.addAll(datas);
        newAdapter.setList(list);
        newAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeil(String str) {

    }

    @Override
    public void onSuccesss(BeanTui beanTui) {

    }

    @Override
    public void onFeill(String str) {

    }
}
