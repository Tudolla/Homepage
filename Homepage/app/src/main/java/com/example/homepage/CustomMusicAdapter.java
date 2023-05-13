package com.example.homepage;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CustomMusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MusicClass> arrayList;

    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    public CustomMusicAdapter(Context context, int layout, ArrayList<MusicClass> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    public ArrayList<MusicClass> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<MusicClass> arrayList) {
        this.arrayList = arrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHoler {
        TextView textName;
        ImageView ivPlay, ivStop;
    }

    int[] colors = {Color.rgb(124, 88, 104), Color.rgb(49, 98, 104), Color.rgb(64, 181, 134),
            Color.rgb(208, 124, 134), Color.rgb(53, 177, 134), Color.rgb(205, 208, 26),
            Color.rgb(164, 213, 163) , Color.rgb(101, 165, 110) , Color.rgb(194, 86, 110),
            Color.rgb(33, 147, 237) , Color.rgb(222, 147, 237)
    };






    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        final ViewHoler viewHoler;
        if (convertView == null) {
            viewHoler = new ViewHoler();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHoler.textName = (TextView) convertView.findViewById(R.id.txtName);
            viewHoler.ivPlay = (ImageView) convertView.findViewById(R.id.ivPlay);
            viewHoler.ivStop = (ImageView) convertView.findViewById(R.id.ivStop);
            convertView.setTag(viewHoler);
            int color = colors[new Random().nextInt(colors.length)];
            convertView.setBackgroundColor(color);


        } else {
            viewHoler = (ViewHoler) convertView.getTag();

        }
        final MusicClass musicClass = arrayList.get(position);



        viewHoler.textName.setText(musicClass.getName());


        viewHoler.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    mediaPlayer = MediaPlayer.create(context, musicClass.getSong());
                    flag = false;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    viewHoler.ivPlay.setImageResource(R.drawable.base_play);
                } else {
                    mediaPlayer.start();
                    viewHoler.ivPlay.setImageResource(R.drawable.base_stop);
                }


            }
        });

        viewHoler.ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHoler.ivPlay.setImageResource(R.drawable.base_play);

            }
        });


        return convertView;
    }
}
