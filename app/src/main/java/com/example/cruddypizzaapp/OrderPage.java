package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
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
    int LIMIT = 3;
    int checkboxNum;//counter to prevent selecting more than 3 toppings
    //counter for additional of same topping
    int sameTop1 = 0;//green pepper
    int sameTop2 = 0;//mushroom
    int sameTop3 = 0;//pepperoni
    int sameTop4 = 0;//sausage
    int sameTop5 = 0;//diced ham
    int sameTop6 = 0;//pineapple
    int sameTopTotal = sameTop1 + sameTop2 + sameTop3 + sameTop4 + sameTop5 + sameTop6;
    int radioCount;//counter for radio buttons in group


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
        btnSubmit.setOnClickListener(submitClicked);

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

        //set additional of same topping listeners
        normalPepper.setOnClickListener(normalTopping);
        doublePepper.setOnClickListener(doubleTopping);
        triplePepper.setOnClickListener(tripleTopping);
        //--//
        normalMushroom.setOnClickListener(normalTopping);
        doubleMushroom.setOnClickListener(doubleTopping);
        tripleMushroom.setOnClickListener(tripleTopping);
        //--//
        normalPepperoni.setOnClickListener(normalTopping);
        doublePepperoni.setOnClickListener(doubleTopping);
        triplePepperoni.setOnClickListener(tripleTopping);
        //--//
        normalSausage.setOnClickListener(normalTopping);
        doubleSausage.setOnClickListener(doubleTopping);
        tripleSausage.setOnClickListener(tripleTopping);
        //--//
        normalHam.setOnClickListener(normalTopping);
        doubleHam.setOnClickListener(doubleTopping);
        tripleHam.setOnClickListener(tripleTopping);
        //--//
        normalPineapple.setOnClickListener(normalTopping);
        doublePineapple.setOnClickListener(doubleTopping);
        triplePineapple.setOnClickListener(tripleTopping);



    }//end onCreate


    //--------------------------onClickListeners--------------------------//
    //onClick for language
    View.OnClickListener changeLanguage = v -> {
        if (Locale.getDefault().getLanguage().equals("eng")) {
            setLocale("zh");
            recreate();
        } else {
            setLocale("eng");
            recreate();
        }
    };//end language onClick

    //onClick for radio buttons
    public View.OnClickListener radioButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //https://stackoverflow.com/a/37893080
            radioCount = radiogroup.getChildCount();

            for (int i = 0; i < radioCount; i++) {
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
    public View.OnClickListener checkBoxClicked = view -> {

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
    };//end onClick for checkboxes


    //--ADDITIONAL SAME TOPPINGS--//
    //onclick for normal amount topping
    public View.OnClickListener normalTopping = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.normalPepper:
                    sameTop1 = 0;
                    displaySameToppings("normPep");
                    break;
                case R.id.normalMushroom:
                    sameTop2 = 0;
                    displaySameToppings("normMush");
                    break;
                case R.id.normalPepperoni:
                    sameTop3 = 0;
                    displaySameToppings("normRoni");
                    break;
                case R.id.normalSausage:
                    sameTop4 = 0;
                    displaySameToppings("normSaus");
                    break;
                case R.id.normalHam:
                    sameTop5 = 0;
                    displaySameToppings("normHam");
                    break;
                case R.id.normalPineapple:
                    sameTop6 = 0;
                    displaySameToppings("normPine");
                    break;
            }
        }
    };//end normal topping onclick

    //onclick for double amount topping
    public View.OnClickListener doubleTopping = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.doublePepper:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblPep");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.doubleMushroom:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblMush");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.doublePepperoni:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblRoni");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.doubleSausage:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblSaus");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.doubleHam:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblHam");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.doublePineapple:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 1, sameTopTotal)) {
                        sameTop1 = 1;
                        displaySameToppings("dblPine");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };//end double topping onclick

    //onclick for triple amount topping
    public View.OnClickListener tripleTopping = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.triplePepper:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triPep");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.tripleMushroom:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triMush");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.triplePepperoni:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triRoni");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.tripleSausage:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triSaus");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.tripleHam:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triHam");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.triplePineapple:
                    if (AppFunctions.validateExtraTopping(checkboxNum, 2, sameTopTotal)) {
                        sameTop1 = 2;
                        displaySameToppings("triPine");
                    } else {
                        Toast.makeText(OrderPage.this, "3 toppings have already be selected", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };//end double topping onclick

    //onClick for submit
    public View.OnClickListener submitClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //validation of all fields
            if (!AppFunctions.validateName(String.valueOf(textName.getText()))) {
                Toast.makeText(OrderPage.this, "invalid name", Toast.LENGTH_SHORT).show();
            } else if (!AppFunctions.validatePhone(String.valueOf(textPhone.getText()))) {
                Toast.makeText(OrderPage.this, "invalid phone number", Toast.LENGTH_SHORT).show();
            } else if (!AppFunctions.validateRadios(radiogroup.getChildCount(), radiogroup)) {
                Toast.makeText(OrderPage.this, "select a size", Toast.LENGTH_SHORT).show();
            } else if (!AppFunctions.validateCheckBoxes(checkPepper, checkMushroom, checkPepperoni,
                    checkSausage,checkHam, checkPineapple)) {
                Toast.makeText(OrderPage.this, "select at least 1 topping", Toast.LENGTH_SHORT).show();
            }
            //get checkbox -- check that one's
            //add to database method
        }
    };


    //--------------------------display method--------------------------//
    //checkbox display method
    public void displayCheckboxes(String topping) {
        switch (topping) {

            //PEPPER//
            case "pepper":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkPepper.isChecked()) {
                    checkPepper.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                }else if (checkPepper.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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

            //MUSHROOM//
            case "mushroom":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkMushroom.isChecked()) {
                    checkMushroom.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkMushroom.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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

            //PEPPERONI//
            case "pepperoni":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkPepperoni.isChecked()) {
                    checkPepperoni.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkPepperoni.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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

            //SAUSAGE//
            case "sausage":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkSausage.isChecked()) {
                    checkSausage.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkSausage.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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

            //DICED HAM//
            case "ham":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkHam.isChecked()) {
                    checkHam.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkHam.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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

            //PINEAPPLE//
            case "pineapple":
                if ((checkboxNum+sameTopTotal) == LIMIT && checkPepper.isChecked()) {
                    checkPineapple.setChecked(false);
                    Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
                } else if (checkPineapple.isChecked() && (checkboxNum+sameTopTotal) < LIMIT) {
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
        }//end switch statement
    }//end checkbox display method

    //display same topping buttons
    public void displaySameToppings(String topAmount) {
        //GREEN PEPPER
        if (topAmount.equals("normPep")) {
            normalPepper.setImageResource(R.drawable.normal_selected);
            doublePepper.setImageResource(R.drawable.double_deselected);
            triplePepper.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblPep")) {
            normalPepper.setImageResource(R.drawable.normal_deselected);
            doublePepper.setImageResource(R.drawable.double_selected);
            triplePepper.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triPep")) {
            normalPepper.setImageResource(R.drawable.normal_deselected);
            doublePepper.setImageResource(R.drawable.double_deselected);
            triplePepper.setImageResource(R.drawable.triple_selected);
        }//MUSHROOM
        else if (topAmount.equals("normMush")) {
            normalMushroom.setImageResource(R.drawable.normal_selected);
            doubleMushroom.setImageResource(R.drawable.double_deselected);
            tripleMushroom.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblMush")) {
            normalMushroom.setImageResource(R.drawable.normal_deselected);
            doubleMushroom.setImageResource(R.drawable.double_selected);
            tripleMushroom.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triMush")) {
            normalMushroom.setImageResource(R.drawable.normal_deselected);
            doubleMushroom.setImageResource(R.drawable.double_deselected);
            tripleMushroom.setImageResource(R.drawable.triple_selected);
        }//PEPPERONI
        else if (topAmount.equals("normRoni")) {
            normalPepperoni.setImageResource(R.drawable.normal_selected);
            doublePepperoni.setImageResource(R.drawable.double_deselected);
            triplePepperoni.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblRoni")) {
            normalPepperoni.setImageResource(R.drawable.normal_deselected);
            doublePepperoni.setImageResource(R.drawable.double_selected);
            triplePepperoni.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triRoni")) {
            normalPepperoni.setImageResource(R.drawable.normal_deselected);
            doublePepperoni.setImageResource(R.drawable.double_deselected);
            triplePepperoni.setImageResource(R.drawable.triple_selected);
        }//SAUSAGE
        else if (topAmount.equals("normSaus")) {
            normalSausage.setImageResource(R.drawable.normal_selected);
            doubleSausage.setImageResource(R.drawable.double_deselected);
            tripleSausage.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblSaus")) {
            normalSausage.setImageResource(R.drawable.normal_deselected);
            doubleSausage.setImageResource(R.drawable.double_selected);
            tripleSausage.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triSaus")) {
            normalSausage.setImageResource(R.drawable.normal_deselected);
            doubleSausage.setImageResource(R.drawable.double_deselected);
            tripleSausage.setImageResource(R.drawable.triple_selected);
        }//DICE HAM
        else if (topAmount.equals("normHam")) {
            normalHam.setImageResource(R.drawable.normal_selected);
            doubleHam.setImageResource(R.drawable.double_deselected);
            tripleHam.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblHam")) {
            normalHam.setImageResource(R.drawable.normal_deselected);
            doubleHam.setImageResource(R.drawable.double_selected);
            tripleHam.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triHam")) {
            normalHam.setImageResource(R.drawable.normal_deselected);
            doubleHam.setImageResource(R.drawable.double_deselected);
            tripleHam.setImageResource(R.drawable.triple_selected);
        }//PINEAPPLE
        else if (topAmount.equals("normPine")) {
            normalPineapple.setImageResource(R.drawable.normal_selected);
            doublePineapple.setImageResource(R.drawable.double_deselected);
            triplePineapple.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("dblPine")) {
            normalPineapple.setImageResource(R.drawable.normal_deselected);
            doublePineapple.setImageResource(R.drawable.double_selected);
            triplePineapple.setImageResource(R.drawable.triple_deselected);
        } else if (topAmount.equals("triPine")) {
            normalPineapple.setImageResource(R.drawable.normal_deselected);
            doublePineapple.setImageResource(R.drawable.double_deselected);
            triplePineapple.setImageResource(R.drawable.triple_selected);
        }
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
    }
}//end order page class