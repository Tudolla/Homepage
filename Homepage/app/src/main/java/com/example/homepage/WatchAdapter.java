package com.example.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import java.util.ArrayList;
import java.util.List;


public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.watchViewHolder> {
    Context context ;
    ArrayList<WatchModel> watchList;
    public WatchAdapter(Context context, ArrayList<WatchModel> list ){
        this.context=context;
        this.watchList=list;


    }



    @NonNull
    @Override
    public watchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new watchViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_watch,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull watchViewHolder holder, int position) {
        WatchModel p = watchList.get(position);
        if(p == null){
            return;
        }
        holder.imageView.setImageResource(p.getImageWatch());
        holder.textView.setText(p.getNameWatch());



    }

    @Override
    public int getItemCount() {
        return watchList.size();
    }

    // tao ra thang watchViewHolder nay de gan len tren : create
    public class watchViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView ;
        TextView textView;

        public watchViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgDongho);
            textView = itemView.findViewById(R.id.txtDongho);
        }
    }
}
