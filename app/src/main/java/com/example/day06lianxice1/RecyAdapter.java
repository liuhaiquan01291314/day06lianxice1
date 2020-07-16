package com.example.day06lianxice1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day06lianxice1.Bean.BeanData;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {
    private ArrayList<BeanData.T1348647909107Bean> list;
    private Context context;

    public RecyAdapter(ArrayList<BeanData.T1348647909107Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy1, null);
            return new ViewHandle1(inflate);
        }
        View inflate1 = LayoutInflater.from(context).inflate(R.layout.layout_recy2, null);
        return new ViewHandle2(inflate1);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,  int position) {
        int type = getItemViewType(position);
        if (type==1){
                ViewHandle1 viewHandle1= (ViewHandle1) holder;
                viewHandle1.zuo.setText(list.get(position).getSource());
                viewHandle1.shi.setText(list.get(position).getPtime());
                viewHandle1.biao.setText(list.get(position).getTitle());
       viewHandle1.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                a.orcreate(position);
           }
       });
             }
             if (type==2){
               ViewHandle2 viewHandle2= (ViewHandle2) holder;
                 viewHandle2.zuo1.setText(list.get(position).getSource());
                 viewHandle2.shi1.setText(list.get(position).getPtime());
                 viewHandle2.biao1.setText(list.get(position).getTitle());
                 Glide.with(context).load(list.get(position).getImgsrc()).into(viewHandle2.img);
             }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  ViewHandle1 extends RecyclerView.ViewHolder{
        private TextView zuo;
        private TextView shi;
        private TextView biao;
        public ViewHandle1(@NonNull View itemView) {
            super(itemView);
            zuo=itemView.findViewById(R.id.zuo);
            shi=itemView.findViewById(R.id.shi);
            biao=itemView.findViewById(R.id.biao);
        }
    }
    class  ViewHandle2 extends RecyclerView.ViewHolder{
        private TextView zuo1;
        private TextView shi1;
        private TextView biao1;
        private ImageView img;
        public ViewHandle2(@NonNull View itemView) {
            super(itemView);
            zuo1=itemView.findViewById(R.id.zuo1);
            shi1=itemView.findViewById(R.id.shi1);
            biao1=itemView.findViewById(R.id.biao1);
            img=itemView.findViewById(R.id.img);
        }
    }
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A{
        void  orcreate(int send);
    }
}
