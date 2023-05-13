package com.example.homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView revCategory;
    CategoryAdapter categoryAdapter;


    ArrayAdapter<String> arrayAdapter;


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FloatingActionButton   Btn , home , favorite , cart , send , lucky;

    boolean check = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revCategory =findViewById(R.id.listProduct);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManagerlayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        revCategory.setLayoutManager(linearLayoutManagerlayoutManager);
        categoryAdapter.setData(getProduct());
        revCategory.setAdapter(categoryAdapter);




        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomePage.this);


        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        Btn = findViewById(R.id.floatingBtn);
        home = findViewById(R.id.floatingHome);
        favorite = findViewById(R.id.floatingFavorite);
        cart = findViewById(R.id.floatingCart);
        send = findViewById(R.id.floatingSend);
        lucky = findViewById(R.id.floatingLucky);

//        lucky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomePage.this , SpinWheel.class);
//                startActivity(intent);
//            }
//        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Cart.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ListwatchBrand.class);
                startActivity(intent);
            }
        });





        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check){
                    send.show();
                    lucky.show();
                    home.show();
                    favorite.show();
                    cart.show();
                    check=false;
                }else{
                    home.hide();
                    send.hide();
                    lucky.hide();
                    favorite.hide();
                    cart.hide();
                    check=true;
                }
            }
        });



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomePage.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:

                        Toast.makeText(HomePage.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.music:

                        Intent intentMusic = new Intent(HomePage.this , MainMusic.class);
                        startActivity(intentMusic);
                        break;
                    case R.id.about:
                        Intent intentAbout = new Intent(HomePage.this , About.class);
                        startActivity(intentAbout);
                        break;

                    default:
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }


        });
    }

    private List<Category> getProduct(){
        List<Category> listCate = new ArrayList<>();
        List<ProductLabel> listP = new ArrayList<>();

        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cone , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cfive , "Cassio"));
        listP.add(new ProductLabel(R.drawable.ctwo , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));

        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));
        listP.add(new ProductLabel(R.drawable.cthree , "Cassio"));


        listCate.add(new Category("Luxury Diamond" , listP));
        listCate.add(new Category("Vip Watch" , listP));
        listCate.add(new Category("Normal" , listP));
        listCate.add(new Category("Thuong hieu aa" , listP));

        return listCate;







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.searchBar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Tim kiem dong ho di");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                arrayAdapter.getFilter().filter(newtext);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }




}