package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    private RecyclerView rvCart;
    private CartAdapter cartAdapter;
    Button btnBuy ;
    ImageButton imgBtn;
    TextView totalPrice , textPrice ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rv_cart);
        btnBuy = findViewById(R.id.idBuy);
        imgBtn = findViewById(R.id.idAll);
        totalPrice = findViewById(R.id.idTotalPrice);
        textPrice = findViewById(R.id.txtTotalPrice);
        cartAdapter = new CartAdapter(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvCart.setLayoutManager(layoutManager);

        cartAdapter.setData(getListCart());
        ArrayList<CartModel> arrlist = getListCart();
        rvCart.setAdapter(cartAdapter);

        cartAdapter.setOnItemClickListener(new CartAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position){
                arrlist.remove(position);
                cartAdapter.notifyItemRemoved(position);
                cartAdapter.setData(arrlist);
                rvCart.setAdapter(cartAdapter);
                Toast.makeText(Cart.this, "You have removed a product!", Toast.LENGTH_SHORT).show();
            }
        });
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(Gravity.BOTTOM);


            }
        });
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = 0;
                for (CartModel cartModel : arrlist) {
                    total += Integer.parseInt(cartModel.getPrice());
                    totalPrice.setText("" + total);


                }
            }


        });




    }
//    private void showPrice(){
//        int total = 0 ;
//        for(CartModel cartModel : getListCart()){
//            total += Integer.parseInt(cartModel.getPrice());
//            totalPrice.setText(""+total);
//
//
//        }
//
//    }
    
    private  void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT , WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }
        Button btnCancel = dialog.findViewById(R.id.idCancel);
        Button btnConfirm = dialog.findViewById(R.id.idConfirm);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cart.this, "Mua hang thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    private ArrayList<CartModel> getListCart()
    {
        ArrayList<CartModel> list = new ArrayList<>();
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));
        list.add(new CartModel(R.drawable.cfor, "Vustion BlackBary", "202000"));

        return list ;

    }
}