package com.example.galleydemo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        ImageView fullImage = findViewById(R.id.img_full);
        int imgId = getIntent().getExtras().getInt("img_id");

        fullImage.setImageResource(imgId);
    }
}