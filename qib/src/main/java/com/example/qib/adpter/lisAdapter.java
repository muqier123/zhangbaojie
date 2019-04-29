package com.example.qib.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qib.R;
import com.example.qib.bean.BeanTui;

import java.util.ArrayList;

public class lisAdapter extends RecyclerView.Adapter<lisAdapter.ViewHloder> {
    private ArrayList<BeanTui.DataBeanX.DataBean>list;
    private Context context;

    public lisAdapter(ArrayList<BeanTui.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanTui.DataBeanX.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item2, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder holder, int position) {
        holder.tv1.setText(list.get(position).getTitle());
        holder.tv2.setText(list.get(position).getTags());
        holder.tv3.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getCover()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public ViewHloder(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.iiv);
            tv1=itemView.findViewById(R.id.tvv1);
            tv2=itemView.findViewById(R.id.tvv2);
            tv3=itemView.findViewById(R.id.tvv3);
        }
    }
}
