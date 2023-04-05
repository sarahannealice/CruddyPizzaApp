package com.example.cruddypizzaapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button btnLanguage, btnView, btnEdit, btnNew;
    TextView orderTV;
    ImageView garbage;

    //recycler variables
    RecyclerView recycler;
    static ArrayList<Order> orderList = new ArrayList<>();
    OrderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_history);


        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnView = findViewById(R.id.btnView);
        btnEdit = findViewById(R.id.btnEdit);
        btnNew = findViewById(R.id.btnNew);

        //set onclick listeners
        btnLanguage.setOnClickListener(changeLanguage);
        btnView.setOnClickListener(viewOrderClicked);


        //recycler setup
        recycler = findViewById(R.id.orderInfo);

        orderList.add(new Order("sam", "1112223333", 1, 1, 2, 3));

        adapter = new OrderAdapter(orderList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
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

    //onclick for order textview
    View.OnClickListener orderClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //https://stackoverflow.com/a/32301027
            if (orderTV.getBackground().equals(ContextCompat.getDrawable(HistoryPage.this, R.drawable.border_selected))) {
                orderTV.setBackground(ContextCompat.getDrawable(HistoryPage.this, R.drawable.border_deselected));
            } else {
                orderTV.setBackground(ContextCompat.getDrawable(HistoryPage.this, R.drawable.border_selected));
            }

//            int count = vertical2_1.getChildCount();
//
//            for (int i = 0; i < count; i++) {
//                TextView x = (TextView) vertical2_1.getChildAt(i);
//
//            }
        }
    };

    //onClick for view order
    View.OnClickListener viewOrderClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent detailsIntent = new Intent(HistoryPage.this, DetailsPage.class);
            startActivity(detailsIntent);

//            int count = vertical2_1.getChildCount();

//            for (int i = 0; i < count; i++) {
//                TextView x = (TextView) vertical2_1.getChildAt(i);
//
//                if (x.getBackground().equals("@drawable/border_selected")) {
//                    //will also contain order markers from database
//                    Intent detailsIntent = new Intent(HistoryPage.this, DetailsPage.class);
//                    startActivity(detailsIntent);
//                    break;
//                } else {
//                    continue;
//                }
//            }
        }
    };//end onclick for view order



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
