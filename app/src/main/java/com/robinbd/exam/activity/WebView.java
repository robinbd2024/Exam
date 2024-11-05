package com.robinbd.exam.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.robinbd.exam.R;

import java.util.ArrayList;

public class WebView extends AppCompatActivity {
    android.webkit.WebView webview;
    public static String tvdesply =" ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview =findViewById(R.id.wevview);



        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(tvdesply);



    }
}