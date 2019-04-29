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
import com.example.muqier.qia.bean.BeanNew;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BeanNew.DataBean.DatasBean>list;
    private Context context;

    public NewAdapter(ArrayList<BeanNew.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanNew.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        if (viewType==1){
            View one = LayoutInflater.from(context).inflate(R.layout.layout_item2, null);
            viewHolder=new ViewHloder1(one);
        }else if (viewType==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item2_2, null);
            viewHolder=new ViewHloder2(inflate);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==1){
            ViewHloder1 viewHloder1= (ViewHloder1) holder;
            viewHloder1.tv2.setText(list.get(position).getChapterName());
            viewHloder1.tv1.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getEnvelopePic()).apply(new RequestOptions().circleCrop()).into(viewHloder1.im);

        } else if (itemViewType==2){
            ViewHloder2 viewHloder2= (ViewHloder2) holder;
            viewHloder2.tv1.setText(list.get(position).getChapterName());
            viewHloder2.tv2.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getEnvelopePic()).apply(new RequestOptions().circleCrop()).into(viewHloder2.im1);
            Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHloder2.im2);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position%2==0){
            return 1;
        }
        return 2;
    }

    public class ViewHloder1 extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;

        public ViewHloder1(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_item2);
            tv1=itemView.findViewById(R.id.tv1_item2);
            tv2=itemView.findViewById(R.id.tv2_item2);

        }
    }
    public class ViewHloder2 extends RecyclerView.ViewHolder {
        private ImageView im1;
        private ImageView im2;
        private TextView tv1;
        private TextView tv2;

        public ViewHloder2(View itemView) {
            super(itemView);
            im1=itemView.findViewById(R.id.im1_item2_2);
            im2=itemView.findViewById(R.id.im2_item2_2);
            tv1=itemView.findViewById(R.id.tv1_item2_2);
            tv2=itemView.findViewById(R.id.tv2_item2_2);
        }
    }
}
