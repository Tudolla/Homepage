package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainMusic extends AppCompatActivity {
    private ArrayList<MusicClass> arrayList;
    private CustomMusicAdapter adapter;
    private ListView ListOfSongs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_music);
        getSupportActionBar().setTitle("Music Entertainment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        ListOfSongs = (ListView) findViewById(R.id.ListOfSongs);
        arrayList = new ArrayList<>();
        arrayList.add(new MusicClass("Một con vịt", R.raw.motconvit));
        arrayList.add(new MusicClass("Morning mood", R.raw.morningmood));
        arrayList.add(new MusicClass("Nơi đảo xa ", R.raw.morningmood));
        arrayList.add(new MusicClass("Quốc ca", R.raw.morningmood));
        arrayList.add(new MusicClass("Em của ngày hôm qua", R.raw.motconvit));
        arrayList.add(new MusicClass("Chào buổi sáng", R.raw.motconvit));
        arrayList.add(new MusicClass("Ngày ấy", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));
        arrayList.add(new MusicClass("Hay lam", R.raw.motconvit));

        adapter = new CustomMusicAdapter(this, R.layout.music_item,arrayList);
        ListOfSongs.setAdapter(adapter);
    }


}