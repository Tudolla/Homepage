package com.example.homepage;

import androidx.recyclerview.widget.GridLayoutManager;

public class MySpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    int spanPos; int spanCount1; int spanCount2;

    public MySpanSizeLookup(int spanPos, int spanCount1, int spanCount2) {
        this.spanCount1=spanCount1;
        this.spanCount2=spanCount2;
        this.spanPos=spanPos;
    }

    @Override
    public int getSpanSize(int position) {
        return(position % spanPos==0?spanCount2:spanCount1);
    }
}
