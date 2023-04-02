package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class OrderPage extends AppCompatActivity {
    //views
    Button btnLanguage, btnSubmit;
    EditText textName, textPhone;
    RadioGroup radiogroup;
    RadioButton radioSmall, radioMedium, radioLarge, radioXlarge;
    CheckBox checkPepper, checkMushroom, checkPepperoni, checkSausage, checkHam, checkPineapple;
    ImageButton normalPepper, doublePepper, triplePepper, normalMushroom, doubleMushroom, tripleMushroom,
            normalPepperoni, doublePepperoni, triplePepperoni, normalSausage, doubleSausage, tripleSausage,
            normalHam, doubleHam, tripleHam, normalPineapple, doublePineapple, triplePineapple;

    //variables

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //initializing buttons
        btnLanguage = findViewById(R.id.btnLanguage);
        btnSubmit = findViewById(R.id.btnSubmit);

        //initializing edit texts
        textName = findViewById(R.id.textName);
        textPhone = findViewById(R.id.textPhone);

        //initializing radio buttons/group
        radiogroup = findViewById(R.id.radiogroup);
        radioSmall = findViewById(R.id.radioSmall);
        radioMedium = findViewById(R.id.radioMedium);
        radioLarge = findViewById(R.id.radioLarge);
        radioXlarge = findViewById(R.id.radioXlarge);

        //initializing checkboxes
        checkPepper = findViewById(R.id.checkPepper);
        checkMushroom = findViewById(R.id.checkMushroom);
        checkPepperoni = findViewById(R.id.checkPepperoni);
        checkSausage = findViewById(R.id.checkSausage);
        checkHam = findViewById(R.id.checkHam);
        checkPineapple = findViewById(R.id.checkPineapple);

        //initializing image buttons
        normalPepper = findViewById(R.id.normalPepper);
        doublePepper = findViewById(R.id.doublePepper);
        triplePepper = findViewById(R.id.triplePepper);
        normalMushroom = findViewById(R.id.normalMushroom);
        doubleMushroom = findViewById(R.id.doubleMushroom);
        tripleMushroom = findViewById(R.id.tripleMushroom);
        normalPepperoni = findViewById(R.id.normalPepperoni);
        doublePepperoni = findViewById(R.id.doublePepperoni);
        triplePepperoni = findViewById(R.id.triplePepperoni);
        normalSausage = findViewById(R.id.normalSausage);
        doubleSausage = findViewById(R.id.doubleSausage);
        tripleSausage = findViewById(R.id.tripleSausage);
        normalHam = findViewById(R.id.normalHam);
        doubleHam = findViewById(R.id.doubleHam);
        tripleHam = findViewById(R.id.tripleHam);
        normalPineapple = findViewById(R.id.normalPineapple);
        doublePineapple = findViewById(R.id.doublePineapple);
        triplePineapple = findViewById(R.id.triplePineapple);

        //set button event
//        btnLanguage.setOnClickListener(btnLanguageClicked);
//        btnSubmit.setOnClickListener(btnSubmitClicked);

        //set radio button event to same listener
        radioSmall.setOnClickListener(radioButtonClicked);
        radioMedium.setOnClickListener(radioButtonClicked);
        radioLarge.setOnClickListener(radioButtonClicked);
        radioXlarge.setOnClickListener(radioButtonClicked);

    }//end onCreate

    //onClick for radio buttons
    public View.OnClickListener radioButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //https://stackoverflow.com/a/37893080
            int count = radiogroup.getChildCount();

            for (int i = 0; i < count; i++) {
                RadioButton x = (RadioButton) radiogroup.getChildAt(i);
                x.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
            }

            //create colorstatelist for radio buttons
            ColorStateList enabledColour = new ColorStateList(
                    new int[][]{
                            new int[]{android.R.attr.state_enabled}//enabled
                    },
                    new int[]{
                            Color.rgb(74, 78, 105)//enabled
                    }
            );

            ColorStateList disabledColour = new ColorStateList(
                    new int[][]{
                            new int[]{-android.R.attr.state_enabled}, //disabled
                    },
                    new int[]{
                            Color.rgb(154, 140, 152),//disabled
                    }
            );

            switch (view.getId()) {
                case R.id.radioSmall:
                    if (radioSmall.getButtonTintList().equals(enabledColour)) {
                        radioSmall.setButtonTintList(disabledColour);
                    } else {
                        radioSmall.setButtonTintList(enabledColour);
                    }
                    break;
                case R.id.radioMedium:
                    if (radioMedium.getButtonTintList().equals(enabledColour)) {
                        radioMedium.setButtonTintList(disabledColour);
                    } else {
                        radioMedium.setButtonTintList(enabledColour);
                    }
                    break;
                case R.id.radioLarge:
                    if (radioLarge.getButtonTintList().equals(enabledColour)) {
                        radioLarge.setButtonTintList(disabledColour);
                    } else {
                        radioLarge.setButtonTintList(enabledColour);
                    }
                    break;
                case R.id.radioXlarge:
                    if (radioXlarge.getButtonTintList().equals(enabledColour)) {
                        radioXlarge.setButtonTintList(disabledColour);
                    } else {
                        radioXlarge.setButtonTintList(enabledColour);
                    }
                    break;
            }
        }
    };//end onClick for radio buttons
}