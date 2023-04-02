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
    LinearLayout vertical10_1, btnPepper, btnMushroom, vertical12_1, btnPepperoni, btnSausage,
    vertical14_1, btnHam, btnPineapple;

    //variables

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
//        btnLanguage.setOnClickListener(btnLanguageClicked);
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

    public View.OnClickListener checkBoxClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.checkPepper:
                    if (checkPepper.isChecked()) {
                        checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical10_1.setVisibility(View.VISIBLE);
                        btnPepper.setVisibility(View.VISIBLE);
                        if (!checkMushroom.isChecked()) {
                            btnMushroom.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkPepper.isChecked() && checkMushroom.isChecked()) {
                        checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnPepper.setVisibility(View.INVISIBLE);
                    } else {
                        checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical10_1.setVisibility(View.GONE);
                        btnPepper.setVisibility(View.GONE);
                        btnMushroom.setVisibility(View.GONE);
                    }
                    break;
                case R.id.checkMushroom:
                    if (checkMushroom.isChecked()) {
                        checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical10_1.setVisibility(View.VISIBLE);
                        btnMushroom.setVisibility(View.VISIBLE);
                        if (!checkPepper.isChecked()) {
                            btnPepper.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkMushroom.isChecked() && checkPepper.isChecked()) {
                        checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnMushroom.setVisibility(View.INVISIBLE);
                    } else {
                        checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical10_1.setVisibility(View.GONE);
                        btnPepper.setVisibility(View.GONE);
                        btnMushroom.setVisibility(View.GONE);
                    }
                    break;
                case R.id.checkPepperoni:
                    if (checkPepperoni.isChecked()) {
                        checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical12_1.setVisibility(View.VISIBLE);
                        btnPepperoni.setVisibility(View.VISIBLE);
                        if (!checkSausage.isChecked()) {
                            btnSausage.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkPepperoni.isChecked() && checkSausage.isChecked()) {
                        checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnPepperoni.setVisibility(View.INVISIBLE);
                    } else {
                        checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical12_1.setVisibility(View.GONE);
                        btnPepperoni.setVisibility(View.GONE);
                        btnSausage.setVisibility(View.GONE);
                    }
                    break;
                case R.id.checkSausage:
                    if (checkSausage.isChecked()) {
                        checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical12_1.setVisibility(View.VISIBLE);
                        btnSausage.setVisibility(View.VISIBLE);
                        if (!checkPepperoni.isChecked()) {
                            btnPepperoni.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkSausage.isChecked() && checkPepperoni.isChecked()) {
                        checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnSausage.setVisibility(View.INVISIBLE);
                    } else {
                        checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical12_1.setVisibility(View.GONE);
                        btnPepperoni.setVisibility(View.GONE);
                        btnSausage.setVisibility(View.GONE);
                    }
                    break;
                case R.id.checkHam:
                    if (checkHam.isChecked()) {
                        checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical14_1.setVisibility(View.VISIBLE);
                        btnHam.setVisibility(View.VISIBLE);
                        if (!checkPineapple.isChecked()) {
                            btnPineapple.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkHam.isChecked() && checkPineapple.isChecked()) {
                        checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnHam.setVisibility(View.INVISIBLE);
                    } else {
                        checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical14_1.setVisibility(View.GONE);
                        btnHam.setVisibility(View.GONE);
                        btnPineapple.setVisibility(View.GONE);
                    }
                    break;
                case R.id.checkPineapple:
                    if (checkPineapple.isChecked()) {
                        checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                        vertical14_1.setVisibility(View.VISIBLE);
                        btnPineapple.setVisibility(View.VISIBLE);
                        if (!checkHam.isChecked()) {
                            btnHam.setVisibility(View.INVISIBLE);
                        }
                    } else if (!checkPineapple.isChecked() && checkHam.isChecked()) {
                        checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        btnPineapple.setVisibility(View.INVISIBLE);
                    } else {
                        checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                        vertical14_1.setVisibility(View.GONE);
                        btnHam.setVisibility(View.GONE);
                        btnPineapple.setVisibility(View.GONE);
                    }
                    break;
            }
        }
    };//end onClick for checkboxes
}//end order page class