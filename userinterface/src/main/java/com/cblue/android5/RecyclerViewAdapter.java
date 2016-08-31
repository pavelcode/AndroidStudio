package com.cblue.android5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cblue.androidstudio.R;

import java.util.List;

/**
 * Created by pavel on 16/5/26.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> implements View.OnClickListener {

    Context context;
    List<RecyclerViewItem> items;

    OnRecyclerViewItemClickListener listener;

    public void setItemClickListener(OnRecyclerViewItemClickListener listener){
        this.listener = listener;
    }


    //定义点击接口
    interface OnRecyclerViewItemClickListener{
        void onItemClickListener(View v,int position);
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onItemClickListener(view,(int)view.getTag());
        }
    }



    public RecyclerViewAdapter(Context context,List<RecyclerViewItem> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,null);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        view.setOnClickListener(this);
        return recyclerViewHolder;
    }


    //相当于ListView中getView，设置每一个item的布局
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerViewItem item = items.get(position);
        //这里的itemView是源码中有的，代表每一个item视图
        /*
        TextView text1 = (TextView) holder.itemView.findViewById(R.id.recyclerview_item_tv01) ;
        text1.setText(item.getMsg());
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.recyclerview_item_iv01);
        img.setImageResource(item.getImgID());*/

        holder.textView.setText(item.getMsg());
        holder.imageView.setImageResource(item.getImgID());
        //设置消息
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView ;
        TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recyclerview_item_tv01);
            imageView = (ImageView) itemView.findViewById(R.id.recyclerview_item_iv01);

        }
    }
}
