package com.example.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category> mCate;

    public CategoryAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Category> list){
        this.mCate = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mCate.get(position);
        if(category == null){
            return;
        }
        holder.nameCate.setText(category.getCategory());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL , false);
        holder.revProduct.setLayoutManager(layoutManager);
        ProductAdapter p = new ProductAdapter();
        p.setData(category.getLists());
        holder.revProduct.setAdapter(p);

    }

    @Override
    public int getItemCount() {
        if(mCate != null){
            return mCate.size();
        }
        return 0;
    }

    public  class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView nameCate ;
        private RecyclerView revProduct;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCate = itemView.findViewById(R.id.txtCategory);
            revProduct = itemView.findViewById(R.id.rev_product);
        }
    }
}
