package com.robinbd.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.R;

public class Result_BD extends AppCompatActivity {

    CardView sscresult,HscResult,JscResult,PscResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result_bd);
        sscresult=findViewById(R.id.sscResult);
        HscResult=findViewById(R.id.HscResult);
        JscResult=findViewById(R.id.JscResult);
        PscResult=findViewById(R.id.PscResult);

        sscresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               WebView.tvdesply ="https://www.flickr.com/photos/resultkit/49131573906/in/album-72157711959151316";
                startActivity(new Intent(Result_BD.this,WebView.class));

            }
        });
        HscResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebView.tvdesply ="https://www.flickr.com/photos/resultkit/49131573906/in/album-72157711959151316";
                startActivity(new Intent(Result_BD.this,WebView.class));

            }
        });
        JscResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebView.tvdesply ="https://www.flickr.com/photos/resultkit/49131573906/in/album-72157711959151316";
                startActivity(new Intent(Result_BD.this,WebView.class));

            }
        });
        PscResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebView.tvdesply ="https://www.flickr.com/photos/resultkit/49131573906/in/album-72157711959151316";
                startActivity(new Intent(Result_BD.this,WebView.class));

            }
        });





    }
}