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
    static boolean valid;//states if double the same topping can be selected
    int radioCount;//counter for radio buttons in group
    //counters
    //counter for additional of same topping
    static int sameTop1;//green pepper
    static int sameTop2;//mushroom
    static int sameTop3;//pepperoni
    static int sameTop4;//sausage
    static int sameTop5;//diced ham
    static int sameTop6;//pineapple
    int sameTopTotal = sameTop1 + sameTop2 + sameTop3 + sameTop4 + sameTop5 + sameTop6;


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
                if (!DisplayFunctions.displayCheckboxes("pepper", sameTopTotal)) {
                    burntToast();
                }
                break;
            case R.id.checkMushroom:
                if (!DisplayFunctions.displayCheckboxes("mushroom", sameTopTotal)) {
                    burntToast();
                }
                break;
            case R.id.checkPepperoni:
                if (!DisplayFunctions.displayCheckboxes("pepperoni", sameTopTotal)) {
                    burntToast();
                }
                break;
            case R.id.checkSausage:
                if (!DisplayFunctions.displayCheckboxes("sausage", sameTopTotal)) {
                    burntToast();
                }
                break;
            case R.id.checkHam:
                if (!DisplayFunctions.displayCheckboxes("ham", sameTopTotal)) {
                    burntToast();
                }
                break;
            case R.id.checkPineapple:
                if (!DisplayFunctions.displayCheckboxes("pineapple", sameTopTotal)) {
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
                    sameTop1 = 0;
                    valid = true;
                    DisplayFunctions.displaySameToppings("normPep");
                    break;
                case R.id.normalMushroom:
                    sameTop2 = 0;
                    valid = true;
                    DisplayFunctions.displaySameToppings("normMush");
                    break;
                case R.id.normalPepperoni:
                    sameTop3 = 0;
                    valid = true;
                    DisplayFunctions.displaySameToppings("normRoni");
                    break;
                case R.id.normalSausage:
                    sameTop4 = 0;
                    valid = true;
                    DisplayFunctions.displaySameToppings("normSaus");
                    break;
                case R.id.normalHam:
                    sameTop5 = 0;
                    valid = true;
                    DisplayFunctions.displaySameToppings("normHam");
                    break;
                case R.id.normalPineapple:
                    sameTop6 = 0;
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
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblPep");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleMushroom:
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblMush");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePepperoni:
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblRoni");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleSausage:
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblSaus");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleHam:
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblHam");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePineapple:
                    if (AppFunctions.validateExtraTopping(1, sameTopTotal)) {
                        sameTop1 = 1;
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
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
                        valid = false;
                        DisplayFunctions.displaySameToppings("triPep");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleMushroom:
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
                        valid = false;
                        DisplayFunctions.displaySameToppings("triMush");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePepperoni:
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
                        valid = false;
                        DisplayFunctions.displaySameToppings("triRoni");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleSausage:
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
                        valid = false;
                        DisplayFunctions.displaySameToppings("triSaus");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleHam:
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
                        valid = false;
                        DisplayFunctions.displaySameToppings("triHam");
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePineapple:
                    if (AppFunctions.validateExtraTopping(2, sameTopTotal)) {
                        sameTop1 = 2;
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
    }



    //select topping checkbox
    public void selectCheckbox(String topping) {
        switch (topping) {
            case "pepper":
                checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
            case "mush":
                checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
            case "roni":
                checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
            case "saus":
                checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
            case "ham":
                checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
            case "pine":
                checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_purple)));
                break;
        }
    }

    //deselect topping checkbox
    public void deselectCheckbox(String topping) {
        switch (topping) {
            case "pepper":
                checkPepper.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
            case "mush":
                checkMushroom.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
            case "roni":
                checkPepperoni.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
            case "saus":
                checkSausage.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
            case "ham":
                checkHam.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
            case "pine":
                checkPineapple.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
                break;
        }
    }
}//end order page class