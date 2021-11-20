package com.example.galleydemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> myImageList;

    public ImageAdapter(Context context, ArrayList<Integer> myImageList) {
        this.context = context;
        this.myImageList = myImageList;
    }

    @Override
    public int getCount() {
        return myImageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return myImageList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;
        if(imageView != null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(350,450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageResource(myImageList.get(position));
        return imageView;
    }
}
