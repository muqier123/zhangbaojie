package com.example.muqier.qia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muqier.qia.R;
import com.example.muqier.qia.bean.BeanList;

import java.util.ArrayList;

public class Adapetrlist extends RecyclerView.Adapter<Adapetrlist.ViewHloder> {
    private ArrayList<BeanList.DataBean.DatasBean>list;
    private Context context;

    public Adapetrlist(ArrayList<BeanList.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanList.DataBean.DatasBean> list) {
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
        final BeanList.DataBean.DatasBean bean=list.get(position);
        holder.tv1.setText(list.get(position).getChapterName());
        holder.tv2.setText(list.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick!=null){
                    onClick.onclick(position,bean);

                }
            }
        });

}

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;

        public ViewHloder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);

        }
    }
    public interface onClick{
        void onclick (int position, BeanList.DataBean.DatasBean bean);

    }
    private onClick onClick;

    public void setOnClick(Adapetrlist.onClick onClick) {
        this.onClick = onClick;
    }
}
