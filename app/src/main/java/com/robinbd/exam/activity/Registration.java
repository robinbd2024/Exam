package com.robinbd.exam.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.R;
import com.robinbd.exam.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity {

    EditText fristname, lastrname, remail, phone, rPassword;
    CheckBox checkbox;
    Button registration, buttonok;
    TextView mywidget, tvtex,singup;
    AlertDialog alertDialog;
    RadioGroup rediogroup;
    RadioButton radioButton;
    //spinner class------//
    String[] county_name;
    Spinner spinnerid;

    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registration = findViewById(R.id.registration);
        fristname = findViewById(R.id.fristname);
        lastrname = findViewById(R.id.lastrname);
        remail = findViewById(R.id.remail);
        phone = findViewById(R.id.phone);
        rPassword = findViewById(R.id.rPassword);
        checkbox = findViewById(R.id.checkbox);
        tvtex = findViewById(R.id.tvtex);
        singup = findViewById(R.id.singup);
        rediogroup = findViewById(R.id.rediogroup);


        mywidget = findViewById(R.id.mywidget);
        mywidget.setSelected(true);


        //spinner start---//
        county_name = getResources().getStringArray(R.array.county_name);
        spinnerid = findViewById(R.id.spinnerid);
        ArrayAdapter<String> array = new ArrayAdapter<String>(this, R.layout.itam_spinner, R.id.tvtex1, county_name);
        spinnerid.setAdapter(array);
        ///spinner --end--//


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int selectedid = rediogroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedid);

                if (rediogroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Registration.this, "please select gender", Toast.LENGTH_SHORT).show();


                } else {
                    String selet1 = radioButton.getText().toString();

                    SharedPreferences sharedPreferences1 =getSharedPreferences("radiodata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences1.edit();
                    editor.putString("seletkey",selet1);
                    editor.commit();

                }
                //checkbox--start--//
                if (checkbox.isChecked()) {
                    String name = fristname.getText().toString();
                    String usname = lastrname.getText().toString();
                    String email = remail.getText().toString();
                    String mphone = phone.getText().toString();
                    String passw = rPassword.getText().toString();
                    String spinner = spinnerid.getSelectedItem().toString();

                    SharedPreferences sharedPreferences =getSharedPreferences("userdata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("pastnamekey",name);
                    editor.putString("lastnamekey",usname);
                    editor.putString("emailkey",email);
                    editor.putString("phonekey",mphone);
                    editor.putString("passwordkey",passw);
                    editor.putString("spinnerkey",spinner);
                   
                    editor.commit();



                    fristname.setText("");
                    lastrname.setText("");
                    remail.setText("");
                    phone.setText("");
                    rPassword.setText("");
                    if (name.isEmpty() || usname.isEmpty() || email.isEmpty() || mphone.isEmpty() || passw.isEmpty()) {
                        Toast.makeText(Registration.this, "please  fill up all requirements fields", Toast.LENGTH_LONG).show();
                        fristname.setError("enter username");
                        lastrname.setError("enter lastname");
                        phone.setError("enter number");
                        remail.setError("enter email");
                        rPassword.setError("enter password");
                    }
                    //---alert dialog----stadt--//
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.alert, null);

                  /* MediaPlayer myplayer = MediaPlayer.create(Registration.this,R.raw.thankyou);
                    myplayer.start();*/

                    AlertDialog dialog = new AlertDialog.Builder(Registration.this).setView(view).create();
                    dialog.setCancelable(false);
                    dialog.show();

                    buttonok = view.findViewById(R.id.buttonok);

                    buttonok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }


                    });
                    ///--alert-- dialog--end-///


                } else {

                    Toast.makeText(Registration.this, "please Check checkmox", Toast.LENGTH_LONG).show();

                }  ///checkbox--end--//







            }
        });

        singup.setOnClickListener(v -> {
            startActivity(new Intent(Registration.this,LoginActivity.class));
        });

    }
}




