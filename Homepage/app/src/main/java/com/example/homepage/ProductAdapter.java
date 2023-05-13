package com.example.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.annotation.GlideModule;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>  {
    public List<ProductLabel> mlist;

    public void setData(List<ProductLabel> list){
        this.mlist = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product , parent , false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductLabel p = mlist.get(position);
        if(p == null){
            return;
        }
        holder.imgWatch.setImageResource(p.getResoureImage());
        holder.txtName.setText(p.getName()) ;

    }

    @Override
    public int getItemCount() {
        if(mlist != null){
            return mlist.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
    private ImageView imgWatch ;
    private TextView txtName ;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imgWatch = itemView.findViewById(R.id.imageLabel);
        txtName = itemView.findViewById(R.id.textLabel);
    }

    }
}
