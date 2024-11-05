package com.robinbd.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.robinbd.exam.R;

import java.util.ArrayList;

public class VedioActivity extends AppCompatActivity {
    LinearLayout allrohoman, yassen, ayatul,hakko, hasor;
    ImageSlider image_slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vedio);

        allrohoman =findViewById(R.id.allrohoman);
        yassen =findViewById(R.id.yassen);
        ayatul =findViewById(R.id.ayatul);
        hasor =findViewById(R.id.hasor);
        hakko =findViewById(R.id.hakko);


        //image-slider--start//
        image_slider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.all_rohoman, null));
        imageList.add(new SlideModel(R.drawable.all_hakko, null));
        imageList.add(new SlideModel(R.drawable.ayatul, null));
        imageList.add(new SlideModel(R.drawable.hasor, null));
        imageList.add(new SlideModel(R.drawable.sura_yassen, null));
        imageList.add(new SlideModel(R.drawable.images7, null));
        imageList.add(new SlideModel(R.drawable.quran,"hello", null ));
        image_slider.setImageList(imageList, ScaleTypes.CENTER_CROP);

        //imager-slider---end//



        allrohoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.tvdesply = "https://www.youtube.com/embed/0sxLHtVkFg8";
                Intent myintent =new Intent(VedioActivity.this, WebView.class);
                startActivity(myintent);

            }
        });

        yassen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.tvdesply ="https://www.youtube.com/embed/yMg4DXHQooc";
                Intent myintent = new Intent(VedioActivity.this,WebView.class);
                startActivity(myintent);

            }
        });

        ayatul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.tvdesply = "https://www.youtube.com/embed/M1XpLLOhAv4";
                Intent myintent =new Intent(VedioActivity.this,WebView.class);
                startActivity(myintent);

            }
        });

        hasor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.tvdesply = "https://www.youtube.com/embed/VTU5hiyVGZ8";
                Intent myintent =new Intent(VedioActivity.this,WebView.class);
                startActivity(myintent);

            }
        });
        hakko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.tvdesply="https://www.youtube.com/embed/M-IxyZ_8Auk";
                Intent myintent = new Intent(VedioActivity.this,WebView.class);
                startActivity(myintent);
            }
        });


    }
}