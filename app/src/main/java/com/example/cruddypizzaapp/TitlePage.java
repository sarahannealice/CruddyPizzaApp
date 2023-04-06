package com.example.cruddypizzaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.database.*;
import java.io.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class TitlePage extends AppCompatActivity {
    //views
    Button btnLanguage, btnStart, btnSearch;

    //variable
    List<String> eng;
    List<String> zh;

    //onCreate for title page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_title);

        //initializing string array
//        Resources res = getResources();
//        eng = Arrays.asList(getResources().getStringArray(R.array.english));
//        zh = Arrays.asList(getResources().getStringArray(R.array.chinese));

        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnStart = findViewById(R.id.btnStart);
        btnSearch = findViewById(R.id.btnSearch);

        //set onClick Listeners
        btnLanguage.setOnClickListener(changeLanguage);
        btnStart.setOnClickListener(startOrder);
        btnSearch.setOnClickListener(searchOrder);

    }//end onCreate


    //--------------------------onClickListeners--------------------------//
    //change language onClick
    View.OnClickListener changeLanguage = v -> { //anonymous new view.onclick listener can be replaced with lambda
        if (Locale.getDefault().getLanguage().equals("en")) {
            setLocale("zh");
            recreate();
        } else {
            setLocale("en");
            recreate();
        }
    };

    //start order
    View.OnClickListener startOrder = view -> {
        Intent newOrderIntent = new Intent(TitlePage.this, OrderPage.class);
        newOrderIntent.putExtra("KEY", true);
        startActivity(newOrderIntent);
    };

    //search order
    View.OnClickListener searchOrder = v -> {
        Intent historyIntent = new Intent(TitlePage.this, HistoryPage.class);
        startActivity(historyIntent);
    };


    //--------------------------methods--------------------------//
    //sets locale language
    //https://www.youtube.com/watch?v=zILw5eV9QBQ&ab_channel=AtifPervaiz
    void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("my_lang", lang);
        editor.apply();
    }

    //loads previously used language
    private void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("my_lang", "");
        setLocale(language);
    }
}//end title page class