package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.sql.SQLOutput;
import java.util.Locale;

public class OrderPage extends AppCompatActivity {
    //views
    Button btnLanguage, btnSubmit;
    EditText textName, textPhone;
    RadioGroup radiogroup;
    RadioButton radioSmall, radioMedium, radioLarge, radioXlarge;
    static CheckBox checkPepper, checkMushroom, checkPepperoni, checkSausage, checkHam, checkPineapple;
    static ImageButton normalPepper, doublePepper, triplePepper, normalMushroom, doubleMushroom, tripleMushroom,
            normalPepperoni, doublePepperoni, triplePepperoni, normalSausage, doubleSausage, tripleSausage,
            normalHam, doubleHam, tripleHam, normalPineapple, doublePineapple, triplePineapple;
    static LinearLayout vertical10_1, btnPepper, btnMushroom, vertical12_1, btnPepperoni, btnSausage,
    vertical14_1, btnHam, btnPineapple;

    //variables
    static int LIMIT = 3;
    static boolean valid;//states if double/triple the same topping can be selected
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

            //create colorstatelist for radio buttons/checkboxes -- https://stackoverflow.com/a/29551017
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
                valid = true;
                //resets the numbers within validation
                AppFunctions.validateExtraTopping(0,1);
                if (!DisplayFunctions.displayCheckboxes("pepper")) {
                    burntToast();
                }
                break;
            case R.id.checkMushroom:
                valid = true;
                AppFunctions.validateExtraTopping(0,2);
                if (!DisplayFunctions.displayCheckboxes("mushroom")) {
                    burntToast();
                }
                break;
            case R.id.checkPepperoni:
                valid = true;
                AppFunctions.validateExtraTopping(0,3);
                if (!DisplayFunctions.displayCheckboxes("pepperoni")) {
                    burntToast();
                }
                break;
            case R.id.checkSausage:
                valid = true;
                AppFunctions.validateExtraTopping(0,4);
                if (!DisplayFunctions.displayCheckboxes("sausage")) {
                    burntToast();
                }
                break;
            case R.id.checkHam:
                valid = true;
                AppFunctions.validateExtraTopping(0,5);
                if (!DisplayFunctions.displayCheckboxes("ham")) {
                    burntToast();
                }
                break;
            case R.id.checkPineapple:
                valid = true;
                AppFunctions.validateExtraTopping(0,6);
                if (!DisplayFunctions.displayCheckboxes("pineapple")) {
                    burntToast();
                }
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
                    AppFunctions.validateExtraTopping(0, 1);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normPep");
                    break;
                case R.id.normalMushroom:
                    AppFunctions.validateExtraTopping(0, 2);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normMush");
                    break;
                case R.id.normalPepperoni:
                    AppFunctions.validateExtraTopping(0, 3);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normRoni");
                    break;
                case R.id.normalSausage:
                    AppFunctions.validateExtraTopping(0, 4);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normSaus");
                    break;
                case R.id.normalHam:
                    AppFunctions.validateExtraTopping(0, 5);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normHam");
                    break;
                case R.id.normalPineapple:
                    AppFunctions.validateExtraTopping(0, 6);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normPine");
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
                    if (AppFunctions.validateExtraTopping(1, 1)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblPep");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleMushroom:
                    if (AppFunctions.validateExtraTopping(1, 2)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblMush");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePepperoni:
                    if (AppFunctions.validateExtraTopping(1, 3)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblRoni");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleSausage:
                    if (AppFunctions.validateExtraTopping(1, 4)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblSaus");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleHam:
                    if (AppFunctions.validateExtraTopping(1, 5)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblHam");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePineapple:
                    if (AppFunctions.validateExtraTopping(1, 6)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblPine");
                    } else {
                        burntToast();
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
                    System.out.println(AppFunctions.sameTopTotal + " sametoptotal before extra topping validation\n");
                    System.out.println(AppFunctions.checkboxNum + " checkboxnum before validation\n");
                    if (AppFunctions.validateExtraTopping(2, 1)) {
                        System.out.println(AppFunctions.sameTopTotal + " after sametoptotal += 2\n");
                        valid = false;
                        DisplayFunctions.displaySameToppings("triPep");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleMushroom:
                    if (AppFunctions.validateExtraTopping(2, 2)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triMush");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePepperoni:
                    if (AppFunctions.validateExtraTopping(2, 3)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triRoni");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleSausage:
                    if (AppFunctions.validateExtraTopping(2, 4)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triSaus");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleHam:
                    if (AppFunctions.validateExtraTopping(2, 5)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triHam");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePineapple:
                    if (AppFunctions.validateExtraTopping(2, 6)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triPine");
                    } else {
                        burntToast();
                    }
                    break;
            }
        }
    };//end double topping onclick
    //--END ADDITIONAL SAME TOPPINGS--//


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
            //add to database method
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
    }

    //toast for more than 3 toppings
    public void burntToast() {
        Toast.makeText(getApplicationContext(), "you've already selected 3 toppings", Toast.LENGTH_SHORT).show();
    }//end toast method
}//end order page class