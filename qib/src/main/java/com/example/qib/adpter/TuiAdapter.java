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
import com.bumptech.glide.request.RequestOptions;
import com.example.qib.R;
import com.example.qib.bean.BeanTui;

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
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item1, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder holder, final int position) {
        final BeanTui.DataBeanX.DataBean bean=list.get(position);
        holder.tv1.setText(list.get(position).getAuthor());
        holder.tv2.setText(list.get(position).getTitle());
        holder.tv3.setText(list.get(position).getCategory());
        holder.tv5.setText(list.get(position).getTags());
        holder.tv6.setText(list.get(position).getAuthor());
        holder.tv8.setText(list.get(position).getCategory());
        holder.tv9.setText(list.get(position).getTags());
        holder.tv11.setText(list.get(position).getTitle());
        holder.tv12.setText(list.get(position).getCategory());
        Glide.with(context).load(list.get(position).getCover()).apply(new RequestOptions().circleCrop()).into(holder.im1);
        Glide.with(context).load(list.get(position).getCover()).apply(new RequestOptions().circleCrop()).into(holder.im2);
        Glide.with(context).load(list.get(position).getCover()).apply(new RequestOptions().circleCrop()).into(holder.im3);
        Glide.with(context).load(list.get(position).getCover()).apply(new RequestOptions().circleCrop()).into(holder.im4);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick!=null){
                    onClick.onClickl(position,bean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im1;
        private ImageView im2;
        private ImageView im3;
        private ImageView im4;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private TextView tv5;
        private TextView tv6;
        private TextView tv8;
        private TextView tv9;
        private TextView tv11;
        private TextView tv12;

        public ViewHloder(View itemView) {
            super(itemView);
            im1=itemView.findViewById(R.id.im1_item1);
            im2=itemView.findViewById(R.id.im2_item1);
            im3=itemView.findViewById(R.id.im3_item1);
            im4=itemView.findViewById(R.id.im4_item1);
            tv1=itemView.findViewById(R.id.tv1_item1);
            tv2=itemView.findViewById(R.id.tv2_item1);
            tv3=itemView.findViewById(R.id.tv3_item1);
            tv5=itemView.findViewById(R.id.tv5_item1);
            tv6=itemView.findViewById(R.id.tv6_item1);
            tv8=itemView.findViewById(R.id.tv8_item1);
            tv9=itemView.findViewById(R.id.tv9_item1);
            tv11=itemView.findViewById(R.id.tv11_item1);
            tv12=itemView.findViewById(R.id.tv12_item1);



        }
    }
    public  interface onClick{
        void onClickl(int position,BeanTui.DataBeanX.DataBean bean);

    }
    private onClick onClick;

    public void setOnClick(TuiAdapter.onClick onClick) {
        this.onClick = onClick;
    }
}
