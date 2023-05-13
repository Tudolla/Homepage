package com.example.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context mcontext;
    private List<CartModel> mcart;
    private TextView move ;
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        listener =  clickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public CartAdapter(Context mcontext) {
        this.mcontext = mcontext;

    }
    public void setData(List<CartModel> list){
        this.mcart = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new CartViewHolder(view ,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartModel cartModel = mcart.get(position);
        if(cartModel == null){
            return;
        }
        holder.imageView.setImageResource(cartModel.getCartImage());
        holder.title.setText(cartModel.getTitle());
        holder.price.setText(cartModel.getPrice());

    }

    @Override
    public int getItemCount() {
        if(mcart != null){
            return mcart.size();
        }
        return 0 ;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title , price ;

        public CartViewHolder(@NonNull View itemView , OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.id_imgCart);
            title = itemView.findViewById(R.id.idTitle);
            move = itemView.findViewById(R.id.idMove);
            price = itemView.findViewById(R.id.idPrice);

            move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getPosition());


                }
            });
        }
    }

}
