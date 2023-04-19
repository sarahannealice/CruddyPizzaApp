package com.example.cruddypizzaapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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
        orderList.clear();//resets display -- https://stackoverflow.com/a/41843923
        adapter = new OrderAdapter(orderList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        orderHistory();


        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnNew = findViewById(R.id.btnNew);

        //set onclick listeners
        btnLanguage.setOnClickListener(changeLanguage);
        btnNew.setOnClickListener(newOrder);

        if (true) {

        }

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

    //onClick for new order
    View.OnClickListener newOrder = v -> {
        if (OrderPage.toppings.size() == 0) {
            Intent newOrderIntent = new Intent(HistoryPage.this, OrderPage.class);
            startActivity(newOrderIntent);
        } else {
            //reset order variables
            AppFunctions.checkboxNum = 0;
            AppFunctions.top1 = 0;
            AppFunctions.top2 = 0;
            AppFunctions.top3 = 0;
            AppFunctions.top4 = 0;
            AppFunctions.top5 = 0;
            AppFunctions.top6 = 0;
            OrderPage.toppings.clear();
            OrderPage.btnSubmit.setText(getResources().getString(R.string.submit));

            Intent newOrderIntent = new Intent(HistoryPage.this, OrderPage.class);
            newOrderIntent.putExtra("KEY", true);
            startActivity(newOrderIntent);
        }

    };//end new order onclick


    //--------------------------methods--------------------------//
    //sets up order history from database
    private void orderHistory() {
        DBAdapter dbAdapter = new DBAdapter(this);

        try {
            dbAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(HistoryPage.this, "failed to load orders", Toast.LENGTH_SHORT).show();
        }

        Cursor data = dbAdapter.getAllOrders();

        if (data.moveToFirst()) {
            do {
                orderList.add(new Order(
                        data.getInt(0),
                        data.getString(1),
                        data.getString(2),
                        data.getInt(3),
                        data.getInt(4),
                        data.getInt(5),
                        data.getInt(6)
                ));
                System.out.println("order: " + data.getInt(0) +
                        "name: " + data.getString(1) +
                        "phone: " + data.getString(2) +
                        "size: " + data.getInt(3) +
                        "top1: " + data.getInt(4) +
                        "top2: " + data.getInt(5) +
                        "top3: " + data.getInt(6));
            } while (data.moveToNext());
        } else {
            Toast.makeText(HistoryPage.this, "no orders found", Toast.LENGTH_SHORT).show();
        }
        dbAdapter.close();
    }

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
}//end history page
