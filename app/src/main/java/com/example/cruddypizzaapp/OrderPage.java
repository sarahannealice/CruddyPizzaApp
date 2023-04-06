package com.example.cruddypizzaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
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

    //for creating order objects
    static int size;
    static String printSize;
    static ArrayList<Integer> pepper = new ArrayList<Integer>(){{add(1);}};
    static ArrayList<Integer> mush = new ArrayList<Integer>(){{add(2);}};
    static ArrayList<Integer> roni = new ArrayList<Integer>(){{add(3);}};
    static ArrayList<Integer> saus = new ArrayList<Integer>(){{add(4);}};
    static ArrayList<Integer> ham = new ArrayList<Integer>(){{add(5);}};
    static ArrayList<Integer> pine = new ArrayList<Integer>(){{add(6);}};
    static ArrayList<Integer> toppings = new ArrayList<>();



    //onCreate
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
            int radioCount = radiogroup.getChildCount();

            for (int i = 0; i < radioCount; i++) {
                RadioButton x = (RadioButton) radiogroup.getChildAt(i);
                x.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.blush_purple)));
            }

            //create colorstatelist for radio buttons/checkboxes -- https://stackoverflow.com/a/29551017
            ColorStateList colorStateList = new ColorStateList(
                    new int[][]{
                            new int[]{android.R.attr.state_enabled},//enabled
                            new int[]{-android.R.attr.state_enabled}, //disabled
                    },
                    new int[]{
                            Color.rgb(74, 78, 105),//enabled
                            Color.rgb(154, 140, 152),//disabled
                    }
            );

            switch (view.getId()) {
                case R.id.radioSmall:
                    radioSmall.setButtonTintList(colorStateList);
                    printSize = getResources().getString(R.string.sm);
                    size = 1;
                    break;
                case R.id.radioMedium:
                    radioMedium.setButtonTintList(colorStateList);
                    printSize = getResources().getString(R.string.med);
                    size = 2;
                    break;
                case R.id.radioLarge:
                    radioLarge.setButtonTintList(colorStateList);
                    printSize = getResources().getString(R.string.l);
                    size = 3;
                    break;
                case R.id.radioXlarge:
                    radioXlarge.setButtonTintList(colorStateList);
                    printSize = getResources().getString(R.string.xl);
                    size = 4;
                    break;
            }
        }
    };//end onClick for radio buttons

    //onclick for checkboxes
    public View.OnClickListener checkBoxClicked = view -> {
        switch (view.getId()) {
            case R.id.checkPepper:
                valid = true;
                //resets the numbers for mini buttons within validation
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
                    //for submit button to create order object
                    toppings.removeAll(pepper);
                    toppings.add(1);
                    break;
                case R.id.normalMushroom:
                    AppFunctions.validateExtraTopping(0, 2);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normMush");
                    toppings.removeAll(mush);
                    toppings.add(2);
                    break;
                case R.id.normalPepperoni:
                    AppFunctions.validateExtraTopping(0, 3);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normRoni");
                    toppings.removeAll(roni);
                    toppings.add(3);
                    break;
                case R.id.normalSausage:
                    AppFunctions.validateExtraTopping(0, 4);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normSaus");
                    toppings.removeAll(saus);
                    toppings.add(4);
                    break;
                case R.id.normalHam:
                    AppFunctions.validateExtraTopping(0, 5);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normHam");
                    toppings.removeAll(ham);
                    toppings.add(5);
                    break;
                case R.id.normalPineapple:
                    AppFunctions.validateExtraTopping(0, 6);
                    valid = true;
                    DisplayFunctions.displaySameToppings("normPine");
                    toppings.removeAll(pine);
                    toppings.add(6);
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
                        toppings.removeAll(pepper);
                        toppings.add(1);
                        toppings.add(1);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleMushroom:
                    if (AppFunctions.validateExtraTopping(1, 2)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblMush");
                        toppings.removeAll(mush);
                        toppings.add(2);
                        toppings.add(2);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePepperoni:
                    if (AppFunctions.validateExtraTopping(1, 3)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblRoni");
                        toppings.removeAll(roni);
                        toppings.add(3);
                        toppings.add(3);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleSausage:
                    if (AppFunctions.validateExtraTopping(1, 4)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblSaus");
                        toppings.removeAll(saus);
                        toppings.add(4);
                        toppings.add(4);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doubleHam:
                    if (AppFunctions.validateExtraTopping(1, 5)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblHam");
                        toppings.removeAll(ham);
                        toppings.add(5);
                        toppings.add(5);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.doublePineapple:
                    if (AppFunctions.validateExtraTopping(1, 6)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("dblPine");
                        toppings.removeAll(pine);
                        toppings.add(6);
                        toppings.add(6);
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
                    if (AppFunctions.validateExtraTopping(2, 1)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triPep");
                        toppings.removeAll(pepper);
                        toppings.add(1);
                        toppings.add(1);
                        toppings.add(1);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleMushroom:
                    if (AppFunctions.validateExtraTopping(2, 2)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triMush");
                        toppings.removeAll(mush);
                        toppings.add(2);
                        toppings.add(2);
                        toppings.add(2);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePepperoni:
                    if (AppFunctions.validateExtraTopping(2, 3)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triRoni");
                        toppings.removeAll(roni);
                        toppings.add(3);
                        toppings.add(3);
                        toppings.add(3);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleSausage:
                    if (AppFunctions.validateExtraTopping(2, 4)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triSaus");
                        toppings.removeAll(saus);
                        toppings.add(4);
                        toppings.add(4);
                        toppings.add(4);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.tripleHam:
                    if (AppFunctions.validateExtraTopping(2, 5)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triHam");
                        toppings.removeAll(ham);
                        toppings.add(5);
                        toppings.add(5);
                        toppings.add(5);
                    } else {
                        burntToast();
                    }
                    break;
                case R.id.triplePineapple:
                    if (AppFunctions.validateExtraTopping(2, 6)) {
                        valid = false;
                        DisplayFunctions.displaySameToppings("triPine");
                        toppings.removeAll(pine);
                        toppings.add(6);
                        toppings.add(6);
                        toppings.add(6);
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
            String name = textName.getText().toString();
            String phone = textPhone.getText().toString();
            //to print
            String printSize = null;
            String printTop1 = null;
            String printTop2 = null;
            String printTop3 = null;
            //initializing toppings as 0 (no topping)
            int top1 = 0;
            int top2 = 0;
            int top3 = 0;

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
            } else {
                //to find out how many toppings were selected
                switch (toppings.size()) {
                    case 1:
                        top1 = toppings.get(0);
                        break;
                    case 2:
                        top1 = toppings.get(0);
                        top2 = toppings.get(1);
                        break;
                    case 3:
                        top1 = toppings.get(0);
                        top2 = toppings.get(1);
                        top3 = toppings.get(2);
                        break;
                }
                //print statements for debuggind
                System.out.println("\nsize of arraylist: " + toppings.size());
                System.out.println("\nname: " + textName.getText());
                System.out.println("\nphone: " + textPhone.getText());
                System.out.println("\nsize: " + size);
                System.out.println("\ntop1: " + top1);
                System.out.println("\ntop2: " + top2);
                System.out.println("\ntop3: " + top3);
                int size = HistoryPage.orderList.size();
                Order order = new Order(size+1, name, phone, size, top1, top2, top3);
                HistoryPage.orderList.add(order);

                if (top1 == top2 && top1 == top3) {
                    switch (top1) {
                        case 1:
                            printTop1 = getResources().getString(R.string.pepper);
                            printTop2 = getResources().getString(R.string.pepper);
                            printTop3 = getResources().getString(R.string.pepper);
                            break;
                        case 2:
                            printTop1 = getResources().getString(R.string.mushroom);
                            printTop2 = getResources().getString(R.string.mushroom);
                            printTop3 = getResources().getString(R.string.mushroom);
                            break;
                        case 3:
                            printTop1 = getResources().getString(R.string.pepperoni);
                            printTop2 = getResources().getString(R.string.pepperoni);
                            printTop3 = getResources().getString(R.string.pepperoni);
                            break;
                        case 4:
                            printTop1 = getResources().getString(R.string.sausage);
                            printTop2 = getResources().getString(R.string.sausage);
                            printTop3 = getResources().getString(R.string.sausage);
                            break;
                        case 5:
                            printTop1 = getResources().getString(R.string.ham);
                            printTop2 = getResources().getString(R.string.ham);
                            printTop3 = getResources().getString(R.string.ham);
                            break;
                        case 6:
                            printTop1 = getResources().getString(R.string.pineapple);
                            printTop2 = getResources().getString(R.string.pineapple);
                            printTop3 = getResources().getString(R.string.pineapple);
                            break;
                    }
                }

                //goes to history page
                Intent orderHistoryIntent = new Intent(OrderPage.this, HistoryPage.class);
                startActivity(orderHistoryIntent);
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