package com.example.galleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> myImage = new ArrayList<>(Arrays.asList(R.drawable.image1, R.drawable.image2, R.drawable.image3
            , R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.myGridView);
        gridView.setAdapter(new ImageAdapter(this, myImage));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = myImage.get(position);
                showDialogBox(itemPosition);
            }
        });
    }

    public void showDialogBox( int itemPosition){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        TextView imageName = dialog.findViewById(R.id.image_name);
        ImageView image = dialog.findViewById(R.id.img);
        Button btnOpen = dialog.findViewById(R.id.btn_open);
        TextView btnClose = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(itemPosition);

        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());

        imageName.setText(name);
        image.setImageResource(itemPosition);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FullViewActivity.class);
                intent.putExtra("img_id",itemPosition);
                startActivity(intent);
            }
        });

        dialog.show();

    }
}