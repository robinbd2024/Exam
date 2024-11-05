package com.robinbd.exam.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.R;

public class Calculator extends AppCompatActivity {
    EditText button1, button2;
    Button buttonplas, buttonmanis, buttongun, buttonbag, buttonac;
    TextView tvresult;
    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        buttonplas = findViewById(R.id.buttonplus);
        buttonmanis = findViewById(R.id.buttonmanis);
        buttongun = findViewById(R.id.buttongun);
        buttonbag = findViewById(R.id.buttonbag);
        buttonac = findViewById(R.id.buttonac);
        tvresult = findViewById(R.id.tvresult);

        buttonplas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonfust = button1.getText().toString();
                String buttonsend = button2.getText().toString();

                int myfast = Integer.parseInt(buttonfust);
                int mysend = Integer.parseInt(buttonsend);
                Result = myfast + mysend;
                tvresult.setText("" + Result);

            }
        });

        buttonmanis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonfust = button1.getText().toString();
                String buttonsend = button2.getText().toString();

                int myfast = Integer.parseInt(buttonfust);
                int mysend = Integer.parseInt(buttonsend);
                Result = myfast - mysend;
                tvresult.setText("" + Result);

            }
        });

        buttongun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonfust = button1.getText().toString();
                String buttonsend = button2.getText().toString();

                int myfast = Integer.parseInt(buttonfust);
                int mysend = Integer.parseInt(buttonsend);
                Result = myfast * mysend;
                tvresult.setText("" + Result);
            }

        });

        buttonbag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonfust = button1.getText().toString();
                String buttonsend = button2.getText().toString();

                int myfast = Integer.parseInt(buttonfust);
                int mysend = Integer.parseInt(buttonsend);
                Result = myfast / mysend;
                tvresult.setText("" + Result);
            }
        });

        buttonac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(" ");
                button2.setText(" ");
                tvresult.setText(" ");

            }
        });

    }
}