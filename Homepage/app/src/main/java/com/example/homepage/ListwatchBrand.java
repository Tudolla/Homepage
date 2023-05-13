package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListwatchBrand extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<WatchModel> watchModel;

    GridLayoutManager gridLayoutManager ;

    WatchAdapter watchAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listwatch_brand);

        recyclerView = findViewById(R.id.listWatchBrand);

        watchModel = new ArrayList<>();
        dataInsertStatic();

        gridLayoutManager = new GridLayoutManager(this , 2 , LinearLayoutManager.VERTICAL , false);
        gridLayoutManager.setSpanSizeLookup(new MySpanSizeLookup(15,1,2));
        recyclerView.setLayoutManager(gridLayoutManager);

        watchAdapter = new WatchAdapter(getApplicationContext(),watchModel);
        recyclerView.setAdapter(watchAdapter);
    }

    private void dataInsertStatic() {
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cone,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.ctwo,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cthree,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfor,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cone,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cthree,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfor,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cone,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cthree,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cthree,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfor,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cone,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cthree,"Cassio"));
        watchModel.add(new WatchModel(R.drawable.cfive,"Cassio"));

    }

}