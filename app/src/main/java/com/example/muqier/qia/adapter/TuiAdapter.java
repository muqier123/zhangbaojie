package com.example.muqier.qia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.muqier.qia.R;
import com.example.muqier.qia.bean.BeanTui;

import java.util.ArrayList;

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.ViewHloder> {
    private ArrayList<BeanTui.DataBeanX.DataBean>list;
    private Context context;

    public TuiAdapter(ArrayList<BeanTui.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanTui.DataBeanX.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item3, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder holder, int position) {
            holder.tv1.setText(list.get(position).getTitle());
            holder.tv2.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getCover()).apply(new RequestOptions().circleCrop()).into(holder.im1);
        Glide.with(context).load(list.get(position).getCover()).into(holder.im2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im1;
        private ImageView im2;
        private TextView tv1;
        private TextView tv2;

        public ViewHloder(View itemView) {
            super(itemView);
            im1=itemView.findViewById(R.id.im1_item3);
            im2=itemView.findViewById(R.id.im2_item3);
            tv1=itemView.findViewById(R.id.tv1_item3);
            tv2=itemView.findViewById(R.id.tv2_item3);
        }
    }
}
