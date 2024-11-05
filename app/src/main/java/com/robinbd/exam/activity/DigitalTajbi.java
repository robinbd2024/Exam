package com.robinbd.exam.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.R;

public class DigitalTajbi extends AppCompatActivity {

    TextView tvcount;
    Button addbutton, subbutton, restbuttom;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_digital_tajbi);
        tvcount =findViewById(R.id.tvcount);
        addbutton =findViewById(R.id.addbutton);
        subbutton =findViewById(R.id.subbutton);
        restbuttom =findViewById(R.id.restbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                tvcount.setText(""+count);

            }
        });

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count--;
                tvcount.setText(""+count);

            }
        });


        restbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count=0;
                tvcount.setText(""+count);

            }
        });










    }
}