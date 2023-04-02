package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class TitlePage extends AppCompatActivity {
    //views
    Button btnLanguage, btnStart, btnSearch;

    //onCreate for title page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnStart = findViewById(R.id.btnStart);
        btnSearch = findViewById(R.id.btnSearch);

        //onClick listeners
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newOrderIntent = new Intent(TitlePage.this, OrderPage.class);
                startActivity(newOrderIntent);
            }
        });//end Onclick for start order

        //btnSearch.setOnClickListener();

    }//end onCreate
}//end title page class