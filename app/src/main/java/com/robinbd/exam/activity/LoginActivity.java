package com.robinbd.exam.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.robinbd.exam.MainActivity;
import com.robinbd.exam.R;

public class LoginActivity extends AppCompatActivity {


    TextView loginRedirectText,forgot;
    EditText email,password;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        loginRedirectText=findViewById(R.id.loginRedirectText);
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        signup =findViewById(R.id.signup);
        forgot =findViewById(R.id.forgot);



        //----------no internet ------start------
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(LoginActivity.this.CONNECTIVITY_SERVICE);
        NetworkInfo activenet =manager.getActiveNetworkInfo();

        if (null !=activenet){
            if (activenet.getType()==ConnectivityManager.TYPE_MOBILE || activenet.getType() ==ConnectivityManager.TYPE_WIFI){

            }
        }else { new AlertDialog.Builder(LoginActivity.this)
                .setIcon(R.drawable.baseline_wifi_off_24 )
                .setTitle("Worning!")
                .setCancelable(false)
                .setMessage("Please Check Your internet ")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                }).show();

        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myemail =email.getText().toString();
                String mypassword = password.getText().toString();
                SharedPreferences sharedPreferences =getSharedPreferences("userdettres", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("emailkey",myemail);
                editor.putString("passwordkey",mypassword);
                editor.commit();

                email.setText(" ");
                password.setText(" ");



                Intent myint =new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myint);
                if (myemail.isEmpty()  || mypassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please  fill up all requirements fields", Toast.LENGTH_LONG).show();
                    email.setError("enter email");
                    password.setError("enter password");
                }

                }
        });






        ////onclick-----//
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myint =new Intent(LoginActivity.this, Registration.class);
                startActivity(myint);

            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}