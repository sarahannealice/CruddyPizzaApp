package com.example.cruddypizzaapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class HistoryPage extends AppCompatActivity {
    //views
    Button btnLanguage, btnNew;

    //recycler variables
    RecyclerView recycler;
    static ArrayList<Order> orderList = new ArrayList<>();
    OrderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_history);

        //recycler setup
        recycler = findViewById(R.id.orderInfo);

//        orderList.add(new Order("sam", "1112223333", 1, 1, 2, 3));

        adapter = new OrderAdapter(orderList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnNew = findViewById(R.id.btnNew);

        //set onclick listeners
        btnLanguage.setOnClickListener(changeLanguage);
//        btnList.setOnClickListener(viewOrder);
//        btnEdit.setOnClickListener();
        btnNew.setOnClickListener(newOrder);

    }//end onCreate


    //--------------------------onClickListeners--------------------------//
    //onClick for language
    View.OnClickListener changeLanguage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Locale.getDefault().getLanguage().equals("eng")) {
                setLocale("zh");
                recreate();
            } else {
                setLocale("eng");
                recreate();
            }
        }
    };

    //onclick to delete order
    View.OnClickListener deleteOrder = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //do nothing
        }
    };

    //onClick for view order
    View.OnClickListener viewOrder = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent detailsIntent = new Intent(HistoryPage.this, DetailsPage.class);
            startActivity(detailsIntent);

        }
    };//end onclick for view order

    //onClick for new order
    View.OnClickListener newOrder = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AppFunctions.checkboxNum = 0;
            AppFunctions.top1 = 0;
            AppFunctions.top2 = 0;
            AppFunctions.top3 = 0;
            AppFunctions.top4 = 0;
            AppFunctions.top5 = 0;
            AppFunctions.top6 = 0;
            Intent newOrderIntent = new Intent(HistoryPage.this, OrderPage.class);
            startActivity(newOrderIntent);
        }
    };


    //--------------------------methods--------------------------//
    //sets locale language
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

    };//end language onClick
}
