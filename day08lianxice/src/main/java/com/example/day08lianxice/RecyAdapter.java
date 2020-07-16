package com.example.day08lianxice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day08lianxice.Bean.BeanData;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {
    private ArrayList<BeanData.BodyBean.ResultBean> beans;
    private Context context;

    public RecyAdapter(ArrayList<BeanData.BodyBean.ResultBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy, null);
        return new ViewHandles(inflate);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ViewHandles viewHandles= (ViewHandles) holder;
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(beans.get(position).getTeacherPic()).apply(options).into(viewHandles.img);
        viewHandles.zuo.setText(beans.get(position).getTeacherName());
        viewHandles.shi.setText(beans.get(position).getTitle());
        viewHandles.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A.Oncreate(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
    class ViewHandles extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView zuo;
        private TextView shi;
        public ViewHandles(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            zuo=itemView.findViewById(R.id.zuo);
            shi=itemView.findViewById(R.id.shi);
        }
    }
    private send A;

    public void setA(send a) {
        A = a;
    }

    public interface send{
        void Oncreate(int a);
    }
}
