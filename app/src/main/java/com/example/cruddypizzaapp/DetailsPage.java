package com.example.cruddypizzaapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class
DetailsPage extends AppCompatActivity {
    //views
    Button btnLanguage, btnNew;
    ImageButton btnEdit, btnList;
    static TextView orderNumTV, detailsTV;

    //variable
    String KEY = "KEY";
    int order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_details);

        //initializing textview
        orderNumTV = findViewById(R.id.orderNumTV);
        detailsTV = findViewById(R.id.detailsTV);

        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnNew = findViewById(R.id.btnNew);
        btnEdit = findViewById(R.id.btnEdit);
        btnList = findViewById(R.id.btnList);

        //getting key from recycler
        Intent editIntent = getIntent();
        order = editIntent.getIntExtra(KEY, 0);

        //calling method to display order information
        DisplayDetailsFunctions.DisplayOrderDetails(HistoryPage.orderList.get(order));

        //setting onClickListeners
        btnLanguage.setOnClickListener(changeLanguage);
        btnList.setOnClickListener(searchOrder);
        btnEdit.setOnClickListener(editOrder);
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

    //onclick to search order
    View.OnClickListener searchOrder = v -> {
        //goes to history page
        Intent orderHistoryIntent = new Intent(DetailsPage.this, HistoryPage.class);
        startActivity(orderHistoryIntent);
    };

    //onclick for edit order
    View.OnClickListener editOrder = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent editIntent = new Intent(DetailsPage.this, OrderPage.class);
            editIntent.putExtra(KEY, order);
            startActivity(editIntent);
        }
    };

    //onClick for new order
    View.OnClickListener newOrder = v -> {
        //reset order variables
        AppFunctions.checkboxNum = 0;
        AppFunctions.top1 = 0;
        AppFunctions.top2 = 0;
        AppFunctions.top3 = 0;
        AppFunctions.top4 = 0;
        AppFunctions.top5 = 0;
        AppFunctions.top6 = 0;
        OrderPage.toppings.clear();

        OrderPage.btnUpdate.setVisibility(View.GONE);
        OrderPage.btnSubmit.setVisibility(View.VISIBLE);

        Intent newOrderIntent = new Intent(DetailsPage.this, OrderPage.class);
        newOrderIntent.putExtra("KEY", true);
        startActivity(newOrderIntent);
    };//end new order onclick


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
}//end details page
