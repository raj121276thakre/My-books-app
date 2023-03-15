package com.rajapps.mybooksapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;



import com.google.android.material.navigation.NavigationView;
import com.rajapps.mybooksapp.ebook.EbookActivity;
import com.rajapps.mybooksapp.ebooksSE.EbookActivitySE;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    CardView cardFESem1, cardFESem2, cardSESem1, cardSESem2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardFESem1 = findViewById(R.id.cardFESem1);
        cardFESem2 = findViewById(R.id.cardFESem2);
        cardSESem1 = findViewById(R.id.cardSE);
        cardSESem2 = findViewById(R.id.cardSESem2);


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_menu);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        cardFESem1.setOnClickListener(this::onClick);
        cardFESem2.setOnClickListener(this::onClick);
        cardSESem1.setOnClickListener(this::onClick);
        cardSESem2.setOnClickListener(this::onClick);




    }// function


    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){


            case R.id.cardFESem1:
                intent = new Intent(MainActivity.this, EbookActivity.class);
                startActivity(intent);
                break;

//            case R.id.cardFESem2:
//                intent = new Intent(MainActivity.this, EbookActivity.class);
//                startActivity(intent);
//                break;
//
            case R.id.cardSE:
                intent = new Intent(MainActivity.this, EbookActivitySE.class);
                startActivity(intent);
                break;

//            case R.id.cardSESem2:
//                intent = new Intent(MainActivity.this, UploadPdfSEsem2.class);
//                startActivity(intent);
//                break;




        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_video:
                Toast.makeText(this, "navigation_video", Toast.LENGTH_SHORT).show();
                break;


            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbookActivity.class));
                break;


            case R.id.navigation_theme:
                Toast.makeText(this, "navigation_theme", Toast.LENGTH_SHORT).show();
                break;


            case R.id.navigation_website:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.secsomeshwar.ac.in/"));
                startActivity(intent2);
                break;


            case R.id.navigation_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +
                            getPackageName())));
                    // google play

                } catch (Exception ex) {
                    startActivity(new
                            Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" +
                            getPackageName())));
                    // website google play

                }

                break;


            case R.id.navigation_share:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Share  app with your friends and colleagues!  Download now " + "https://www.amazon.com/gp/product/B0BVWF2HL3";

                String shareSub = "Best App for college";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                break;


            case R.id.navigation_developer:
                Toast.makeText(this, "navigation_developer", Toast.LENGTH_SHORT).show();
                break;
        }


        //drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }




}

