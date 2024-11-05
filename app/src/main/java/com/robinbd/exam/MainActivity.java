package com.robinbd.exam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;
import com.robinbd.exam.activity.Calculator;
import com.robinbd.exam.activity.DigitalTajbi;
import com.robinbd.exam.activity.Namta;
import com.robinbd.exam.activity.Result_BD;
import com.robinbd.exam.activity.VedioActivity;
import com.robinbd.exam.activity.WebView;
import com.robinbd.exam.fragment.HomeFragment;
import com.robinbd.exam.fragment.ProfileFragment;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageSlider image_slider;

    CardView namta,Result,Digital,calculator,sura,quiz;

    MeowBottomNavigation bottomnavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout =findViewById(R.id.drawerlayout);
        navigationView =findViewById(R.id.nevigationview);
        namta =findViewById(R.id.namta);
        Result =findViewById(R.id.Result);
        Digital =findViewById(R.id.Digital);
        calculator =findViewById(R.id.calculator);
        sura =findViewById(R.id.sura);
        quiz =findViewById(R.id.quiz);

        //image-slider--start//
        image_slider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.imag1, null));
        imageList.add(new SlideModel(R.drawable.images4, null));
        imageList.add(new SlideModel(R.drawable.images2, null));
        imageList.add(new SlideModel(R.drawable.images3, null));
        imageList.add(new SlideModel(R.drawable.images6, null));
        imageList.add(new SlideModel(R.drawable.images7, null));
        imageList.add(new SlideModel(R.drawable.images5,"hello", null ));
        image_slider.setImageList(imageList, ScaleTypes.CENTER_CROP);

        //imager-slider---end//

       ///on click --start///-----
        Result.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Result_BD.class));
        });
        Digital.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DigitalTajbi.class));
        });
        calculator.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, Calculator.class));
        } );
        namta.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,Namta.class));
        });
        sura.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, VedioActivity.class));
        });
        quiz.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this," This feature is UPComing.",Toast.LENGTH_LONG).show();
        });

        ///one click--end--//

        //bottom navigation...staet/
        bottomnavigation =findViewById(R.id.bottomnavigation);
        bottomnavigation.add(new MeowBottomNavigation.Model(1,R.drawable.menu));
        bottomnavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_home_24));
        bottomnavigation.add(new MeowBottomNavigation.Model(3, R.drawable.round_settings_24));


        bottomnavigation.show(2,true);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new HomeFragment());
        fragmentTransaction.commit();

        bottomnavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                if (model.getId()==2){
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame,new HomeFragment());
                    fragmentTransaction.commit();

                }if (model.getId()==3){
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame,new ProfileFragment());
                    fragmentTransaction.commit();
                }


                return null;

            }

        });
        //bottom navigation...end///





        /// menu---start-//
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId()==R.id.settinge){
                    Toast.makeText(MainActivity.this,"This is setting",Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId()==R.id.exit){
                    new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.alert)
                            .setTitle("Worning!")
                            .setMessage("Do You want to Exit")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();

                }

                return true;
            }
        });
        ///menu--end--//


    }
}