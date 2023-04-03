package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.Locale;

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
    LinearLayout vertical10_1, btnPepper, btnMushroom, vertical12_1, btnPepperoni, btnSausage,
    vertical14_1, btnHam, btnPineapple;

    //variables
    int checkboxNum;//counter to prevent selecting more than 3 toppings


    //onCreate
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_order);

        //initializing layouts
        vertical10_1 = findViewById(R.id.vertical10_1);
        btnPepper = findViewById(R.id.btnPepper);
        btnMushroom = findViewById(R.id.btnMushroom);
        vertical12_1 = findViewById(R.id.vertical12_1);
        btnPepperoni = findViewById(R.id.btnPepperoni);
        btnSausage = findViewById(R.id.btnSausage);
        vertical14_1 = findViewById(R.id.vertical14_1);
        btnHam = findViewById(R.id.btnHam);
        btnPineapple = findViewById(R.id.btnPineapple);

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
        btnLanguage.setOnClickListener(changeLanguage);
//        btnSubmit.setOnClickListener(btnSubmitClicked);

        //set radio button event to same listener
        radioSmall.setOnClickListener(radioButtonClicked);
        radioMedium.setOnClickListener(radioButtonClicked);
        radioLarge.setOnClickListener(radioButtonClicked);
        radioXlarge.setOnClickListener(radioButtonClicked);

        //set checkbox event to same listener
        checkPepper.setOnClickListener(checkBoxClicked);
        checkMushroom.setOnClickListener(checkBoxClicked);
        checkPepperoni.setOnClickListener(checkBoxClicked);
        checkSausage.setOnClickListener(checkBoxClicked);
        checkHam.setOnClickListener(checkBoxClicked);
        checkPineapple.setOnClickListener(checkBoxClicked);

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
    };//end language onClick

    //onClick for submit


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

            //create colorstatelist for radio buttons colours -- https://stackoverflow.com/a/29551017
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

    //onclick for checkboxes
    public View.OnClickListener checkBoxClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.checkPepper:
                    displayCheckboxes("pepper");
                    break;
                case R.id.checkMushroom:
                    displayCheckboxes("mushroom");
                    break;
                case R.id.checkPepperoni:
                    displayCheckboxes("pepperoni");
                    break;
                case R.id.checkSausage:
                    displayCheckboxes("sausage");
                    break;
                case R.id.checkHam:
                    displayCheckboxes("ham");
                    break;
                case R.id.checkPineapple:
                    displayCheckboxes("pineapple");
                    break;
            }
        }
    };//end onClick for checkboxes


    //--------------------------display method--------------------------//
    //checkbox display method
    public void displayCheckboxes(String topping) {
        switch (topping) {
            case "pepper":
                if (checkboxNum == 3 && checkPepper.isChecked()) {
                    checkPepper.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                }else if (checkPepper.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical10_1.setVisibility(View.VISIBLE);
                    btnPepper.setVisibility(View.VISIBLE);
                    if (!checkMushroom.isChecked()) {
                        btnMushroom.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkPepper.isChecked() && checkMushroom.isChecked()) {
                    checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnPepper.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical10_1.setVisibility(View.GONE);
                    btnPepper.setVisibility(View.GONE);
                    btnMushroom.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
            case "mushroom":
                if (checkboxNum == 3 && checkMushroom.isChecked()) {
                    checkMushroom.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkMushroom.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical10_1.setVisibility(View.VISIBLE);
                    btnMushroom.setVisibility(View.VISIBLE);
                    if (!checkPepper.isChecked()) {
                        btnPepper.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkMushroom.isChecked() && checkPepper.isChecked()) {
                    checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnMushroom.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical10_1.setVisibility(View.GONE);
                    btnPepper.setVisibility(View.GONE);
                    btnMushroom.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
            case "pepperoni":
                if (checkboxNum == 3 && checkPepperoni.isChecked()) {
                    checkPepperoni.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkPepperoni.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical12_1.setVisibility(View.VISIBLE);
                    btnPepperoni.setVisibility(View.VISIBLE);
                    if (!checkSausage.isChecked()) {
                        btnSausage.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkPepperoni.isChecked() && checkSausage.isChecked()) {
                    checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnPepperoni.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical12_1.setVisibility(View.GONE);
                    btnPepperoni.setVisibility(View.GONE);
                    btnSausage.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
            case "sausage":
                if (checkboxNum == 3 && checkSausage.isChecked()) {
                    checkSausage.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkSausage.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical12_1.setVisibility(View.VISIBLE);
                    btnSausage.setVisibility(View.VISIBLE);
                    if (!checkPepperoni.isChecked()) {
                        btnPepperoni.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkSausage.isChecked() && checkPepperoni.isChecked()) {
                    checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnSausage.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical12_1.setVisibility(View.GONE);
                    btnPepperoni.setVisibility(View.GONE);
                    btnSausage.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
            case "ham":
                if (checkboxNum == 3 && checkHam.isChecked()) {
                    checkHam.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkHam.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical14_1.setVisibility(View.VISIBLE);
                    btnHam.setVisibility(View.VISIBLE);
                    if (!checkPineapple.isChecked()) {
                        btnPineapple.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkHam.isChecked() && checkPineapple.isChecked()) {
                    checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnHam.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical14_1.setVisibility(View.GONE);
                    btnHam.setVisibility(View.GONE);
                    btnPineapple.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
            case "pineapple":
                if (checkboxNum == 3 && checkPepper.isChecked()) {
                    checkPineapple.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkPineapple.isChecked() && checkboxNum < 3) {
                    checkboxNum += 1;

                    checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                    vertical14_1.setVisibility(View.VISIBLE);
                    btnPineapple.setVisibility(View.VISIBLE);
                    if (!checkHam.isChecked()) {
                        btnHam.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkPineapple.isChecked() && checkHam.isChecked()) {
                    checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    btnPineapple.setVisibility(View.INVISIBLE);
                    checkboxNum -= 1;
                } else {
                    checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                    vertical14_1.setVisibility(View.GONE);
                    btnHam.setVisibility(View.GONE);
                    btnPineapple.setVisibility(View.GONE);
                    checkboxNum -= 1;
                }
                break;
        }
    }//end checkbox display method

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
    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("my_lang", "");
        setLocale(language);
    }
}//end order page class